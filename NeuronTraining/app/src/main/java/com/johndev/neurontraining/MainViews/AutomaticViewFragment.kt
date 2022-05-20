package com.johndev.neurontraining.MainViews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.neurontraining.Adapters.AutomaticAdapter
import com.johndev.neurontraining.Adapters.ResultsPerceptronAdapter
import com.johndev.neurontraining.MainViews.CalculationsAutomaticFragment.Companion.resultsAutomatic
import com.johndev.neurontraining.Models.Automatic
import com.johndev.neurontraining.OperationsGraphicsActivity
import com.johndev.neurontraining.R
import com.johndev.neurontraining.databinding.FragmentAutomaticViewBinding
import com.johndev.neurontraining.databinding.FragmentDataBinding

class AutomaticViewFragment : Fragment(), SearchView.OnQueryTextListener {

    private var _binding: FragmentAutomaticViewBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: AutomaticAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAutomaticViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        binding.searchView.setOnQueryTextListener(this)
    }

    private fun setupRecyclerView() {
        val options = resultsAutomatic
        options.reverse()
        binding.let {
            adapter = AutomaticAdapter(options)
            it.recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@AutomaticViewFragment.adapter
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}