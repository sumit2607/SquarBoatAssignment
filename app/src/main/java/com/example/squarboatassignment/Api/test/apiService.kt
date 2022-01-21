package com.example.squarboatassignment.Api.test

import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.AvailableJobData
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.availableJobs
import io.reactivex.Observable
import retrofit2.http.GET

interface apiService {
    @GET("jobs")
     fun getavailableJobs(   ) : Observable<availableJobs>
}