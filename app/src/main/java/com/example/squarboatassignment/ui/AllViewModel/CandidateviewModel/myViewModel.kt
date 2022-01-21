package com.example.squarboatassignment.ui.AllViewModel.CandidateviewModel

import androidx.lifecycle.*
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.AvailableJobData
import com.example.squarboatassignment.data.repo.myRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class myViewModel(private val movieRepository: myRepo): ViewModel() {

//    init {
//        viewModelScope.launch (Dispatchers.IO){
//            movieRepository.getMovie()
//        }
//    }
//    fun get()=movieRepository.getData()

    fun get() : List<AvailableJobData>{

        return  movieRepository.getMovie()

    }

}