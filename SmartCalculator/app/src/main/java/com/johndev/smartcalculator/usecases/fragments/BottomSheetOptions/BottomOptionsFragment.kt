package com.johndev.smartcalculator.usecases.fragments.BottomSheetOptions

import ConverterArea.AreaTypes.icArea
import ConverterArea.AreaTypes.icCentimetro
import ConverterArea.AreaTypes.icDecametro
import ConverterArea.AreaTypes.icDecimetro
import ConverterArea.AreaTypes.icHectarea
import ConverterArea.AreaTypes.icHectometro
import ConverterArea.AreaTypes.icKilometro
import ConverterArea.AreaTypes.icMetro
import ConverterArea.AreaTypes.icMicrometro
import ConverterArea.AreaTypes.icMilimetro
import ConverterArea.AreaTypes.icMilla
import ConverterArea.AreaTypes.icNanometro
import ConverterArea.AreaTypes.icPie
import ConverterArea.AreaTypes.icPulgada
import ConverterArea.AreaTypes.icYarda
import ConverterArea.AreaTypes.nameAcre
import ConverterArea.AreaTypes.nameArea
import ConverterArea.AreaTypes.nameCentimetro
import ConverterArea.AreaTypes.nameDecametro
import ConverterArea.AreaTypes.nameDecimetro
import ConverterArea.AreaTypes.nameHectarea
import ConverterArea.AreaTypes.nameHectometro
import ConverterArea.AreaTypes.nameKilometro
import ConverterArea.AreaTypes.nameMetro
import ConverterArea.AreaTypes.nameMicrometro
import ConverterArea.AreaTypes.nameMilimetro
import ConverterArea.AreaTypes.nameMilla
import ConverterArea.AreaTypes.nameNanometro
import ConverterArea.AreaTypes.namePie
import ConverterArea.AreaTypes.namePulgada
import ConverterArea.AreaTypes.nameYarda
import DataClases.DataStorage.DataStorageTypes.bit
import DataClases.DataStorage.DataStorageTypes.bitTerm
import DataClases.DataStorage.DataStorageTypes.byte
import DataClases.DataStorage.DataStorageTypes.byteTerm
import DataClases.DataStorage.DataStorageTypes.gibibit
import DataClases.DataStorage.DataStorageTypes.gibibitTerm
import DataClases.DataStorage.DataStorageTypes.gibibyte
import DataClases.DataStorage.DataStorageTypes.gibibyteTerm
import DataClases.DataStorage.DataStorageTypes.gigabit
import DataClases.DataStorage.DataStorageTypes.gigabitTerm
import DataClases.DataStorage.DataStorageTypes.gigabyte
import DataClases.DataStorage.DataStorageTypes.gigabyteTerm
import DataClases.DataStorage.DataStorageTypes.kibibit
import DataClases.DataStorage.DataStorageTypes.kibibitTerm
import DataClases.DataStorage.DataStorageTypes.kibibyte
import DataClases.DataStorage.DataStorageTypes.kibibyteTerm
import DataClases.DataStorage.DataStorageTypes.kilobit
import DataClases.DataStorage.DataStorageTypes.kilobitTerm
import DataClases.DataStorage.DataStorageTypes.kilobyte
import DataClases.DataStorage.DataStorageTypes.kilobyteTerm
import DataClases.DataStorage.DataStorageTypes.mebibit
import DataClases.DataStorage.DataStorageTypes.mebibitTerm
import DataClases.DataStorage.DataStorageTypes.mebibyte
import DataClases.DataStorage.DataStorageTypes.mebibyteTerm
import DataClases.DataStorage.DataStorageTypes.megabit
import DataClases.DataStorage.DataStorageTypes.megabitTerm
import DataClases.DataStorage.DataStorageTypes.megabyte
import DataClases.DataStorage.DataStorageTypes.megabyteTerm
import DataClases.DataStorage.DataStorageTypes.pebibit
import DataClases.DataStorage.DataStorageTypes.pebibitTerm
import DataClases.DataStorage.DataStorageTypes.pebibyte
import DataClases.DataStorage.DataStorageTypes.pebibyteTerm
import DataClases.DataStorage.DataStorageTypes.petabit
import DataClases.DataStorage.DataStorageTypes.petabitTerm
import DataClases.DataStorage.DataStorageTypes.petabyte
import DataClases.DataStorage.DataStorageTypes.petabyteTerm
import DataClases.DataStorage.DataStorageTypes.tebibit
import DataClases.DataStorage.DataStorageTypes.tebibitTerm
import DataClases.DataStorage.DataStorageTypes.tebibyteTerm
import DataClases.DataStorage.DataStorageTypes.terabit
import DataClases.DataStorage.DataStorageTypes.terabitTerm
import DataClases.DataStorage.DataStorageTypes.terabyte
import DataClases.DataStorage.DataStorageTypes.terabyteTerm
import android.app.Dialog
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.johndev.smartcalculator.ColorsExtra
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentBottomOptionsBinding
import com.johndev.smartcalculator.usecases.Adapters.BottomOptionsAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnBottomOptions
import com.johndev.smartcalculator.usecases.common.BottomOptions

class BottomOptionsFragment(private val onSubmitClickListener: (BottomOptions) -> Unit): BottomSheetDialogFragment(), OnBottomOptions {

    private var binding: FragmentBottomOptionsBinding? = null
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>
    private lateinit var adapter: BottomOptionsAdapter
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentBottomOptionsBinding.inflate(LayoutInflater.from(activity))
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        binding?.let {
            configureTheme()
            val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
            bottomSheetDialog.setContentView(it.root)
            bottomSheetBehavior = BottomSheetBehavior.from(it.root.parent as View)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            val recoveryData: Bundle? = arguments
            binding!!.tvTitle.text = getString(R.string.bottom_shet_optons_title)
            setupRecyclerView(recoveryData?.getString("option"))
            binding!!.btnClose.setOnClickListener { dismiss() }
            configureTheme()
            return bottomSheetDialog
        }
        return super.onCreateDialog(savedInstanceState)
    }

    private fun setupRecyclerView(recovery: String?) {
        val options = inflateOptions(recovery)
        binding?.let {
            adapter = BottomOptionsAdapter(options, this)
            it.recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@BottomOptionsFragment.adapter
            }
        }
    }

    private fun inflateOptions(recovery: String?): MutableList<BottomOptions> {
        return when(recovery){
            //  Ohm's Law Screen
            getString(R.string.other_law_voltaje) -> {
                mutableListOf(
                    BottomOptions(1, "V", getString(R.string.bottom_option_voltio)),
                    BottomOptions(2, "mV", getString(R.string.bottom_option_millivoltio))
                )
            }
            getString(R.string.other_law_corriente) -> {
                mutableListOf(
                    BottomOptions(1, "A", getString(R.string.bottom_option_amperio)),
                    BottomOptions(2, "mA", getString(R.string.bottom_option_milliamperios))
                )
            }
            getString(R.string.other_law_resistencia) -> {
                mutableListOf(
                    BottomOptions(1, "Ω", getString(R.string.bottom_option_ohm)),
                    BottomOptions(2, "mΩ", getString(R.string.bottom_option_milliohm))
                )
            }
            getString(R.string.other_law_potencia) -> {
                mutableListOf(
                    BottomOptions(1, "W", getString(R.string.bottom_option_watio)),
                    BottomOptions(2, "mW", getString(R.string.bottom_option_milivatios)),
                    BottomOptions(3, "kW", getString(R.string.bottom_option_kilowatio))
                )
            }
            //  Percent Screen
            getString(R.string.functions_content_percent) -> {
                mutableListOf(
                    BottomOptions(1, getString(R.string.formula_options_descuento), getString(R.string.menu_options_descuento)),
                    BottomOptions(2, getString(R.string.formula_options_increment), getString(R.string.menu_options_increment)),
                    BottomOptions(3, getString(R.string.formula_options_simple_porcent), getString(R.string.menu_options_simple_porcent)),
                    BottomOptions(4, getString(R.string.formula_options_increment_decrement), getString(R.string.menu_options_increment_decrement)),
                    BottomOptions(5, getString(R.string.formula_options_porcent_from_a_to_b), getString(R.string.menu_options_porcent_from_a_to_b)),
                )
            }
            //  Proportion Screen
            getString(R.string.functions_content_proportion) -> {
                mutableListOf(
                    BottomOptions(1, getString(R.string.formula_options_directly_proportional), getString(R.string.menu_options_directly_proportional)),
                    BottomOptions(2, getString(R.string.formula_options_indirectly_proportionalb), getString(R.string.menu_options_indirectly_proportional))
                )
            }
            //  Angle Options
            getString(R.string.angle_option_radian) -> {
                mutableListOf(
                    BottomOptions(1, "Rad", getString(R.string.angle_option_radian)),
                    BottomOptions(2, "Deg", getString(R.string.angle_option_grade)),
                    BottomOptions(3, "Min", getString(R.string.angle_option_minute)),
                    BottomOptions(4, "Sec", getString(R.string.angle_option_second)),
                    BottomOptions(5, "60°", getString(R.string.angle_option_sextant)),
                    BottomOptions(6, "90°", getString(R.string.angle_option_quadrant)),
                    BottomOptions(7, "360", getString(R.string.angle_option_circle))
                )
            }
            getString(R.string.acceleration_option_meter_over_second) -> {
                mutableListOf(
                    BottomOptions(1, "m/s²", getString(R.string.acceleration_option_meter_over_second)),
                    BottomOptions(2, "ft/s²", getString(R.string.acceleration_option_pie_over_second)),
                    BottomOptions(3, "g", getString(R.string.acceleration_option_gravity)),
                    BottomOptions(4, "cm/s²", getString(R.string.acceleration_option_gal))
                )
            }
            getString(R.string.tv_sum) -> {
                mutableListOf(
                    BottomOptions(1, "+", getString(R.string.tv_sum)),
                    BottomOptions(2, "-", getString(R.string.tv_subtration))
                )
            }
            getString(R.string.month_year_january) -> {
                mutableListOf(
                    BottomOptions(1, "Jan", getString(R.string.month_year_january)),
                    BottomOptions(2, "Feb", getString(R.string.month_year_february)),
                    BottomOptions(3, "Mar", getString(R.string.month_year_march)),
                    BottomOptions(4, "Apr", getString(R.string.month_year_april)),
                    BottomOptions(5, "May", getString(R.string.month_year_may)),
                    BottomOptions(6, "Jun", getString(R.string.month_year_june)),
                    BottomOptions(7, "Jul", getString(R.string.month_year_july)),
                    BottomOptions(8, "Aug", getString(R.string.month_year_august)),
                    BottomOptions(9, "Sep", getString(R.string.month_year_september)),
                    BottomOptions(10, "Oct", getString(R.string.month_year_october)),
                    BottomOptions(11, "Nov", getString(R.string.month_year_november)),
                    BottomOptions(12, "Dic", getString(R.string.month_year_dicember)),
                )
            }
            getString(R.string.hint_value_am) -> {
                mutableListOf(
                    BottomOptions(1, "AM", getString(R.string.hint_value_am)),
                    BottomOptions(2, "PM", getString(R.string.hint_value_pm))
                )
            }
            getString(R.string.storage_option_megabit) -> {
                mutableListOf(
                    BottomOptions(1, bitTerm, bit),
                    BottomOptions(2, byteTerm, byte),
                    BottomOptions(3, kilobitTerm, kilobit),
                    BottomOptions(4, kibibitTerm, kibibit),
                    BottomOptions(5, kilobyteTerm, kilobyte),
                    BottomOptions(6, kibibyteTerm, kibibyte),
                    BottomOptions(7, megabitTerm, megabit),
                    BottomOptions(8, mebibitTerm, mebibit),
                    BottomOptions(9, megabyteTerm, megabyte),
                    BottomOptions(10, mebibyteTerm, mebibyte),
                    BottomOptions(11, gigabitTerm, gigabit),
                    BottomOptions(12, gibibitTerm, gibibit),
                    BottomOptions(13, gigabyteTerm, gigabyte),
                    BottomOptions(14, gibibyteTerm, gibibyte),
                    BottomOptions(15, terabitTerm, terabit),
                    BottomOptions(16, tebibitTerm, tebibit),
                    BottomOptions(17, terabyteTerm, terabyte),
                    BottomOptions(18, tebibyteTerm, pebibyte),
                    BottomOptions(19, pebibyteTerm, pebibyte),
                    BottomOptions(20, petabyteTerm, petabyte),
                    BottomOptions(21, petabitTerm, petabit),
                    BottomOptions(22, pebibitTerm, pebibit),
                )
            }
            getString(R.string.area_option_area) -> {
                mutableListOf(
                    BottomOptions(1, icArea,  nameArea),
                    BottomOptions(2, icArea, nameAcre),
                    BottomOptions(3, icCentimetro, nameCentimetro),
                    BottomOptions(4, icDecametro, nameDecametro),
                    BottomOptions(5, icDecimetro, nameDecimetro),
                    BottomOptions(6, icHectarea, nameHectarea),
                    BottomOptions(7, icHectometro, nameHectometro),
                    BottomOptions(8, icKilometro, nameKilometro),
                    BottomOptions(9, icMetro, nameMetro),
                    BottomOptions(10, icMicrometro, nameMicrometro),
                    BottomOptions(11, icMilimetro, nameMilimetro),
                    BottomOptions(12, icMilla, nameMilla),
                    BottomOptions(13, icNanometro, nameNanometro),
                    BottomOptions(14, icPie, namePie),
                    BottomOptions(15, icPulgada, namePulgada),
                    BottomOptions(16, icYarda, nameYarda)
                )
            }
            else -> { mutableListOf() }
        }
    }

    private fun configureTheme() {
        val theme = sharedPreferences.getString(getString(R.string.key_preference_application_color),
            getString(R.string.preference_key_color_default))
        when(theme) {
            getString(R.string.preference_key_color_default) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryPurpleColor)))
            }
            getString(R.string.preference_key_color_red) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryRedColor)))
            }
            getString(R.string.preference_key_color_yellow) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryYellowColor)))
            }
            getString(R.string.preference_key_color_blue) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryBlueColor)))
            }
            getString(R.string.preference_key_color_green) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryGreenColor)))
            }
            getString(R.string.preference_key_color_purple) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryPurpleColor)))
            }
            getString(R.string.preference_key_color_orange) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryOrangeColor)))
            }
        }
    }

    override fun onClick(bottomOptions: BottomOptions) {
        onSubmitClickListener.invoke(bottomOptions)
        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}