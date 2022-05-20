package com.johndev.neurontraining.MainViews

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LimitLine
import com.johndev.neurontraining.R
import com.johndev.neurontraining.databinding.FragmentGraphicsBinding
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.johndev.neurontraining.MainViews.CalculationsFragment.Companion.resultsPerceptron

class GraphicsFragment : Fragment() {

    private var _binding: FragmentGraphicsBinding? = null
    private val binding get() = _binding!!
    private var valuesCosto: MutableList<Entry> = mutableListOf()
    private lateinit var valuesW: MutableList<Entry>
    private var colorArray: MutableList<Int> = mutableListOf(R.color.primaryColor, R.color.primaryDarkColor, R.color.secondaryColor, R.color.secondaryDarkColor)
    private var legendName: Array<String> = arrayOf("Cow", "Dog", "Cat", "Rat")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGraphicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureValues()

        binding.btnChargeGrafic.setOnClickListener {
            Toast.makeText(context, resultsPerceptron.size.toString(), Toast.LENGTH_SHORT).show()
            //binding.chartLine.onChartGestureListener = this
            //binding.chartLine.setOnChartValueSelectedListener(this)
            val upperLimit: LimitLine = LimitLine(65f, "Max Value")
            upperLimit.apply {
                lineWidth = 4f
                enableDashedLine(10f, 10f, 0f)
                labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP
                textSize = 15f
            }
            val lowerLimit: LimitLine = LimitLine(35f, "Min Value")
            lowerLimit.apply {
                lineWidth = 4f
                enableDashedLine(10f, 10f, 0f)
                labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP
                textSize = 15f
            }
            /*val leftAxis: YAxis = binding.chartLine.axisLeft
            leftAxis.apply {
                removeAllLimitLines()
                addLimitLine(upperLimit)
                addLimitLine(lowerLimit)
                axisMaximum = 500f
                axisMinimum = -30f
                enableGridDashedLine(10f, 10f, 0f)
                setDrawLimitLinesBehindData(true)
            }*/

            val yValues: MutableList<Entry> = valuesCosto
            val setOne = LineDataSet(yValues, "Costo Contra W")

            setOne.apply {
                fillAlpha = 110
                color = R.color.primaryColor
                lineWidth = 3f
                valueTextSize = 10f
                valueTextColor = R.color.background
            }

            val dataSets: MutableList<ILineDataSet> = mutableListOf()
            dataSets.add(setOne)
            val data = LineData(dataSets)

            binding.apply {
                chartLine.setTouchEnabled(true)
                chartLine.setPinchZoom(true)
                chartLine.isDragEnabled = true
                chartLine.setScaleEnabled(false)
                chartLine.data = data
                chartLine.animateXY(3500, 3000)
            }
        }
    }

    private fun configureValues() {
        for (results in resultsPerceptron){
            //  Variable independiente en eje X - W
            //  Variable dependiente en eje Y - Costo
            valuesCosto.add(Entry(results.valueW, results.costo))
        }
    }

    private fun dataValues1(): MutableList<Entry>? {
        return mutableListOf(
            Entry(1.0f, -3.0f),
            Entry(3.0f, 5.0f),
            Entry(7.0f, 5.0f),
            Entry(9.0f, 3.0f),
            Entry(11.0f, 5.0f),
            Entry(7.0f, 1.0f),
            Entry(3.0f, 1.0f),
            Entry(3.0f, 1.0f)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}