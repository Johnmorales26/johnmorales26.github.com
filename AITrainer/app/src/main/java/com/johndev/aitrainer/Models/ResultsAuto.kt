package com.johndev.aitrainer.Models

import com.google.gson.annotations.SerializedName

data class ResultsAuto(
    @SerializedName("ID")
    val ID: Int,
    @SerializedName("W0")
    val W0: Float,
    @SerializedName("W1")
    val W1: Float,
    @SerializedName("J")
    val J: Float)
