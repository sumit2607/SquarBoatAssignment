package com.example.squarboatassignment.ui.AllViewModel.RecruiterViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.squarboatassignment.Api.Network
import com.example.squarboatassignment.Api.RecruiterApiService
import com.example.squarboatassignment.data.models.Recruiter.signup.NewRecruiterSignup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecruiterSignUpViewModel : ViewModel() {
    lateinit var RecruiterSignUpLiveData: MutableLiveData<NewRecruiterSignup?>
    init {
        RecruiterSignUpLiveData = MutableLiveData()
    }

    fun getCreateNewUserObserver(): MutableLiveData<NewRecruiterSignup?> {
        return RecruiterSignUpLiveData
    }


    suspend fun RecruiterSignUp(user: NewRecruiterSignup) {
        val retroService  = Network.getInstance().create(RecruiterApiService::class.java)
        val call = retroService.signUp(user)
        call.enqueue(object: Callback<NewRecruiterSignup> {
            override fun onFailure(call: Call<NewRecruiterSignup>, t: Throwable) {
                RecruiterSignUpLiveData.postValue(null)
            }

            override fun onResponse(call: Call<NewRecruiterSignup>, response: Response<NewRecruiterSignup>) {
                if(response.isSuccessful) {
                    RecruiterSignUpLiveData.postValue(response.body())
                } else {
                    RecruiterSignUpLiveData.postValue(null)
                }
            }



        })
    }


}
