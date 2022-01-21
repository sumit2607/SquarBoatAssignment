package com.example.squarboatassignment.ui.CandidateUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.squarboatassignment.Adapter.AllJobAdapter
import com.example.squarboatassignment.Api.Network
import com.example.squarboatassignment.Api.test.apiService
import com.example.squarboatassignment.R
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.AvailableJobData
import com.example.squarboatassignment.data.repo.myRepo
import com.example.squarboatassignment.ui.AllViewModel.CandidateviewModel.myViewModel
import com.example.squarboatassignment.ui.AllViewModel.CandidateviewModel.myViewModelFactory
import kotlinx.android.synthetic.main.activity_available_jobs.*

class AvailableJobs : AppCompatActivity() {
    lateinit var myRepo: myRepo
    lateinit var factory: myViewModelFactory
    lateinit var myviewModel: myViewModel
    var dataList = ArrayList<AvailableJobData>()
    lateinit var adapter : AllJobAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_available_jobs)



        myRepo = myRepo()
        factory = myViewModelFactory(myRepo)
        myviewModel = ViewModelProviders.of(this, factory).get(myViewModel::class.java)
        dataList.addAll(myviewModel.get())
        setRecycle()
    }

    private fun setRecycle() {
        adapter = AllJobAdapter(dataList, this)
        val layoutManager = LinearLayoutManager(this)
        recyclerview.adapter= adapter
        recyclerview.layoutManager=layoutManager
    }
}