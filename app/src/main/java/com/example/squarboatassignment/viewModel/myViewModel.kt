package com.example.squarboatassignment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.AvailableJobData
import com.example.squarboatassignment.data.repo.myRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class myViewModel( val myRepo: myRepo) : ViewModel(){

    private val jobliveData  = MutableLiveData<List<AvailableJobData>>()

    val liveData : LiveData<List<AvailableJobData>> =  jobliveData



     fun getApiData() {
         CoroutineScope(Dispatchers.IO).launch {
             var myData = myRepo.getApiResponse()
             jobliveData.postValue(myData)
         }

    }

}