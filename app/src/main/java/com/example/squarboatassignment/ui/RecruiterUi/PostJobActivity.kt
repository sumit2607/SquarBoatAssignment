package com.example.squarboatassignment.ui.RecruiterUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.squarboatassignment.R
import com.example.squarboatassignment.data.models.Recruiter.PostJob.NewPostJob
import com.example.squarboatassignment.ui.AllViewModel.RecruiterViewModel.PostJobViewModel
import kotlinx.android.synthetic.main.activity_post_job.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostJobActivity : AppCompatActivity() {
    lateinit var viewModel: PostJobViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_job)
        initViewModel()
        button4.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                CreateJob()
            }

        }
    }

    private suspend fun CreateJob() {
        val user  = NewPostJob( editTextJobTitle.text.toString(), editTextDisc.text.toString(), location.text.toString())
        viewModel.PostJob(user)

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(PostJobViewModel::class.java)
        viewModel.getCreateNewUserObserver().observe(this, Observer <NewPostJob?>{

            if(it  == null) {
                Toast.makeText(this, "Failed to create User", Toast.LENGTH_LONG).show()
            } else {
                //{"code":201,"meta":null,"data":{"id":2877,"name":"xxxxxaaaaabbbbb","email":"xxxxxaaaaabbbbb@gmail.com","gender":"male","status":"active"}}
                Toast.makeText(this, "Successfully created User", Toast.LENGTH_LONG).show()
            }
        })
    }
}