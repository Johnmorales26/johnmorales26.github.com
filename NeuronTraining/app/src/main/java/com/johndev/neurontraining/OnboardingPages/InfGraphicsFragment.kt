package com.johndev.neurontraining.OnboardingPages

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.neurontraining.Interfaces.OnDataPassPager
import com.johndev.neurontraining.MainActivity
import com.johndev.neurontraining.databinding.FragmentInfGraphicsBinding

class InfGraphicsFragment : Fragment() {

    private var _binding: FragmentInfGraphicsBinding? = null
    private val binding get() = _binding!!
    private lateinit var dataPasser: OnDataPassPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfGraphicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStartApp.setOnClickListener {
            passData(1)
            startActivity(Intent(activity, MainActivity::class.java))
        }
    }

    private fun passData(data: Int){
        dataPasser.onDataPass(data)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as OnDataPassPager
    }
}