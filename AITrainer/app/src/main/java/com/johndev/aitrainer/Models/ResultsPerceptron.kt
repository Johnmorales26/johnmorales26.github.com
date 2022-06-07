package com.johndev.aitrainer.Models

data class ResultsPerceptron (val id: Int,
                              val valueW: Float,
                              val valorB: Float,
                              val iterations: Int? = null,
                              val maxVal: Float? = null,
                              val minVal: Float? = null,
                              val valuesX: MutableList<Float>,
                              val valuesY: MutableList<Float>,
                              val valueJW: Float,
                              val derivada: Float,
                              val error: MutableList<Float>,
                              val guess: MutableList<Float>,
val costo: Float)