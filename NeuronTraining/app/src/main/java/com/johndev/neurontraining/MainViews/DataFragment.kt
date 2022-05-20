package com.johndev.neurontraining.MainViews

import android.graphics.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.neurontraining.databinding.FragmentDataBinding
import com.johndev.neurontraining.Adapters.ResultsPerceptronAdapter
import com.johndev.neurontraining.Interfaces.OnResultsPerceptronListener
import com.johndev.neurontraining.OperationsGraphicsActivity
import com.johndev.neurontraining.OperationsGraphicsActivity.Companion.paintResults


class DataFragment : Fragment(), OnResultsPerceptronListener, SearchView.OnQueryTextListener {

    private var _binding: FragmentDataBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ResultsPerceptronAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        binding.searchView.setOnQueryTextListener(this)
    }

    private fun setupRecyclerView() {
        val options = paintResults
        options.reverse()
        binding.let {
            adapter = ResultsPerceptronAdapter(options, listener = this)
            it.recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@DataFragment.adapter
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