package com.example.squarboatassignment.ui.AllViewModel.CandidateviewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.squarboatassignment.Api.CandidateApiService
import com.example.squarboatassignment.Api.Network
import com.example.squarboatassignment.data.models.Candidate.Login.Login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CandidateSigninViewModel : ViewModel() {
    lateinit var createNewUserLiveData: MutableLiveData<Login?>
    init {
        createNewUserLiveData = MutableLiveData()
    }

    fun getCreateNewUserObserver(): MutableLiveData<Login?> {
        return createNewUserLiveData
    }


    suspend fun signInNewUser(user: Login) {
        val retroService  = Network.getInstance().create(CandidateApiService::class.java)
        val call = retroService.login(user)
        call.enqueue(object: Callback<Login> {
            override fun onFailure(call: Call<Login>, t: Throwable) {
                createNewUserLiveData.postValue(null)
            }

            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                if(response.isSuccessful) {
                    createNewUserLiveData.postValue(response.body())
                } else {
                    createNewUserLiveData.postValue(null)
                }
            }
        })
    }


}
