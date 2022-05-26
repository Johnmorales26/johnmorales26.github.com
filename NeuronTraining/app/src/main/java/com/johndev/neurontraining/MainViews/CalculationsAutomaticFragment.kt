package com.johndev.neurontraining.MainViews

import NeuronTraining.NeuronTraining
import android.R
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.johndev.neurontraining.AutomaticChartActivity
import com.johndev.neurontraining.DialogFragments.DialogErrorOperationsFragment
import com.johndev.neurontraining.DialogFragments.DialogLoadOperationsFragment
import com.johndev.neurontraining.MainViews.ChargeDataFragment.Companion.valuesX
import com.johndev.neurontraining.MainViews.ChargeDataFragment.Companion.valuesY
import com.johndev.neurontraining.Models.Automatic
import com.johndev.neurontraining.databinding.FragmentCalculationsAutomaticBinding
import kotlinx.coroutines.*
import java.io.IOException
import java.util.*
import kotlin.properties.Delegates

class CalculationsAutomaticFragment : Fragment() {

    private var _binding: FragmentCalculationsAutomaticBinding? = null
    private val binding get() = _binding!!
    private var neuronTraining = NeuronTraining()
    private var finalW0 by Delegates.notNull<Double>()
    private var finalW1 by Delegates.notNull<Double>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculationsAutomaticBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureButtons()
        configureAnswers()
        configureChips()
    }

    private fun configureChips() {
        binding.chipDifference.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked){
                binding.chipMagnitude.isChecked = false
            }
        }
        binding.chipMagnitude.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked){
                binding.chipDifference.isChecked = false
            }
        }
    }

    private fun configureAnswers() {
        binding.etValueTransform.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val text = binding.etValueTransform.text.toString().trim()
                var valueTransform = 0.0
                if (text.isEmpty()){
                    valueTransform = 0.0
                } else {
                    valueTransform = binding.etValueTransform.text.toString().trim().toDouble()
                    var result = (valueTransform * finalW1) + finalW0
                    binding.etValueResult.text = result.toString().trim().editable()
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun configureButtons() {
        binding.btnCalcular.setOnClickListener {
            Toast.makeText(context, "Cargando Resultados...", Toast.LENGTH_SHORT).show()
            if (binding.chipDifference.isChecked) {
                GlobalScope.launch(Dispatchers.Main) {
                    automaticMethodForDiferences()
                    delay(500)
                }
            }
            if (binding.chipMagnitude.isChecked) {
                GlobalScope.launch(Dispatchers.Main) {
                    automaticMethodForResMagnitude()
                    delay(500)
                }
            }
        }
        binding.btnMore.setOnClickListener {
            val intent = Intent(context, AutomaticChartActivity::class.java)
            startActivity(intent)
        }
    }

    private fun automaticMethodForDiferences() {
        resultsAutomatic = mutableListOf()
        val random = Random()
        var W0 = random.nextInt(1..2147483647).toFloat()
        var W1 = random.nextInt(1..2147483647).toFloat()
        binding.etValueW0.text = W0.toString().editable()
        binding.etValueW1.text = W1.toString().editable()
        var J = 0.0f
        var x = 0
        var isEquals = true
        var rest = 0f
        do {
            val newRest = neuronTraining.getDifferenceMagnitude(W0, W1)
            val newJ = neuronTraining.getJ(W1, W0, valuesX, valuesY)
            val newW0 = neuronTraining.getAproximateW0(W0, W1, valuesX, valuesY)
            val newW1 = neuronTraining.getAproximateW1(W0, W1, valuesX, valuesY)
            println("Iteracion: $x")
            println("W0 = $W0")
            println("W1 = $W1")
            println("J = $J")
            W0 = newW0
            W1 = newW1
            J = newJ
            if (rest == newRest){
                isEquals = false
            } else {
                rest = newRest
            }
            println("Rest = $rest")
            resultsAutomatic.add(Automatic(x, W0, W1, J))
            x++
        } while (isEquals)

        binding.apply {
            etValueW0.isEnabled = true
            etValueJ.isEnabled = true
            etValueIterations.isEnabled = true
            etValueW1.isEnabled = true
            etValueW0.text = W0.toString().trim().editable()
            etValueW1.text = W1.toString().trim().editable()
            etValueIterations.text = x.toString().trim().editable()
            etValueJ.text = J.toString().trim().editable()
            btnMore.isEnabled = true
            tilValueTransform.isEnabled = true
        }
        finalW0 = W0.toDouble()
        finalW1 = W1.toDouble()
    }

    private fun automaticMethodForResMagnitude() {
        resultsAutomatic = mutableListOf()
        val random = Random()
        var W0 = random.nextInt(1..2147483647).toFloat()
        var W1 = random.nextInt(1..2147483647).toFloat()
        binding.etValueW0.text = W0.toString().editable()
        binding.etValueW1.text = W1.toString().editable()
        var J = 0.0f
        var x = 0
        var isEquals = true
        var magnitude = 0f
        do {
            val newMagnitude = neuronTraining.getResultingMagnitude(J, W1)
            val newJ = neuronTraining.getJ(W1, W0, valuesX, valuesY)
            val newW0 = neuronTraining.getAproximateW0(W0, W1, valuesX, valuesY)
            val newW1 = neuronTraining.getAproximateW1(W0, W1, valuesX, valuesY)
            println("Iteracion: $x")
            println("W0 = $W0")
            println("W1 = $W1")
            println("J = $J")
            W0 = newW0
            W1 = newW1
            J = newJ
            if (magnitude == newMagnitude){
                isEquals = false
            } else {
                magnitude = newMagnitude
            }
            resultsAutomatic.add(Automatic(x, W0, W1, J))
            x++
        } while (isEquals)

        binding.apply {
            etValueW0.isEnabled = true
            etValueJ.isEnabled = true
            etValueIterations.isEnabled = true
            etValueW1.isEnabled = true
            etValueW0.text = W0.toString().trim().editable()
            etValueW1.text = W1.toString().trim().editable()
            etValueIterations.text = x.toString().trim().editable()
            etValueJ.text = J.toString().trim().editable()
            btnMore.isEnabled = true
            tilValueTransform.isEnabled = true
        }
        finalW0 = W0.toDouble()
        finalW1 = W1.toDouble()
    }

    private fun String.editable(): Editable = Editable.Factory.getInstance().newEditable(this)

    private fun Random.nextInt(range: IntRange): Int {
        return range.first + nextInt(range.last - range.first)
    }

    companion object {
        lateinit var resultsAutomatic: MutableList<Automatic>
    }

}