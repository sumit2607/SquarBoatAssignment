package com.example.squarboatassignment.Api

import com.example.squarboatassignment.data.models.Recruiter.ForgetPassword.NewForgetPasword
import com.example.squarboatassignment.data.models.Recruiter.Login.LoginData
import com.example.squarboatassignment.data.models.Recruiter.Login.NewRecruiterLogin
import com.example.squarboatassignment.data.models.Recruiter.PostJob.NewPostJob
import com.example.squarboatassignment.data.models.Recruiter.PostJob.PostJobData
import com.example.squarboatassignment.data.models.Recruiter.passwordChange.Data
import com.example.squarboatassignment.data.models.Recruiter.signup.NewRecruiterSignup
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RecruiterApiService {

    @POST("auth/register")
    suspend fun signUp(
        @Body signup: NewRecruiterSignup
    ) : Call<NewRecruiterSignup>

    @POST("auth/login")
    suspend fun login(
        @Body Login : NewRecruiterLogin
    ) : Call<NewRecruiterLogin>


    @POST("auth/resetpassword")
    suspend fun reset(
        @Body resetPassword : NewForgetPasword
    ) : Call<NewForgetPasword>


    @POST("jobs/")
    suspend fun  postJob(
        @Body job: NewPostJob
    ) : Call<NewPostJob>




}