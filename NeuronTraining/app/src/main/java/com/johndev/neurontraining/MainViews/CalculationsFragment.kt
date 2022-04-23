package com.johndev.neurontraining.MainViews

import NeuronTraining.NeuronTraining
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.johndev.neurontraining.Adapters.ChargeDataAdapter
import com.johndev.neurontraining.BottomOptions.BottomOptionsFragment
import com.johndev.neurontraining.DialogFragments.DialogDetailsDataFragment
import com.johndev.neurontraining.DialogFragments.DialogLoadOperationsFragment
import com.johndev.neurontraining.DialogFragments.PassData.PASS_COSTO
import com.johndev.neurontraining.DialogFragments.PassData.PASS_ID
import com.johndev.neurontraining.DialogFragments.PassData.PASS_JW
import com.johndev.neurontraining.DialogFragments.PassData.PASS_W
import com.johndev.neurontraining.Interfaces.OnChargeData
import com.johndev.neurontraining.MainViews.ChargeDataFragment.Companion.valuesX
import com.johndev.neurontraining.MainViews.ChargeDataFragment.Companion.valuesY
import com.johndev.neurontraining.Models.ChargeData
import com.johndev.neurontraining.Models.ResultsPerceptron
import com.johndev.neurontraining.OperationsGraphicsActivity
import com.johndev.neurontraining.R
import com.johndev.neurontraining.databinding.FragmentCalculationsBinding
import com.johndev.neurontraining.format.NumberFormat

class CalculationsFragment : Fragment(), OnChargeData {

    private var _binding: FragmentCalculationsBinding? = null
    private val binding get() = _binding!!
    private var formatNum = NumberFormat()
    private var neuronTraining = NeuronTraining()
    private lateinit var adapter: ChargeDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureButtons()
        configRecyclerView()
        binding.chipIterations.setOnCheckedChangeListener { compoundButton, b -> validForms() }
        binding.chipMetaCost.setOnCheckedChangeListener { compoundButton, b -> validForms() }
    }

    private fun validForms() {
        if (binding.chipIterations.isChecked){
            binding.cvRanges.visibility = GONE
            binding.cvIterations.visibility = VISIBLE
            binding.chipMetaCost.isChecked = false
            binding.chipIterations.isChecked = true
        }
        if (binding.chipMetaCost.isChecked){
            binding.cvIterations.visibility = GONE
            binding.cvRanges.visibility = VISIBLE
            binding.chipIterations.isChecked = false
            binding.chipMetaCost.isChecked = true
        }
        if (binding.chipIterations.isChecked || binding.chipMetaCost.isChecked) binding.btnCalcular.isEnabled = true
    }

    private fun configureButtons() {
        if (!binding.chipIterations.isChecked && !binding.chipMetaCost.isChecked) binding.btnCalcular.isEnabled = false
        if (binding.chipIterations.isChecked || binding.chipMetaCost.isChecked) binding.btnCalcular.isEnabled = true
        binding.btnCalcular.setOnClickListener {
            //  Load Screen
            val dialogDetailsData = DialogLoadOperationsFragment(
                onSubmitClickListener = { quantity ->
                    Toast.makeText(context, quantity.toString(), Toast.LENGTH_SHORT).show()
                }
            )
            dialogDetailsData.show(parentFragmentManager, "dialog")
            //  Resolve Operations
            if (binding.chipIterations.isChecked){
                if (validFieldsIterator()){
                    val valueB = binding.etValueB.text.toString().trim().toFloat()
                    val valueW = binding.etValueW.text.toString().trim().toFloat()
                    val iterations = binding.etIterations.text.toString().trim().toFloat()
                    resultsPerceptron = methodIterator(valueB, valueW, iterations)
                }
            } else if (binding.chipMetaCost.isChecked){
                if (validFieldsRanges()){
                    val valueB = binding.etValueB.text.toString().trim().toFloat()
                    val valueW = binding.etValueW.text.toString().trim().toFloat()
                    val rangeA = binding.etMaxRange.text.toString().trim().toFloat()
                    val rangeB = binding.etMinRange.text.toString().trim().toFloat()
                    resultsPerceptron = methodRanges(valueW, valueB, rangeA, rangeB, valuesX, valuesY)
                }
            }
        }
        binding.btnMore.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    if (data.name.trim() == getString(R.string.bottom_options_view_graphics)){
                        val intent = Intent(context, OperationsGraphicsActivity::class.java).apply {
                            putExtra("Saludo", data.toString())
                        }
                        startActivity(intent)
                    } else {
                        binding.apply {
                            cvIterations.visibility = GONE
                            cvRanges.visibility = GONE
                            cvInputData.visibility = GONE
                            cvOptions.visibility = GONE
                            recyclerViewData.visibility = VISIBLE
                        }
                    }
                }
            )
            val sendData = Bundle()
            sendData.putString("option", "More")
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }
    }

    private fun methodIterator(valueB: Float, valueW: Float, iterations: Float): MutableList<ResultsPerceptron> {
        var counter = 1
        var w = valueW
        var derivadaRes: Float
        var costo = 0.0f
        var valueJW = String()
        var error: MutableList<Float> = mutableListOf()
        var guess: MutableList<Float> = mutableListOf()
        var results = mutableListOf<ResultsPerceptron>()
        resultsPerceptron = mutableListOf()
        while (counter <= iterations){
            derivadaRes = neuronTraining.resolveDerivative(w, valueB, valuesX, valuesY)
            guess = neuronTraining.resolveGuess(valuesX, w, valueB)
            error = neuronTraining.resolveError(guess, valuesY)
            valueJW = formatNum.getTwoDecimals(neuronTraining.resolveCost(w, valuesX, valuesY)).toString()
            costo = neuronTraining.resolveCost(w, valuesX, valuesY)
            println("---------- Iteracion #$counter ----------")
            println("El valor de w: ${formatNum.getTwoDecimals(w)}")
            println("El costo es de: $costo")
            println("El valor de J(w) es igual a: $valueJW")
            println("El valor de la derivada es igual a ${formatNum.getTwoDecimals(neuronTraining.resolveDerivative(w, valueB, valuesX, valuesY))}")
            println("El valor de Guess es igual a: $error")
            println("El valor de Error es igual a: $guess")
            val charge = ChargeData(counter, w, valueJW.toFloat(), costo)
            results.add(ResultsPerceptron(counter, w, valueB, iterations.toInt(), valuesX = valuesX,
                valuesY = valuesY, valueJW = valueJW.toFloat(), derivada = derivadaRes, error = error,
                guess = guess, costo = costo))
            adapter.add(charge)
            w = neuronTraining.resolveW(w, derivadaRes)
            counter++
        }
        binding.btnMore.isEnabled = true
        return results
    }

    private fun methodRanges(w: Float, b: Float, rango1: Float, rango2: Float, valuesX: MutableList<Float>, valuesY: MutableList<Float>)
            : MutableList<ResultsPerceptron>{
        val mayorRango: Float
        val menorRango: Float
        if (rango1 > rango2){
            mayorRango = rango1
            menorRango = rango2
        } else {
            mayorRango = rango2
            menorRango = rango1
        }
        var newW = w
        var counter = 0
        var derivadaRes = 0.0f
        var valueJW = 0.0f
        var error: MutableList<Float> = mutableListOf()
        var guess: MutableList<Float> = mutableListOf()
        val results = mutableListOf<ResultsPerceptron>()
        resultsPerceptron = arrayListOf()
        do {
            derivadaRes = neuronTraining.resolveDerivative(newW, b, valuesX, valuesY)
            guess = neuronTraining.resolveGuess(ChargeDataFragment.valuesX, w, b)
            error = neuronTraining.resolveError(guess, ChargeDataFragment.valuesY)
            valueJW = neuronTraining.resolveCost(newW, valuesX, valuesY)
            println("---------- Iteracion #$counter ----------")
            println("El valor de w: ${formatNum.getTwoDecimals(newW)}")
            println("El valor de J(w) es igual a: ${formatNum.getTwoDecimals(valueJW)}")
            println("El valor de la derivada es igual a ${formatNum.getTwoDecimals(derivadaRes)}")
            println("El valor de Error es igual a: $error")
            println("El valor de Guess es igual a: $guess")
            val charge = ChargeData(counter, newW, valueJW, valueJW)
            results.add(ResultsPerceptron(counter, newW, b, valuesX = ChargeDataFragment.valuesX, valuesY = ChargeDataFragment.valuesY,
                valueJW = valueJW, derivada = derivadaRes, error = error, guess = guess,
                costo = valueJW))
            adapter.add(charge)
            newW = neuronTraining.resolveW(newW, derivadaRes)
            counter++
        } while (mayorRango < valueJW || menorRango > valueJW)
        binding.btnMore.isEnabled = true
        return results
    }

    private fun configRecyclerView() {
        val options = mutableListOf<ChargeData>()
        binding.let {
            adapter = ChargeDataAdapter(options, this)
            it.recyclerViewData.apply {
                layoutManager = GridLayoutManager(context, 2)
                adapter = this@CalculationsFragment.adapter
            }
        }
    }

    override fun onClick(chargeData: ChargeData) {
        val DialogDetailsData = DialogDetailsDataFragment(
            onSubmitClickListener = { quantity ->
                Toast.makeText(context, quantity.toString(), Toast.LENGTH_SHORT).show()
            }
        )

        val bundle = Bundle()
        bundle.putInt(PASS_ID, chargeData.id)
        bundle.putFloat(PASS_W, chargeData.w)
        bundle.putFloat(PASS_JW, chargeData.jw)
        bundle.putFloat(PASS_COSTO, chargeData.costo)
        DialogDetailsData.arguments = bundle
        DialogDetailsData.show(parentFragmentManager, "dialog")
    }

    private fun validFieldsIterator(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etValueB.text.isNullOrEmpty()){
            binding.tilValueB.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilValueB.error = null
        }
        // Evaluando value B
        if (binding.etIterations.text.isNullOrEmpty()){
            binding.tilIterations.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etIterations.error = null
        }
        // Evaluando value B
        if (binding.etValueW.text.isNullOrEmpty()){
            binding.tilValueW.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etValueW.error = null
        }
        return isValid
    }

    private fun validFieldsRanges(): Boolean {
        var isValid = true
        //  Evaluando value A
        if (binding.etValueB.text.isNullOrEmpty()){
            binding.tilValueB.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilValueB.error = null
        }
        // Evaluando value B
        if (binding.etValueW.text.isNullOrEmpty()){
            binding.tilValueW.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etValueW.error = null
        }
        // Evaluando value B
        if (binding.etMaxRange.text.isNullOrEmpty()){
            binding.tilMaxRange.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etMaxRange.error = null
        }
        // Evaluando value B
        if (binding.etMinRange.text.isNullOrEmpty()){
            binding.tilMinRange.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etMinRange.error = null
        }
        return isValid
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/

    companion object {
        lateinit var resultsPerceptron: MutableList<ResultsPerceptron>
    }

}