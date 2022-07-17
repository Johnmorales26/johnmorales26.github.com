package com.johndev.smartcalculator.usecases.common

import DataClases.Angles.Angles
import DataClases.DataStorage.OperationsDataStorage
import Time.AgregarRestarTiempo
import Time.DiferenciaHoraria

class Conections {

    companion object{
        val addSubTime = AgregarRestarTiempo()
        val differenceTime = DiferenciaHoraria()
        //  Conversor Data
        val dataStorage = OperationsDataStorage()
        val angles = Angles()

    }

}