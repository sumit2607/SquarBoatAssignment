package com.example.squarboatassignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.squarboatassignment.Adapter.AllJobAdapter
import com.example.squarboatassignment.Api.CandidateApiService
import com.example.squarboatassignment.Api.Network
import com.example.squarboatassignment.R
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.AvailableJobData
import com.example.squarboatassignment.data.repo.myRepo
import com.example.squarboatassignment.ui.AllViewModel.CandidateviewModel.myViewModel
import com.example.squarboatassignment.ui.AllViewModel.CandidateviewModel.myViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
