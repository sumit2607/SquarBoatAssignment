package com.example.squarboatassignment.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.AvailableJobData
import kotlinx.android.synthetic.main.item_layout.view.*

class AllJobsViewHolder(val view :View) : RecyclerView.ViewHolder(view){
    fun setData(AvailableJobData : AvailableJobData){
        view.apply {
            textView4.text = AvailableJobData.createdAt
            textView5.text = AvailableJobData.id
            textView6.text = AvailableJobData.location
            textView7.text = AvailableJobData.title
            textView8.text = AvailableJobData.description
            textView9.text = AvailableJobData.updatedAt
        }
    }


}
