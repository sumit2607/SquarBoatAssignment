package com.example.squarboatassignment.ui.AllViewModel.RecruiterViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.squarboatassignment.Api.Network
import com.example.squarboatassignment.Api.RecruiterApiService
import com.example.squarboatassignment.data.models.Recruiter.PostJob.NewPostJob
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostJobViewModel : ViewModel() {
    lateinit var PostJobLiveData: MutableLiveData<NewPostJob?>
    init {
        PostJobLiveData = MutableLiveData()
    }

    fun getCreateNewUserObserver(): MutableLiveData<NewPostJob?> {
        return PostJobLiveData
    }


    suspend fun PostJob(user: NewPostJob) {
        val retroService  = Network.getInstance().create(RecruiterApiService::class.java)
        val call = retroService.postJob(user)
        call.enqueue(object: Callback<NewPostJob> {
            override fun onFailure(call: Call<NewPostJob>, t: Throwable) {
                PostJobLiveData.postValue(null)
            }

            override fun onResponse(call: Call<NewPostJob>, response: Response<NewPostJob>) {
                if(response.isSuccessful) {
                    PostJobLiveData.postValue(response.body())
                } else {
                    PostJobLiveData.postValue(null)
                }
            }
        })
    }


}
