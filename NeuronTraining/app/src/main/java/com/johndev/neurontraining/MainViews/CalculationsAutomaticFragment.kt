package com.johndev.neurontraining.MainViews

import NeuronTraining.NeuronTraining
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.johndev.neurontraining.AutomaticChartActivity
import com.johndev.neurontraining.MainViews.ChargeDataFragment.Companion.valuesX
import com.johndev.neurontraining.MainViews.ChargeDataFragment.Companion.valuesY
import com.johndev.neurontraining.Models.Automatic
import com.johndev.neurontraining.databinding.FragmentCalculationsAutomaticBinding
import kotlinx.coroutines.*
import java.util.*

class CalculationsAutomaticFragment : Fragment() {

    private var _binding: FragmentCalculationsAutomaticBinding? = null
    private val binding get() = _binding!!
    private var neuronTraining = NeuronTraining()

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
    }

    private fun configureButtons() {
        binding.btnCalcular.setOnClickListener {
            Toast.makeText(context, "Cargando Resultados...", Toast.LENGTH_SHORT).show()
            GlobalScope.launch(Dispatchers.Main) {
                automaticMethod()
                delay(500)
            }
        }
        binding.btnMore.setOnClickListener {
            val intent = Intent(context, AutomaticChartActivity::class.java)
            startActivity(intent)
        }
    }

    private fun automaticMethod() {
        resultsAutomatic = mutableListOf()
        val random = Random()
        var W0 = random.nextInt(1..2147483647).toFloat()
        var W1 = random.nextInt(1..2147483647).toFloat()
        binding.etValueW0.text = W0.toString().editable()
        binding.etValueW1.text = W1.toString().editable()
        var J = 0.0f
        var x = 0
        var isEquals = true
        do {
            val newJ = neuronTraining.getJ(W1, W0, valuesX, valuesY)
            val newW0 = neuronTraining.getAproximateW0(W0, W1, valuesX, valuesY)
            val newW1 = neuronTraining.getAproximateW1(W0, W1, valuesX, valuesY)
            if (newW0 == W0 && newW1 == W1){
                isEquals = false
            } else {
                W0 = newW0
                W1 = newW1
            }
            println("Iteracion: $x")
            println("W0 = $W0")
            println("W1 = $W1")
            println("J = $J")
            W0 = newW0
            W1 = newW1
            J = newJ
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
        }
    }

    private fun String.editable(): Editable = Editable.Factory.getInstance().newEditable(this)

    private fun Random.nextInt(range: IntRange): Int {
        return range.first + nextInt(range.last - range.first)
    }

    companion object {
        lateinit var resultsAutomatic: MutableList<Automatic>
    }

}