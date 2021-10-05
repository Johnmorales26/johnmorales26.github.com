package com.cursosant.android.mdpostres

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursosant.android.mdpostres.databinding.FragmentCarBinding
import com.google.android.material.transition.MaterialSharedAxis

/****
 * Project: MD Postres
 * From: com.cursosant.android.mdpostres
 * Created by Alain Nicolás Tello on 01/01/21 at 14:06
 * Course: Professional Material Desing/Theming for Android, UX/UI.
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 * All rights reserved 2021.
 *
 * Others:
 * Android con Kotlin intensivo y práctico desde cero.
 * https://www.udemy.com/course/kotlin-intensivo/?referralCode=93D5D2FA6EF503FD0A6B
 */
class CarFragment : Fragment() {

    private lateinit var binding: FragmentCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_car, container, false)
        binding = FragmentCarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CarAdapter(CarFragmentArgs.fromBundle(requireArguments()).products!!)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        binding.tvSum.text = getString(R.string.car_sum, adapter.itemCount.toFloat())

        view.findViewById<View>(R.id.btnBack).setOnClickListener { view1: View? ->
            NavHostFragment.findNavController(this).navigate(R.id.action_car_to_products) }

        view.findViewById<View>(R.id.btnPay).setOnClickListener { view1: View? ->
            NavHostFragment.findNavController(this).navigate(R.id.action_car_to_confirmation) }
        setHasOptionsMenu(true)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.action_confirmation).isVisible = false
        menu.findItem(R.id.confirmationFragment).isVisible = false
        super.onPrepareOptionsMenu(menu)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}