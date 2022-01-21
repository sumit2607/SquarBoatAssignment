package com.example.squarboatassignment.ui.AllViewModel.RecruiterViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.squarboatassignment.Api.Network
import com.example.squarboatassignment.Api.RecruiterApiService
import com.example.squarboatassignment.data.models.Recruiter.ForgetPassword.NewForgetPasword
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgetPasswordViewModel : ViewModel(){
    lateinit var LiveDataPasswordForget: MutableLiveData<NewForgetPasword?>
    init {
        LiveDataPasswordForget = MutableLiveData()
    }

    fun getPasswordForget(): MutableLiveData<NewForgetPasword?> {
        return LiveDataPasswordForget
    }


    suspend fun forPasswordForget(user: NewForgetPasword) {
        val retroService  = Network.getInstance().create(RecruiterApiService::class.java)
        val call = retroService.reset(user)
        call.enqueue(object: Callback<NewForgetPasword> {
            override fun onFailure(call: Call<NewForgetPasword>, t: Throwable) {
                LiveDataPasswordForget.postValue(null)
            }

            override fun onResponse(call: Call<NewForgetPasword>, response: Response<NewForgetPasword>) {
                if(response.isSuccessful) {
                    LiveDataPasswordForget.postValue(response.body())
                } else {
                    LiveDataPasswordForget.postValue(null)
                }
            }
        })
    }


}
