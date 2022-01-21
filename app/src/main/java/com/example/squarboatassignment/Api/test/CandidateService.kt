package com.example.squarboatassignment.Api.test

import com.example.squarboatassignment.Api.CandidateApiService
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.availableJobs
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object CandidateService {
    private  val BASE_URL="https://jobs-api.squareboat.info/api/v1/"


    fun getRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)


        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(
                RxJava2CallAdapterFactory.create())
            .build()



    }
    fun getApiServicetest() = getRetrofit().create(apiService::class.java)

}