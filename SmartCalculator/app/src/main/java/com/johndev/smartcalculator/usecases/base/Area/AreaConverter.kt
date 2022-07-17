package ConverterArea

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

class AreaConverter {

    private lateinit var operations: Array<Double>

    fun areaConverter(areaValue: Double): MutableMap<String, Double> {
        operations = arrayOf(1.0, 0.00024710538146717, 10000.0, 1.0, 10000.0,
            0.01, 0.01, 0.0001, 100.0, 100000000000000.0, 100000000.0,
            0.000038610215854245, 100000000000000000000.0, 1076.391041671, 155000.31000062, 155000.31000062)
        return mutableMapOf(
            (nameArea to operations[0] * areaValue),
            (nameAcre to operations[1] * areaValue),
            (nameCentimetro to operations[2] * areaValue),
            (nameDecametro to operations[3] * areaValue),
            (nameDecimetro to operations[4] * areaValue),
            (nameHectarea to operations[5] * areaValue),
            (nameHectometro to operations[6] * areaValue),
            (nameKilometro to operations[7] * areaValue),
            (nameMetro to operations[8] * areaValue),
            (nameMicrometro to operations[9] * areaValue),
            (nameMilimetro to operations[10] * areaValue),
            (nameMilla to operations[11] * areaValue),
            (nameNanometro to operations[12] * areaValue),
            (namePie to operations[13] * areaValue),
            (namePulgada to operations[14] * areaValue),
            (nameYarda to operations[15] * areaValue),
            /*AreaConverterData(1, "ar", "Area", operations[0], operations[0] * areaValue),
            AreaConverterData(2, "ac", "Acre", operations[1], operations[1] * areaValue),
            AreaConverterData(3, "cm^2", "Centimetro", operations[2], operations[2] * areaValue),
            AreaConverterData(4, "dkm^2", "Decametro", operations[3], operations[3] * areaValue),
            AreaConverterData(5, "dm^2", "Decimetro", operations[4], operations[4] * areaValue),
            AreaConverterData(6, "ha", "Hectarea", operations[5], operations[5] * areaValue),
            AreaConverterData(7, "hm^2", "Hectometro", operations[6], operations[6] * areaValue),
            AreaConverterData(8, "km^2", "Kilometro", operations[7], operations[7] * areaValue),
            AreaConverterData(9, "m^2", "Metro", operations[8], operations[8] * areaValue),
            AreaConverterData(10, "µm^2", "Micrometro", operations[9], operations[9] * areaValue),
            AreaConverterData(11, "mm^2", "Milimetro", operations[10], operations[10] * areaValue),
            AreaConverterData(12, "mi^2", "Milla", operations[11], operations[11] * areaValue),
            AreaConverterData(13, "nm^2", "Nanometro", operations[12], operations[12] * areaValue),
            AreaConverterData(14, "ft^2", "Pie", operations[13], operations[13] * areaValue),
            AreaConverterData(15, "in^2", "Pulgada", operations[14], operations[14] * areaValue),
            AreaConverterData(16, "yd^2", "Yarda", operations[15], operations[15] * areaValue),*/
        )
    }

}