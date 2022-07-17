package com.johndev.smartcalculator.usecases.fragments.FragmentsConversion

import ConverterArea.AreaConverter
import DataClases.Aceleration.Acceleration
import android.hardware.Camera
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.MainActivity.Companion.editable
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentConversionAreaBinding
import com.johndev.smartcalculator.usecases.Adapters.ConversionAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnConversionListener
import com.johndev.smartcalculator.usecases.common.Conections
import com.johndev.smartcalculator.usecases.common.ConversionsData
import com.johndev.smartcalculator.usecases.fragments.BottomSheetOptions.BottomOptionsFragment
import com.johndev.smartcalculator.usecases.fragments.Dialogs.NextUpdateDialog

class ConversionAreaFragment : Fragment(), OnConversionListener {

    private var _binding: FragmentConversionAreaBinding? = null
    private val binding get() = _binding!!
    private lateinit var conversionAdapter: ConversionAdapter
    private var optionVisibles: MutableList<ConversionsData> = mutableListOf()
    private val area = AreaConverter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConversionAreaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configRecyclerView()
        configButtons()

        binding.efab.setOnClickListener {
            val dialog = NextUpdateDialog().show(parentFragmentManager, "Dialog")
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
            ConversionsData(1, getString(R.string.area_option_area), "1 ar", true, 0.0, "ar"),
            ConversionsData(2, getString(R.string.area_option_acre), "1 Deg", true, 0.0, "ac"),
            ConversionsData(3, getString(R.string.area_option_centimenter), "1 Min", true, 0.0, "cm ^2"),
            ConversionsData(4, getString(R.string.area_option_decameter), "1 Sec", true, 0.0, "dkm ^2"),
            ConversionsData(4, getString(R.string.area_option_hectarea), "1 Sec", true, 0.0, "ha"),
            ConversionsData(4, getString(R.string.area_option_hectometer), "1 Sec", true, 0.0, "hm ^2"),
            ConversionsData(4, getString(R.string.area_option_kilometer), "1 Sec", true, 0.0, "km ^2"),
            ConversionsData(4, getString(R.string.area_option_meter), "1 Sec", true, 0.0, "m ^2"),
            ConversionsData(4, getString(R.string.area_option_micrometer), "1 Sec", true, 0.0, "μm ^2"),
            ConversionsData(4, getString(R.string.area_option_milimeter), "1 Sec", true, 0.0, "mm ^2"),
            ConversionsData(4, getString(R.string.area_option_mile), "1 Sec", true, 0.0, "mi ^2"),
            ConversionsData(4, getString(R.string.area_option_nanometer), "1 Sec", true, 0.0, "nm ^2"),
            ConversionsData(4, getString(R.string.area_option_pie), "1 Sec", true, 0.0, "ft ^2"),
            ConversionsData(4, getString(R.string.area_option_in), "1 Sec", true, 0.0, "in ^2"),
            ConversionsData(4, getString(R.string.area_option_yard), "1 Sec", true, 0.0, "yd ^2")
        )
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
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.area_option_area))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}