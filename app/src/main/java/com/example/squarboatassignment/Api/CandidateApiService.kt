package com.example.squarboatassignment.Api

import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.AvailableJobData
import com.example.squarboatassignment.data.models.Recruiter.Login.LoginData
import com.example.squarboatassignment.data.models.Recruiter.passwordChange.Data
import com.example.squarboatassignment.data.models.Recruiter.signup.SignUpData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CandidateApiService {

    @POST("auth/register")
    suspend fun signUp(
        @Body signup : com.example.squarboatassignment.data.models.Candidate.Signup.Data
    )

    @POST("auth/login")
    suspend fun login(
        @Body Login : com.example.squarboatassignment.data.models.Candidate.Login.Data
    )


    @POST("auth/resetpassword")
    suspend fun reset(
        @Body resetPassword : com.example.squarboatassignment.data.models.Candidate.ForgetPassword.Data
    )

    @POST("candidates/jobs")
    suspend fun Applytojob(
        @Body applyforjob : com.example.squarboatassignment.data.models.Candidate.ApplyToJobs.Data
    )


    @POST("candidates/jobs")
    suspend fun AvailableJobs(
        @Body availableJobs : AvailableJobData
    )

    @GET("candidates/jobs/applied")
    suspend fun appliedjob(
    ) : com.example.squarboatassignment.data.models.Candidate.jobApplied.Data
}