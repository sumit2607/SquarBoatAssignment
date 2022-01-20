package com.example.squarboatassignment.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.squarboatassignment.data.repo.myRepo

class myViewModelFactory(private val myRepo: myRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return myViewModel(myRepo) as T
    }
}