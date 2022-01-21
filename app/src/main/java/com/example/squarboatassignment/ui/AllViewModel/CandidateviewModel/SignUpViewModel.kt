package com.example.squarboatassignment.ui.AllViewModel.CandidateviewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.squarboatassignment.Api.CandidateApiService
import com.example.squarboatassignment.Api.Network
import com.example.squarboatassignment.data.models.Candidate.Signup.NewSignUpUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : ViewModel(){
    lateinit var createNewUserLiveData: MutableLiveData<NewSignUpUser?>
    init {
        createNewUserLiveData = MutableLiveData()
    }

    fun getCreateNewUserObserver(): MutableLiveData<NewSignUpUser?> {
        return createNewUserLiveData
    }


    suspend fun createNewUser(user: NewSignUpUser) {
        val retroService  = Network.getInstance().create(CandidateApiService::class.java)
        val call = retroService.signUp(user)
        call.enqueue(object: Callback<NewSignUpUser> {
            override fun onFailure(call: Call<NewSignUpUser>, t: Throwable) {
                createNewUserLiveData.postValue(null)
            }

            override fun onResponse(call: Call<NewSignUpUser>, response: Response<NewSignUpUser>) {
                if(response.isSuccessful) {
                    createNewUserLiveData.postValue(response.body())
                } else {
                    createNewUserLiveData.postValue(null)
                }
            }

        })
    }


}
