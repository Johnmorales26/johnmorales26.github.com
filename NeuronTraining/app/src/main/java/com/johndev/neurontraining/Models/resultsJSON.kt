package com.johndev.neurontraining.Models

import com.google.gson.annotations.SerializedName

data class ResultsJSON(
    @SerializedName("id")
    val id: Int,
    @SerializedName("w")
    val w: Float,
    @SerializedName("jw")
    val jw: Float)
