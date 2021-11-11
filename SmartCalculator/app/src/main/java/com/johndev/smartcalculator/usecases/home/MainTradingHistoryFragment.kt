package com.johndev.smartcalculator.usecases.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.databinding.FragmentMainTradingHistoryBinding
import com.johndev.smartcalculator.provider.services.DatabaseOperationHistory
import com.johndev.smartcalculator.usecases.Adapters.OperationHistoryAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListenerHistory
import com.johndev.smartcalculator.usecases.base.OperationHistory

class MainTradingHistoryFragment : Fragment(), OnClickListenerHistory {

    private var _binding: FragmentMainTradingHistoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var operationHistoryAdapter: OperationHistoryAdapter
    private lateinit var database: DatabaseOperationHistory
    private lateinit var data: MutableList<OperationHistory>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainTradingHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = context?.let { it1 -> DatabaseOperationHistory(it1) }!!
        data = database.getAllHistory()
        operationHistoryAdapter = OperationHistoryAdapter(data, this)
        binding.rvHistory.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = operationHistoryAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(operationHistory: OperationHistory) {}
}