package com.johndev.smartcalculator.usecases.fragments.FragmentsConversion

import DataClases.Angles.Angles
import DataClases.Angles.AnglesTypes
import DataClases.DataStorage.DataStorage
import DataClases.DataStorage.DataStorageTypes.bitTerm
import DataClases.DataStorage.DataStorageTypes.byte
import DataClases.DataStorage.DataStorageTypes.byteTerm
import DataClases.DataStorage.DataStorageTypes.gibibitTerm
import DataClases.DataStorage.DataStorageTypes.gibibyteTerm
import DataClases.DataStorage.DataStorageTypes.gigabitTerm
import DataClases.DataStorage.DataStorageTypes.gigabyteTerm
import DataClases.DataStorage.DataStorageTypes.kibibitTerm
import DataClases.DataStorage.DataStorageTypes.kibibyteTerm
import DataClases.DataStorage.DataStorageTypes.kilobitTerm
import DataClases.DataStorage.DataStorageTypes.kilobyteTerm
import DataClases.DataStorage.DataStorageTypes.mebibitTerm
import DataClases.DataStorage.DataStorageTypes.mebibyteTerm
import DataClases.DataStorage.DataStorageTypes.megabit
import DataClases.DataStorage.DataStorageTypes.megabitTerm
import DataClases.DataStorage.DataStorageTypes.megabyteTerm
import DataClases.DataStorage.DataStorageTypes.pebibitTerm
import DataClases.DataStorage.DataStorageTypes.pebibyteTerm
import DataClases.DataStorage.DataStorageTypes.petabitTerm
import DataClases.DataStorage.DataStorageTypes.petabyteTerm
import DataClases.DataStorage.DataStorageTypes.tebibitTerm
import DataClases.DataStorage.DataStorageTypes.tebibyteTerm
import DataClases.DataStorage.DataStorageTypes.terabitTerm
import DataClases.DataStorage.DataStorageTypes.terabyteTerm
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.MainActivity.Companion.editable
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentConversionAngleBinding
import com.johndev.smartcalculator.databinding.FragmentConversionDataStorageBinding
import com.johndev.smartcalculator.usecases.Adapters.ConversionAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnConversionListener
import com.johndev.smartcalculator.usecases.common.Conections.Companion.dataStorage
import com.johndev.smartcalculator.usecases.common.ConversionsData
import com.johndev.smartcalculator.usecases.fragments.BottomSheetOptions.BottomOptionsFragment
import com.johndev.smartcalculator.usecases.fragments.Dialogs.NextUpdateDialog

class ConversionDataStorageFragment : Fragment(), OnConversionListener {

    private var _binding: FragmentConversionDataStorageBinding? = null
    private val binding get() = _binding!!
    private lateinit var conversionAdapter: ConversionAdapter
    private var optionVisibles: MutableList<ConversionsData> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConversionDataStorageBinding.inflate(inflater, container, false)
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
        binding.etValue.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (binding.etValue.text.isNullOrBlank()) {
                    binding.etValue.text = "1".editable()
                } else {
                    when(binding.btnOption.text.toString().trim()) {
                        getString(R.string.storage_option_megabit) -> { asignResults(dataStorage.megabit(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_gigabit) -> { asignResults(dataStorage.gigabit(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_megabyte) -> { asignResults(dataStorage.megabyte(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_gigabyte) -> { asignResults(dataStorage.gigabyte(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_bit) -> { asignResults(dataStorage.bit(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_kilobit) -> { asignResults(dataStorage.kilobit(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_kibibit) -> { asignResults(dataStorage.kibibit(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_kilobyte) -> { asignResults(dataStorage.kilobyte(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_mebibit) -> { asignResults(dataStorage.mebibit(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_gibibit) -> { asignResults(dataStorage.gibibit(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_terabit) -> { asignResults(dataStorage.terabit(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_tebibit) -> { asignResults(dataStorage.tebibit(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_petabit) -> { asignResults(dataStorage.petabit(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_pebibit) -> { asignResults(dataStorage.pebibit(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_byte) -> { asignResults(dataStorage.byte(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_kibibyte) -> { asignResults(dataStorage.kibibyte(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_mebibyte) -> { asignResults(dataStorage.mebibyte(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_gibibyte) -> { asignResults(dataStorage.gibibyte(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_terabyte) -> { asignResults(dataStorage.terabyte(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_tebibyte) -> { asignResults(dataStorage.tebibyte(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_petabyte) -> { asignResults(dataStorage.petabyte(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.storage_option_pebibyte) -> { asignResults(dataStorage.pebibyte(binding.etValue.text.toString().trim().toDouble())) }
                        else -> Toast.makeText(requireContext(), "Error Al Cargar Datos", Toast.LENGTH_LONG).show()
                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}
        })
    }

    fun asignResults(values: MutableList<DataStorage>){
        val data: MutableList<ConversionsData> = mutableListOf(
            ConversionsData(5, getString(R.string.storage_option_bit), "1 60°", true, values[0].value, bitTerm),
            ConversionsData(15, getString(R.string.storage_option_byte), "1 360°", true, values[1].value, byteTerm),
            ConversionsData(6, getString(R.string.storage_option_kilobit), "1 90°", true, values[2].value, kilobitTerm),
            ConversionsData(7, getString(R.string.storage_option_kibibit), "1 360°", true, values[3].value, kibibitTerm),
            ConversionsData(8, getString(R.string.storage_option_kilobyte), "1 Sec", true, values[4].value, kilobyteTerm),
            ConversionsData(16, getString(R.string.storage_option_kibibyte), "1 Sec", true, values[5].value, kibibyteTerm),
            ConversionsData(1, getString(R.string.storage_option_megabit), "1 Rad", true, values[6].value, megabitTerm),
            ConversionsData(9, getString(R.string.storage_option_mebibit), "1 60°", true, values[7].value, mebibitTerm),
            ConversionsData(3, getString(R.string.storage_option_megabyte), "1 Min", true, values[8].value, megabyteTerm),
            ConversionsData(17, getString(R.string.storage_option_mebibyte), "1 60°", true, values[9].value, mebibyteTerm),
            ConversionsData(2, getString(R.string.storage_option_gigabit), "1 Deg", true, values[10].value, gigabitTerm),
            ConversionsData(10, getString(R.string.storage_option_gibibit), "1 90°", true, values[11].value, gibibitTerm),
            ConversionsData(4, getString(R.string.storage_option_gigabyte), "1 Sec", true, values[12].value, gigabyteTerm),
            ConversionsData(18, getString(R.string.storage_option_gibibyte), "1 90°", true, values[13].value, gibibyteTerm),
            ConversionsData(11, getString(R.string.storage_option_terabit), "1 360°", true, values[14].value, terabitTerm),
            ConversionsData(12, getString(R.string.storage_option_tebibit), "1 Sec", true, values[15].value, tebibitTerm),
            ConversionsData(19, getString(R.string.storage_option_terabyte), "1 360°", true, values[16].value, terabyteTerm),
            ConversionsData(20, getString(R.string.storage_option_tebibyte), "1 Sec", true, values[17].value, tebibyteTerm),
            ConversionsData(22, getString(R.string.storage_option_pebibyte), "1 90°", true, values[18].value, pebibyteTerm),
            ConversionsData(21, getString(R.string.storage_option_petabyte), "1 60°", true, values[19].value, petabyteTerm),
            ConversionsData(13, getString(R.string.storage_option_petabit), "1 60°", true, values[20].value, petabitTerm),
            ConversionsData(14, getString(R.string.storage_option_pebibit), "1 90°", true, values[21].value, pebibitTerm),
        )
        updateRecyclerView(data)
    }

    private fun updateRecyclerView(newData: MutableList<ConversionsData>){
        optionVisibles.removeAll(optionVisibles)
        optionVisibles.addAll(newData)
        conversionAdapter.updateAllList(newData)
    }

    private fun configButtons() {
        binding.btnOption.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.btnOption.text = data.name.trim()
                    configureAnswers()
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.storage_option_megabit))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }
    }

    private fun configRecyclerView(updateOptions: MutableList<ConversionsData> = inflateOptions()) {
        optionVisibles = inflateOptions()
        updateOptions.forEach {
            if (it.visibility) optionVisibles.add(it)
        }
        val data = optionVisibles
        conversionAdapter = ConversionAdapter(data, this)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = conversionAdapter
        }
    }

    private fun inflateOptions(radian: Double = 0.0, grade: Double = 0.0, minute: Double = 0.0, second: Double = 0.0, sextant: Double = 0.0, quadrant: Double = 0.0, circle: Double = 0.0): MutableList<ConversionsData> {
        return mutableListOf(
            ConversionsData(1, getString(R.string.storage_option_bit), "1 60°", true, sextant, bitTerm),
            ConversionsData(2, getString(R.string.storage_option_byte), "1 360°", true, circle, byteTerm),
            ConversionsData(3, getString(R.string.storage_option_kilobit), "1 90°", true, quadrant, kilobitTerm),
            ConversionsData(4, getString(R.string.storage_option_kibibit), "1 360°", true, circle, kibibitTerm),
            ConversionsData(5, getString(R.string.storage_option_kilobyte), "1 Sec", true, second, kilobyteTerm),
            ConversionsData(6, getString(R.string.storage_option_kibibyte), "1 Sec", true, second, kibibyteTerm),
            ConversionsData(7, getString(R.string.storage_option_megabit), "1 Rad", true, radian, megabitTerm),
            ConversionsData(8, getString(R.string.storage_option_mebibit), "1 60°", true, sextant, mebibitTerm),
            ConversionsData(9, getString(R.string.storage_option_megabyte), "1 Min", true, minute, megabyteTerm),
            ConversionsData(10, getString(R.string.storage_option_mebibyte), "1 60°", true, sextant, mebibyteTerm),
            ConversionsData(11, getString(R.string.storage_option_gigabit), "1 Deg", true, grade, gigabitTerm),
            ConversionsData(12, getString(R.string.storage_option_gibibit), "1 90°", true, quadrant, gibibitTerm),
            ConversionsData(13, getString(R.string.storage_option_gigabyte), "1 Sec", true, second, gigabyteTerm),
            ConversionsData(14, getString(R.string.storage_option_gibibyte), "1 90°", true, quadrant, gibibyteTerm),
            ConversionsData(15, getString(R.string.storage_option_terabit), "1 360°", true, circle, terabitTerm),
            ConversionsData(16, getString(R.string.storage_option_tebibit), "1 Sec", true, second, tebibitTerm),
            ConversionsData(17, getString(R.string.storage_option_terabyte), "1 360°", true, circle, terabyteTerm),
            ConversionsData(18, getString(R.string.storage_option_tebibyte), "1 Sec", true, second, tebibyteTerm),
            ConversionsData(19, getString(R.string.storage_option_pebibyte), "1 90°", true, quadrant, pebibyteTerm),
            ConversionsData(20, getString(R.string.storage_option_petabyte), "1 60°", true, sextant, petabyteTerm),
            ConversionsData(21, getString(R.string.storage_option_petabit), "1 60°", true, sextant, petabitTerm),
            ConversionsData(22, getString(R.string.storage_option_pebibit), "1 90°", true, quadrant, pebibitTerm)
        )
    }
}