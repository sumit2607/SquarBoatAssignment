package com.example.squarboatassignment.data.repo

import androidx.lifecycle.LiveData
import com.example.squarboatassignment.Api.CandidateApiService
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.AvailableJobData
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.availableJobs

class myRepo(private val candidateApiService : CandidateApiService) {

    suspend fun getApiResponse(): List<AvailableJobData> {
        return candidateApiService.getavailableJobs().data
    }
}