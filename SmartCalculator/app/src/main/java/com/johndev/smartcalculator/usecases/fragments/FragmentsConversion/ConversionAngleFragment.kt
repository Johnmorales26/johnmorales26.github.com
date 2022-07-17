package com.johndev.smartcalculator.usecases.fragments.FragmentsConversion

import DataClases.Angles.Angles
import DataClases.Angles.AnglesTypes.circulo
import DataClases.Angles.AnglesTypes.cuadrante
import DataClases.Angles.AnglesTypes.grado
import DataClases.Angles.AnglesTypes.minuto
import DataClases.Angles.AnglesTypes.radian
import DataClases.Angles.AnglesTypes.segundo
import DataClases.Angles.AnglesTypes.sextante
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
import com.johndev.smartcalculator.databinding.FragmentConversionAngleBinding
import com.johndev.smartcalculator.usecases.Adapters.ConversionAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnConversionListener
import com.johndev.smartcalculator.usecases.common.Conections.Companion.angles
import com.johndev.smartcalculator.usecases.common.ConversionsData
import com.johndev.smartcalculator.usecases.fragments.BottomSheetOptions.BottomOptionsFragment
import com.johndev.smartcalculator.usecases.fragments.BottomSheetOptions.BottomVisibleOptionsFragment
import com.johndev.smartcalculator.usecases.fragments.Dialogs.NextUpdateDialog
import kotlinx.coroutines.flow.combine

class ConversionAngleFragment : Fragment(), OnConversionListener {

    private var _binding: FragmentConversionAngleBinding? = null
    private val binding get() = _binding!!
    private lateinit var conversionAdapter: ConversionAdapter
    private var optionVisibles: MutableList<ConversionsData> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConversionAngleBinding.inflate(inflater, container, false)
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
                        getString(R.string.angle_option_radian) -> { asignResults(angles.radianTo(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.angle_option_grade) -> { asignResults(angles.gradoTo(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.angle_option_minute) -> { asignResults(angles.minutoTo(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.angle_option_second) -> { asignResults(angles.segundoTo(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.angle_option_sextant) -> { asignResults(angles.sextanteTo(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.angle_option_quadrant) -> { asignResults(angles.cuadranteTo(binding.etValue.text.toString().trim().toDouble())) }
                        getString(R.string.angle_option_circle) -> { asignResults(angles.circuloTo(binding.etValue.text.toString().trim().toDouble())) }
                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}
        })
    }

    fun asignResults(values: MutableMap<String, Double>){
        val data: MutableList<ConversionsData> = mutableListOf(
            ConversionsData(1, getString(R.string.angle_option_radian), "1 Rad", true, values[radian]!!, "Rad"),
            ConversionsData(2, getString(R.string.angle_option_grade), "1 Deg", true, values[grado]!!, "Deg"),
            ConversionsData(3, getString(R.string.angle_option_minute), "1 Min", true, values[minuto]!!, "Min"),
            ConversionsData(4, getString(R.string.angle_option_second), "1 Sec", true, values[segundo]!!, "Sec"),
            ConversionsData(5, getString(R.string.angle_option_sextant), "1 60°", true, values[sextante]!!, "60°"),
            ConversionsData(6, getString(R.string.angle_option_quadrant), "1 90°", true, values[cuadrante]!!, "90°"),
            ConversionsData(7, getString(R.string.angle_option_circle), "1 360°", true, values[circulo]!!, "360°")
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
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.angle_option_radian))
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

    private fun updateRecyclerView(newData: MutableList<ConversionsData>){
        optionVisibles.removeAll(optionVisibles)
        optionVisibles.addAll(newData)
        conversionAdapter.updateAllList(newData)
    }

    private fun inflateOptions(radian: Double = 0.0, grade: Double = 0.0, minute: Double = 0.0, second: Double = 0.0,
    sextant: Double = 0.0, quadrant: Double = 0.0, circle: Double = 0.0): MutableList<ConversionsData> {
        return mutableListOf(
            ConversionsData(1, getString(R.string.angle_option_radian), "1 Rad", true, radian, "Rad"),
            ConversionsData(2, getString(R.string.angle_option_grade), "1 Deg", true, grade, "Deg"),
            ConversionsData(3, getString(R.string.angle_option_minute), "1 Min", true, minute, "Min"),
            ConversionsData(4, getString(R.string.angle_option_second), "1 Sec", true, second, "Sec"),
            ConversionsData(5, getString(R.string.angle_option_sextant), "1 60°", true, sextant, "60°"),
            ConversionsData(6, getString(R.string.angle_option_quadrant), "1 90°", true, quadrant, "90°"),
            ConversionsData(7, getString(R.string.angle_option_circle), "1 360°", true, circle, "360°")
        )
    }

}