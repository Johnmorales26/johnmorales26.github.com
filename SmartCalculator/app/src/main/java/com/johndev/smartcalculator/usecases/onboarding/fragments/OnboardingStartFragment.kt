package com.johndev.smartcalculator.usecases.onboarding.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.MainActivity
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentOnboardingAlgebraBinding
import com.johndev.smartcalculator.databinding.FragmentOnboardingStartBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnDataPass

class OnboardingStartFragment : Fragment() {

    private var _binding: FragmentOnboardingStartBinding? = null
    private val binding get() = _binding!!
    private lateinit var dataPasser: OnDataPass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStart.setOnClickListener {
            passData(1)
            startActivity(Intent(activity, MainActivity::class.java))
        }
    }

    private fun passData(data: Int){
        dataPasser.onDataPass(data)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as OnDataPass
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}