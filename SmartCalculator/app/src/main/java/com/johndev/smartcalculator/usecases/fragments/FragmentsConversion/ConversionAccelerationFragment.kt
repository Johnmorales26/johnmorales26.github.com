package com.johndev.smartcalculator.usecases.fragments.FragmentsConversion

import DataClases.Aceleration.Acceleration
import DataClases.Angles.Angles
import DataClases.Angles.AnglesTypes
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.MainActivity.Companion.editable
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentConversionAccelerationBinding
import com.johndev.smartcalculator.databinding.FragmentConversionAngleBinding
import com.johndev.smartcalculator.usecases.Adapters.ConversionAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnConversionListener
import com.johndev.smartcalculator.usecases.common.Aceleration.AccelerationTypes.TYPE_GAL
import com.johndev.smartcalculator.usecases.common.Aceleration.AccelerationTypes.TYPE_GRAVEDAD
import com.johndev.smartcalculator.usecases.common.Aceleration.AccelerationTypes.TYPE_METRO
import com.johndev.smartcalculator.usecases.common.Aceleration.AccelerationTypes.TYPE_PIE
import com.johndev.smartcalculator.usecases.common.ConversionsData
import com.johndev.smartcalculator.usecases.fragments.BottomSheetOptions.BottomOptionsFragment
import com.johndev.smartcalculator.usecases.fragments.Dialogs.NextUpdateDialog

class ConversionAccelerationFragment : Fragment(), OnConversionListener {

    private var _binding: FragmentConversionAccelerationBinding? = null
    private val binding get() = _binding!!
    private lateinit var conversionAdapter: ConversionAdapter
    private var optionVisibles: MutableList<ConversionsData> = mutableListOf()
    private val acceleration = Acceleration()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConversionAccelerationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRecyclerView()
        configButtons()
        configureAnswers()

        binding.efab.setOnClickListener {
            val dialog = NextUpdateDialog().show(parentFragmentManager, "Dialog")
        }
    }

    private fun configureAnswers() {
        result(binding.btnOption.text.toString())
    }

    fun result(type: String){
        binding.etValue.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (binding.etValue.text.isNullOrBlank()) {
                    binding.etValue.text = "1".editable()
                } else {
                    when(type) {
                        getString(R.string.acceleration_option_meter_over_second) -> { asignResults(acceleration.meterOverSecond(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.acceleration_option_pie_over_second) -> { asignResults(acceleration.pie(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.acceleration_option_gravity) -> { asignResults(acceleration.gravity(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.acceleration_option_gal) -> { asignResults(acceleration.gal(binding.etValue.text.toString().trim().toDouble())) }
                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}
        })
    }

    fun asignResults(values: Map<String, Double>){

        val data: MutableList<ConversionsData> = mutableListOf(
            ConversionsData(1, getString(R.string.acceleration_option_meter_over_second), "1 Rad", true, values[TYPE_METRO]!!, "Rad"),
            ConversionsData(2, getString(R.string.acceleration_option_pie_over_second), "1 Deg", true, values[TYPE_PIE]!!, "Deg"),
            ConversionsData(3, getString(R.string.acceleration_option_gravity), "1 Min", true, values[TYPE_GRAVEDAD]!!, "Min"),
            ConversionsData(4, getString(R.string.acceleration_option_gal), "1 Sec", true, values[TYPE_GAL]!!, "Sec")
        )

        updateRecyclerView(data)
    }

    private fun configButtons() {

        /*binding.fab.setOnClickListener {
            val fragment = BottomVisibleOptionsFragment(
                onSubmitClickListener = { data ->
                    updateRecyclerView(data)
                },
                inflateOptions()
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.angle_option_radian))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomVisibleOptionsFragment::class.java.simpleName) }
        }*/

        binding.btnOption.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.btnOption.text = data.name.trim()
                    when(binding.btnOption.text.toString()) {
                        getString(R.string.acceleration_option_meter_over_second) -> { asignResults(acceleration.meterOverSecond(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.acceleration_option_pie_over_second) -> { asignResults(acceleration.pie(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.acceleration_option_gravity) -> { asignResults(acceleration.gravity(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.acceleration_option_gal) -> { asignResults(acceleration.gal(binding.etValue.text.toString().trim().toDouble())) }
                    }
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.acceleration_option_meter_over_second))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }
    }

    private fun configRecyclerView(updateOptions: MutableList<ConversionsData> = inflateOptions()) {
        optionVisibles = inflateOptions()
        val data = optionVisibles
        conversionAdapter = ConversionAdapter(data, this)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = conversionAdapter
        }
    }

    private fun updateRecyclerView(newData: MutableList<ConversionsData>){
        optionVisibles.removeAll(optionVisibles)
        optionVisibles.addAll(newData)
        conversionAdapter.updateAllList(newData)
    }

    private fun inflateOptions(): MutableList<ConversionsData> {
        return mutableListOf(
            ConversionsData(1, getString(R.string.acceleration_option_meter_over_second), "1 Rad", true, 0.0, "m/s²"),
            ConversionsData(2, getString(R.string.acceleration_option_pie_over_second), "1 Deg", true, 0.0, "ft/s²"),
            ConversionsData(3, getString(R.string.acceleration_option_gravity), "1 Min", true, 0.0, "g"),
            ConversionsData(4, getString(R.string.acceleration_option_gal), "1 Sec", true, 0.0, "cm/s²")
        )
    }

}