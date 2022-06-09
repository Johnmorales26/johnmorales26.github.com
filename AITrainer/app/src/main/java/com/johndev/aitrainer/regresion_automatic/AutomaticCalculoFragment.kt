package com.johndev.aitrainer.regresion_automatic

import NeuronTraining.NeuronTraining
import android.media.MediaPlayer
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.aitrainer.Constants.DIFFERENCES_METHOD
import com.johndev.aitrainer.Constants.MAGNITUDE_METHOD
import com.johndev.aitrainer.Constants.NOT_VISIBLE_VIEW
import com.johndev.aitrainer.Constants.VISIBLE_VIEW
import com.johndev.aitrainer.MainActivity
import com.johndev.aitrainer.MainActivity.Companion.printAutomatic
import com.johndev.aitrainer.Models.Automatic
import com.johndev.aitrainer.R
import com.johndev.aitrainer.common.ChargeDatasetsFragment.Companion.valuesX
import com.johndev.aitrainer.common.ChargeDatasetsFragment.Companion.valuesY
import com.johndev.aitrainer.databinding.FragmentAutomaticCalculoBinding
import com.johndev.aitriner.Adapters.AutomaticAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.properties.Delegates

class AutomaticCalculoFragment : Fragment(), SearchView.OnQueryTextListener {

    private var _binding: FragmentAutomaticCalculoBinding? = null
    private val binding get() = _binding!!
    private var neuronTraining = NeuronTraining()
    private var finalW0 by Delegates.notNull<Double>()
    private var finalW1 by Delegates.notNull<Double>()
    private lateinit var adapter: AutomaticAdapter
    private var myVisibility = VISIBLE_VIEW
    private var myVisibilityTest = VISIBLE_VIEW
    private var myVisibilityResults = VISIBLE_VIEW


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAutomaticCalculoBinding.inflate(inflater, container, false)
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
                val valueTransform: Double
                if (text.isEmpty()){
                    valueTransform = 0.0
                } else {
                    valueTransform = binding.etValueTransform.text.toString().trim().toDouble()
                    val result = (valueTransform * finalW1) + finalW0
                    binding.etValueResult.text = result.toString().trim().editable()
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun configureButtons() {
        binding.btnCalcular.setOnClickListener {
            binding.btnCalcular.isEnabled = false
            Toast.makeText(context, "Cargando Resultados...", Toast.LENGTH_SHORT).show()
            if (binding.chipDifference.isChecked) {
                lifecycleScope.launch {
                    automaticMethodForDiferences(DIFFERENCES_METHOD)
                    paintResults()
                }
            }
            if (binding.chipMagnitude.isChecked) {
                lifecycleScope.launch {
                    automaticMethodForDiferences(MAGNITUDE_METHOD)
                    paintResults()
                }
            }
        }
        binding.btnMore.setOnClickListener {
            binding.searchView.visibility = VISIBLE
            binding.recyclerView.visibility = VISIBLE
            lifecycleScope.launch(Dispatchers.Default) {
                val printList = printData()
                setupRecyclerView(printList)
            }
        }

        binding.btnDividerOp.setOnClickListener {
            if (myVisibility == VISIBLE_VIEW){
                with(binding) {
                    cvInputData.visibility = GONE
                    cvOptions.visibility = GONE
                    btnDividerOp.setImageResource(R.drawable.ic_arrow_drop_down)
                }
                myVisibility = NOT_VISIBLE_VIEW
            } else {
                with(binding) {
                    cvInputData.visibility = VISIBLE
                    cvOptions.visibility = VISIBLE
                    btnDividerOp.setImageResource(R.drawable.ic_arrow_drop_up)
                }
                myVisibility = VISIBLE_VIEW
            }
        }

        binding.btnDividerTest.setOnClickListener {
            if (myVisibilityTest == VISIBLE_VIEW) {
                with(binding) {
                    cardViewTest.visibility = GONE
                    btnDividerTest.setImageResource(R.drawable.ic_arrow_drop_down)
                }
                myVisibilityTest = NOT_VISIBLE_VIEW
            } else {
                with(binding) {
                    cardViewTest.visibility = VISIBLE
                    btnDividerTest.setImageResource(R.drawable.ic_arrow_drop_up)
                }
                myVisibilityTest = VISIBLE_VIEW
            }
        }

        binding.btnDividerRes.setOnClickListener {
            if (myVisibilityResults == VISIBLE_VIEW) {
                with(binding) {
                    searchView.visibility = GONE
                    recyclerView.visibility = GONE
                    btnDividerRes.setImageResource(R.drawable.ic_arrow_drop_down)
                }
                myVisibilityResults = NOT_VISIBLE_VIEW
            } else {
                with(binding) {
                    searchView.visibility = VISIBLE
                    recyclerView.visibility = VISIBLE
                    btnDividerRes.setImageResource(R.drawable.ic_arrow_drop_up)
                }
                myVisibilityResults = VISIBLE_VIEW
            }
        }
    }

    private suspend fun printData(): MutableList<Automatic> = withContext(Dispatchers.Default) {
        var x = 0
        val latestValues = resultsPerceptron.size - 10
        val returnList: MutableList<Automatic> = mutableListOf()
        lifecycleScope.launch {
            while (x < resultsPerceptron.size) {
                val adapterData = Automatic(resultsPerceptron[x].id, resultsPerceptron[x].W0, resultsPerceptron[x].W1,resultsPerceptron[x].J)
                if (x in 0..10) {
                    returnList.add(adapterData)
                }
                if (x in latestValues..resultsPerceptron.size){
                    returnList.add(adapterData)
                }
                x++
            }
            Toast.makeText(context, "${resultsPerceptron.size}", Toast.LENGTH_SHORT).show()
        }
        return@withContext returnList
    }

    private suspend fun automaticMethodForDiferences(Method: String) = withContext(Dispatchers.IO) {
        resultsPerceptron = mutableListOf()
        val random = Random()
        var w0 = random.nextInt(1..2147483647).toFloat()
        var w1 = random.nextInt(1..2147483647).toFloat()
        var j = 0.0f
        var x = 0
        var rest = 0f
        var magnitude = 0f
        var stop: Boolean
        do {
            //  Variables To Stop The Loop
            val newMagnitude = neuronTraining.getResultingMagnitude(j, w1)
            val newRest = neuronTraining.getDifferenceMagnitude(w0, w1)
            //  Variables For Cycle Calculation
            val newJ = neuronTraining.getJ(w1, w0, valuesX, valuesY)
            val newW0 = neuronTraining.getAproximateW0(w0, w1, valuesX, valuesY)
            val newW1 = neuronTraining.getAproximateW1(w0, w1, valuesX, valuesY)
            println("Iteracion: $x")
            println("W0 = $w0")
            println("W1 = $w1")
            println("J = $j")
            w0 = newW0
            w1 = newW1
            j = newJ
            stop = if (Method == DIFFERENCES_METHOD) {
                stopCycle(rest, newRest)
            } else {
                stopCycle(magnitude, newMagnitude)
            }
            rest = newRest
            magnitude = newMagnitude
            println("Rest = $rest")
            resultsPerceptron.add(Automatic(x, w0, w1, j))
            printAutomatic.add(Automatic(x, w0, w1, j))
            x++
        } while (stop)
        val sound = MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_sound_active), true)
        if (sound){
            val mediaPlayer = MediaPlayer.create(context, R.raw.programming_complete)
            mediaPlayer.start()
        }
        finalW0 = w0.toDouble()
        finalW1 = w1.toDouble()
    }

    private fun paintResults() {
        val reversed = resultsPerceptron.asReversed()
        binding.apply {
            binding.btnCalcular.isEnabled = true
            etValueW0.isEnabled = true
            etValueJ.isEnabled = true
            etValueIterations.isEnabled = true
            etValueW1.isEnabled = true
            etValueW0.text = reversed[0].W0.toString().trim().editable()
            etValueW1.text = reversed[0].W1.toString().trim().editable()
            etValueIterations.text = reversed[0].id.toString().trim().editable()
            etValueJ.text = reversed[0].J.toString().trim().editable()
            btnMore.isEnabled = true
            tilValueTransform.isEnabled = true
        }
        Toast.makeText(context, "Calculos Realizados...", Toast.LENGTH_SHORT).show()
    }

    private fun setupRecyclerView(printList: MutableList<Automatic>) {
        val data: MutableList<Automatic> = printList
        binding.let {
            adapter = AutomaticAdapter(data)
            it.recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@AutomaticCalculoFragment.adapter
            }
        }
    }

    override fun onQueryTextSubmit(text: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(text: String?): Boolean {
        adapter.filteredOut(text!!)
        return false
    }

    private fun stopCycle(value: Float, auxValue: Float): Boolean {
        return value != auxValue
    }

    private fun String.editable(): Editable = Editable.Factory.getInstance().newEditable(this)

    private fun Random.nextInt(range: IntRange): Int {
        return range.first + nextInt(range.last - range.first)
    }

    companion object {
        lateinit var resultsPerceptron: MutableList<Automatic>
        //lateinit var chartData: MutableList<Automatic>
    }

}