package com.example.squarboatassignment.ui.AllViewModel.CandidateviewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.squarboatassignment.data.repo.myRepo

class myViewModelFactory(private val movieRepository: myRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return myViewModel(movieRepository) as T
    }
}