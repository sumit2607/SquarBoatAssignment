package com.example.squarboatassignment.ui.RecruiterUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.squarboatassignment.R
import com.example.squarboatassignment.data.models.Recruiter.signup.NewRecruiterSignup
import com.example.squarboatassignment.ui.AllViewModel.RecruiterViewModel.RecruiterSignUpViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecruiterSignUp : AppCompatActivity() {

    lateinit var viewModel: RecruiterSignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recruiter_sign_up)


        initViewModel()
        signUpBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Signup()
            }

        }
    }

    private suspend fun Signup() {
        val user  = NewRecruiterSignup("", emaillEt.text.toString(), nameeEt.text.toString(),
            passworddEt.text.toString() ,  ageEt.text.toString(), userRole.inputType)
        viewModel.RecruiterSignUp(user)

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(RecruiterSignUpViewModel::class.java)
        viewModel.getCreateNewUserObserver().observe(this, Observer <NewRecruiterSignup?>{

            if(it  == null) {
                Toast.makeText(this, "Failed to create User", Toast.LENGTH_LONG).show()
            } else {
                //{"code":201,"meta":null,"data":{"id":2877,"name":"xxxxxaaaaabbbbb","email":"xxxxxaaaaabbbbb@gmail.com","gender":"male","status":"active"}}
                Toast.makeText(this, "Successfully created User", Toast.LENGTH_LONG).show()
            }
        })
    }
}