package com.johndev.smartcalculator.usecases.common

import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.johndev.smartcalculator.provider.services.DatabaseOperationHistory
import com.johndev.smartcalculator.usecases.base.OperationHistory

class AddHistory {


    private lateinit var database: DatabaseOperationHistory

    fun AddHistory(operationHistory: OperationHistory, context: Context, root: ConstraintLayout){
        database = DatabaseOperationHistory(context)

        operationHistory.id = database.insertHistory(operationHistory)
        if (operationHistory.id != -1L){
            Snackbar.make(root, "Operacion Exitosa", Snackbar.LENGTH_SHORT).show()
        }else{
            Snackbar.make(root, "Error Al Modificar", Snackbar.LENGTH_SHORT).show()
        }
    }

}