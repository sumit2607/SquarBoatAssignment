package com.example.squarboatassignment.Api

import com.example.squarboatassignment.data.models.Recruiter.Login.LoginData
import com.example.squarboatassignment.data.models.Recruiter.PostJob.PostJobData
import com.example.squarboatassignment.data.models.Recruiter.passwordChange.Data
import com.example.squarboatassignment.data.models.Recruiter.signup.SignUpData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RecruiterApiService {

    @POST("auth/register")
    suspend fun signUp(
        @Body signup : SignUpData
    )

    @POST("auth/login")
    suspend fun login(
        @Body Login : LoginData
    )


    @POST("auth/resetpassword")
    suspend fun reset(
        @Body resetPassword :  Data
    )


    @POST("jobs/")
    suspend fun  postJob(
        @Body job: PostJobData
    )




}