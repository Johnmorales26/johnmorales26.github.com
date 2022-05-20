package com.johndev.neurontraining.MainViews

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.neurontraining.databinding.FragmentChargeDataBinding
import com.johndev.neurontraining.Adapters.DatasetAdapter
import com.johndev.neurontraining.Interfaces.OnDatasetListener
import com.johndev.neurontraining.MainActivity.Companion.appContext
import com.johndev.neurontraining.Models.Dataset
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class ChargeDataFragment : Fragment(), OnDatasetListener {

    private var _binding: FragmentChargeDataBinding? = null
    private val binding get() = _binding!!
    private lateinit var datasetAdapter: DatasetAdapter
    private val PICK_PDF_FILE = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChargeDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureButtons()
    }

    private fun configureButtons() {
        dataset = mutableListOf()
        valuesX = mutableListOf()
        valuesY = mutableListOf()
        binding.btnChargeData.setOnClickListener {
            selectCSVFile()
        }
    }

    private fun readTextFromUri(uri: Uri): String {
        val stringBuilder = StringBuilder()
        appContext.contentResolver.openInputStream(uri)?.use { inputStream ->
            BufferedReader(InputStreamReader(inputStream)).use { reader ->
                var line: String? = reader.readLine()
                var i = 0
                while (line != null) {
                    val textElements = line.toString().split(",")
                    val valueX = textElements[0].trim().toDouble()
                    val valueY = textElements[1].trim().toDouble()
                    dataset.add(Dataset(valueX, valueY))
                    valuesX.add(valueX.toFloat())
                    valuesY.add(valueY.toFloat())
                    println("Vuelta: $i------${dataset[i].dataX}, ${dataset[i].dataY}")
                    i++
                    line = reader.readLine()
                }
                binding.clData.visibility = VISIBLE
                binding.tvAnnouncement.visibility = VISIBLE
                setupRecyclerView(dataset)
            }
        }
        return stringBuilder.toString()
    }

    private fun selectCSVFile() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "*/*"
        startActivityForResult(Intent.createChooser(intent, "Open CSV"), PICK_PDF_FILE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        if (requestCode == PICK_PDF_FILE
            && resultCode == Activity.RESULT_OK) {
            // The result data contains a URI for the document or directory that
            // the user selected.
            resultData?.data?.also { uri ->
                readTextFromUri(uri)
            }
        }
    }

    private fun setupRecyclerView(dataset: MutableList<Dataset>) {
        datasetAdapter = DatasetAdapter(dataset, this)
        binding.rvChargeData.apply {
            //layoutManager = LinearLayoutManager(context)
            layoutManager = LinearLayoutManager(context)
            adapter = datasetAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        lateinit var valuesX: MutableList<Float>
        lateinit var valuesY: MutableList<Float>
        lateinit var dataset: MutableList<Dataset>
    }

}