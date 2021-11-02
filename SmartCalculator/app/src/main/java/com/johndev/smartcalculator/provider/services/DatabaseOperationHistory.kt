package com.johndev.smartcalculator.provider.services

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.johndev.smartcalculator.usecases.base.OperationHistory

class DatabaseOperationHistory(context: Context) : SQLiteOpenHelper(context,
    ConstantsDatabase.DATABASE_NAME, null, ConstantsDatabase.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        ConstantsDatabase.apply {
            val createTable = "CREATE TABLE $DATABASE_NAME_TABLE (" +
                    "$DATABASE_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$DATABASE_NAME_FIGURE VARCHAR(20), " +
                    "$DATABASE_IMAGE INTEGER, " +
                    "$DATABASE_SIDE_A REAL, " +
                    "$DATABASE_SIDE_B REAL, " +
                    "$DATABASE_SIDE_C REAL, " +
                    "$DATABASE_HEIGHT REAL, " +
                    "$DATABASE_WIDTH REAL, " +
                    "$DATABASE_RADIUS_A REAL, " +
                    "$DATABASE_RADIUS_B REAL, " +
                    "$DATABASE_RADIUS_C REAL, " +
                    "$DATABASE_ANGLE_A REAL, " +
                    "$DATABASE_ANGLE_AB REAL, " +
                    "$DATABASE_ANGLE_BC REAL, " +
                    "$DATABASE_ANGLE_AC REAL, " +
                    "$DATABASE_HEIGHT_A REAL, " +
                    "$DATABASE_HEIGHT_B REAL, " +
                    "$DATABASE_HEIGHT_C REAL, " +
                    "$DATABASE_AREA REAL, " +
                    "$DATABASE_PERIMETER REAL, " +
                    "$DATABASE_LATERAL_AREA REAL, " +
                    "$DATABASE_VOLUME REAL);"
            db?.execSQL(createTable)
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    @SuppressLint("Range")
    fun getAllHistory(): MutableList<OperationHistory>{
        val historys: MutableList<OperationHistory> = mutableListOf()
        val database = this.readableDatabase
        val query = "SELECT * FROM ${ConstantsDatabase.DATABASE_NAME_TABLE}"
        val result = database.rawQuery(query, null)
        if (result.moveToFirst()){
            do {
                val history = OperationHistory()
                with(history){
                    ConstantsDatabase.apply {
                        //  Obligatory Data
                        id = result.getLong(result.getColumnIndex(DATABASE_ID))
                        nameFigure = result.getString(result.getColumnIndex(DATABASE_NAME_FIGURE))
                        image = result.getInt(result.getColumnIndex(DATABASE_IMAGE))
                        //  Optional Data
                        sideA = result.getDouble(result.getColumnIndex(DATABASE_SIDE_A))
                        sideB = result.getDouble(result.getColumnIndex(DATABASE_SIDE_B))
                        sideC = result.getDouble(result.getColumnIndex(DATABASE_SIDE_C))
                        height = result.getDouble(result.getColumnIndex(DATABASE_HEIGHT))
                        width = result.getDouble(result.getColumnIndex(DATABASE_WIDTH))
                        radiusA = result.getDouble(result.getColumnIndex(DATABASE_RADIUS_A))
                        radiusB = result.getDouble(result.getColumnIndex(DATABASE_RADIUS_B))
                        radiusC = result.getDouble(result.getColumnIndex(DATABASE_RADIUS_C))
                        angleA = result.getDouble(result.getColumnIndex(DATABASE_ANGLE_A))
                        angleAB = result.getString(result.getColumnIndex(DATABASE_ANGLE_AB))
                        angleBC = result.getString(result.getColumnIndex(DATABASE_ANGLE_BC))
                        angleAC = result.getString(result.getColumnIndex(DATABASE_ANGLE_AC))
                        heightA = result.getString(result.getColumnIndex(DATABASE_HEIGHT_A))
                        heightB = result.getString(result.getColumnIndex(DATABASE_HEIGHT_B))
                        heightC = result.getString(+result.getColumnIndex(DATABASE_HEIGHT_C))
                        area = result.getString(result.getColumnIndex(DATABASE_AREA))
                        perimeter = result.getString(result.getColumnIndex(DATABASE_PERIMETER))
                        lateralArea = result.getString(result.getColumnIndex(DATABASE_LATERAL_AREA))
                        volume = result.getString(result.getColumnIndex(DATABASE_VOLUME))
                    }
                }
                historys.add(history)
            } while (result.moveToNext())
        }
        return historys
    }

    fun insertHistory(operationHistory: OperationHistory): Long {
        val database = this.writableDatabase
        val contentValues = ContentValues().apply {
            ConstantsDatabase.apply {
                put(DATABASE_NAME_FIGURE, operationHistory.nameFigure)
                put(DATABASE_IMAGE, operationHistory.image)
                put(DATABASE_SIDE_A, operationHistory.sideA)
                put(DATABASE_SIDE_B, operationHistory.sideB)
                put(DATABASE_SIDE_C, operationHistory.sideC)
                put(DATABASE_HEIGHT, operationHistory.height)
                put(DATABASE_WIDTH, operationHistory.width)
                put(DATABASE_RADIUS_A, operationHistory.radiusA)
                put(DATABASE_RADIUS_B, operationHistory.radiusB)
                put(DATABASE_RADIUS_C, operationHistory.radiusC)
                put(DATABASE_ANGLE_A, operationHistory.angleA)
                put(DATABASE_ANGLE_AB, operationHistory.angleAB)
                put(DATABASE_ANGLE_BC, operationHistory.angleBC)
                put(DATABASE_ANGLE_AC, operationHistory.angleAC)
                put(DATABASE_HEIGHT_A, operationHistory.heightA)
                put(DATABASE_HEIGHT_B, operationHistory.heightB)
                put(DATABASE_HEIGHT_C, operationHistory.heightC)
                put(DATABASE_AREA, operationHistory.area)
                put(DATABASE_LATERAL_AREA, operationHistory.lateralArea)
                put(DATABASE_VOLUME, operationHistory.volume)
            }
        }
        val resultId = database.insert(
            ConstantsDatabase.DATABASE_NAME_TABLE, null,
            contentValues)
        return resultId
    }
}