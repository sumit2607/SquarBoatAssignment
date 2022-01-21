package com.example.squarboatassignment.Api

import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.AvailableJobData
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.availableJobs
import com.example.squarboatassignment.data.models.Candidate.Login.Login
import com.example.squarboatassignment.data.models.Candidate.Signup.NewSignUpUser
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CandidateApiService {

    @POST("auth/register")
    suspend fun signUp(
        @Body signup: NewSignUpUser
    ) : Call<com.example.squarboatassignment.data.models.Candidate.Signup.NewSignUpUser>

    @POST("auth/login")
    suspend fun login(
        @Body Login : com.example.squarboatassignment.data.models.Candidate.Login.Login
    ) : Call<Login>


    @POST("auth/resetpassword")
    suspend fun reset(
        @Body resetPassword : com.example.squarboatassignment.data.models.Candidate.ForgetPassword.Data
    )

    @GET("api/v1/jobs")
    suspend fun getavailableJobs(   ) : AvailableJobData



    @POST("candidates/jobs")
    suspend fun AvailableJobs(
        @Body availableJobs : AvailableJobData
    )

    @GET("candidates/jobs/applied")
    suspend fun appliedjob(
    ) : com.example.squarboatassignment.data.models.Candidate.jobApplied.Data
}