package com.johndev.smartcalculator.usecases.principalViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ActivityOperationHistoryBinding
import com.johndev.smartcalculator.usecases.Adapters.OperationHistoryAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListenerHistory
import com.johndev.smartcalculator.usecases.base.OperationHistory
import com.johndev.smartcalculator.provider.services.DatabaseOperationHistory


class OperationHistoryActivity : AppCompatActivity(), OnClickListenerHistory {

    private lateinit var binding: ActivityOperationHistoryBinding
    private lateinit var operationHistoryAdapter: OperationHistoryAdapter
    private lateinit var database: DatabaseOperationHistory
    private lateinit var data: MutableList<OperationHistory>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOperationHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.title = getString(R.string.title_history_operations)
        database = DatabaseOperationHistory(this)

        data = database.getAllHistory()
        operationHistoryAdapter = OperationHistoryAdapter(data, this)
        binding.rvHistory.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = operationHistoryAdapter
        }
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(operationHistory: OperationHistory) {
        TODO("Not yet implemented")
    }

    companion object {
        var historyOperations: MutableList<OperationHistory> = mutableListOf()
    }
}