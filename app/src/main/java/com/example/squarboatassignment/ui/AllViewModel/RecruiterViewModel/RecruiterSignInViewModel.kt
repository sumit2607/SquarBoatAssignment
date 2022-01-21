package com.example.squarboatassignment.ui.AllViewModel.RecruiterViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.squarboatassignment.Api.Network
import com.example.squarboatassignment.Api.RecruiterApiService
import com.example.squarboatassignment.data.models.Recruiter.Login.NewRecruiterLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecruiterSignInViewModel : ViewModel() {
    lateinit var RecruiterSignInLiveData: MutableLiveData<NewRecruiterLogin?>
    init {
        RecruiterSignInLiveData = MutableLiveData()
    }

    fun getCreateNewUserObserver(): MutableLiveData<NewRecruiterLogin?> {
        return RecruiterSignInLiveData
    }


    suspend fun RecruiterSignIn(user: NewRecruiterLogin) {
        val retroService  = Network.getInstance().create(RecruiterApiService::class.java)
        val call = retroService.login(user)
        call.enqueue(object: Callback<NewRecruiterLogin> {
            override fun onFailure(call: Call<NewRecruiterLogin>, t: Throwable) {
                RecruiterSignInLiveData.postValue(null)
            }

            override fun onResponse(call: Call<NewRecruiterLogin>, response: Response<NewRecruiterLogin>) {
                if(response.isSuccessful) {
                    RecruiterSignInLiveData.postValue(response.body())
                } else {
                    RecruiterSignInLiveData.postValue(null)
                }
            }
        })
    }


}

