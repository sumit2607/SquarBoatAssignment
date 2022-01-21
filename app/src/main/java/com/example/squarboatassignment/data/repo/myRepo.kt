package com.example.squarboatassignment.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.squarboatassignment.Api.test.apiService
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.AvailableJobData

class myRepo(private val api: apiService) {

    private val movieLiveData: MutableLiveData<AvailableJobData> = MutableLiveData()

    fun getData(): LiveData<AvailableJobData> {
        return movieLiveData
    }


    suspend fun getMovie() {
        val result = api.getavailableJobs()
        if (result != null) {
            movieLiveData.postValue(result)
        }

    }
}