package com.example.tipcalculator

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("_id")
    val id: String,
    val registration: String,
    val brand: String,
    val model: String,
    val color: String,
    val type: String,
    val year: Int,
    val photo: String
)
