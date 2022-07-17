package com.johndev.smartcalculator.usecases.common

data class ConversionsData(var id: Int, var name: String, var description: String, var visibility: Boolean,
                           var result: Double, var icon: String){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ConversionsData

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}