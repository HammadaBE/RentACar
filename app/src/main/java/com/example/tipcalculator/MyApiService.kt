package com.example.tipcalculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApiService {
    @GET("cars")
    fun getAllCars(): Call<List<Car>>
}
