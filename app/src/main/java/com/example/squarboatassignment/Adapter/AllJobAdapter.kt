package com.example.squarboatassignment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.squarboatassignment.R
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.AvailableJobData

class AllJobAdapter(private val list :  List<AvailableJobData>, val context: Context) : RecyclerView.Adapter<AllJobsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllJobsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return AllJobsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllJobsViewHolder, position: Int) {
        val availableJobshere = list[position]
        holder.setData(availableJobshere)
    }

    override fun getItemCount(): Int {
       return list.size
    }
}