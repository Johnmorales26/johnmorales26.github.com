package com.johndev.aitrainer.common

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.johndev.aitrainer.Models.Automatic
import com.johndev.aitrainer.R
import com.johndev.aitrainer.databinding.FragmentChartBinding
import com.johndev.aitrainer.regresion_automatic.AutomaticCalculoFragment.Companion.resultsPerceptron

class ChartFragment : Fragment() {

    private var _binding: FragmentChartBinding? = null
    private val binding get() = _binding!!
    private var valuesCosto: MutableList<Entry> = mutableListOf()
    private lateinit var valuesW: MutableList<Entry>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sortChartData()

        //Toast.makeText(context, chartData.size.toString(), Toast.LENGTH_SHORT).show()
        binding.btnChargeGrafic.setOnClickListener {
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
            //val yValues: MutableList<Entry> = dataValues1()
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

    private fun sortChartData() {
        val chartData = resultsPerceptron
        val sortChartData: MutableList<Automatic> = mutableListOf()
        var x = 0
        while (x < chartData.size) {
            if ((x % 1000) == 0) sortChartData.add(chartData[x])
            x++
        }
        //Toast.makeText(context, sortChartData.size.toString(), Toast.LENGTH_SHORT).show()
        configureValues(sortChartData)
    }

    private fun configureValues(sortChartData: MutableList<Automatic>) {
        for (results in sortChartData){
            //  Variable independiente en eje X - W
            //  Variable dependiente en eje Y - Costo
            valuesCosto.add(Entry(results.id.toFloat(), results.J))
        }
        Toast.makeText(context, "${valuesCosto.size}", Toast.LENGTH_SHORT).show()
    }

    private fun dataValues1(): MutableList<Entry> {
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