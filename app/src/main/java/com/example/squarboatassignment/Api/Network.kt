package com.example.squarboatassignment.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private  val BASE_URL="https://jobs-api.squareboat.info/api/v1/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}