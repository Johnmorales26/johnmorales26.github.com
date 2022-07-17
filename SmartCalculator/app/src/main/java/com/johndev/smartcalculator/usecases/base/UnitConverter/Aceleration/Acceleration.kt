package DataClases.Aceleration

import com.johndev.smartcalculator.usecases.common.Aceleration.AccelerationTypes.TYPE_GAL
import com.johndev.smartcalculator.usecases.common.Aceleration.AccelerationTypes.TYPE_GRAVEDAD
import com.johndev.smartcalculator.usecases.common.Aceleration.AccelerationTypes.TYPE_METRO
import com.johndev.smartcalculator.usecases.common.Aceleration.AccelerationTypes.TYPE_PIE

open class Acceleration {

    fun gal(galValue: Double): Map<String, Double> {
        val meters = 0.01
        val gravity = 0.0010193679918451
        val pie = 0.032808398950131
        return mapOf(
            TYPE_METRO to galValue * meters,
            TYPE_GRAVEDAD to galValue * gravity,
            TYPE_PIE to galValue * pie,
            TYPE_GAL to galValue
        )
    }

    fun meterOverSecond(meterValue: Double): Map<String, Double> {
        val gal = 100
        val gravedad = 0.10193679918451
        val pie = 3.2808398950131
        return mapOf(TYPE_GAL to meterValue * gal,
            TYPE_GRAVEDAD to meterValue * gravedad,
            TYPE_PIE to meterValue * pie,
            TYPE_METRO to meterValue)
    }

    fun gravity(gravityValue: Double): Map<String, Double> {
        val gal = 981
        val meter = 9.81
        val pie = 32.185039370079
        return mapOf(
            TYPE_GAL to gravityValue * gal,
            TYPE_METRO to gravityValue * meter,
            TYPE_PIE to gravityValue * pie,
            TYPE_GRAVEDAD to gravityValue
        )
    }

    fun pie(pieValue: Double): Map<String, Double> {
        val gal = 30.48
        val meter = 0.3048
        val gravedad = 0.031070336391437
        return mapOf(
            TYPE_GAL to pieValue * gal,
            TYPE_METRO to pieValue * meter,
            TYPE_GRAVEDAD to pieValue * gravedad,
            TYPE_PIE to pieValue
        )
    }

}