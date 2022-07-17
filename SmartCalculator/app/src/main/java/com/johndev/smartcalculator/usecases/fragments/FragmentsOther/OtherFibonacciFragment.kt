package com.johndev.smartcalculator.usecases.fragments.FragmentsOther

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.johndev.smartcalculator.databinding.FragmentOtherFibonacciBinding
import kotlinx.coroutines.*

class OtherFibonacciFragment : Fragment() {

    private var _binding: FragmentOtherFibonacciBinding? = null
    private val binding get() = _binding!!
    private lateinit var fibScope: Job
    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.e("FibError", "$throwable in $coroutineContext")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherFibonacciBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureEditText()
    }

    private fun configureEditText() {

        binding.etValue.addTextChangedListener {
            if (this::fibScope.isInitialized && fibScope.isActive) fibScope.cancel()
            binding.tvResult.text = "Calculando..."
            val time = System.currentTimeMillis()
            fibScope = CoroutineScope(Job() + exceptionHandler).launch(Dispatchers.Default) {
                if (it.toString().isNotEmpty()) {
                    val fib = fibonacci(it.toString().trim().toLong())
                    withContext(Dispatchers.Main) {
                        binding.tvResult.text = (fib * -1).toString().trim()
                    }
                }
            }
        }
    }

    private fun fibonacci(n: Long): Long {
        if (fibScope.isCancelled) throw Exception("Numero modificado antes de completar el calculo.")
        return if (n < 1) n
        else fibonacci(n - 1) + fibonacci(n - 2)
    }

}