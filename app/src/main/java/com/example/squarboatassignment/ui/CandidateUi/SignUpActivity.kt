package com.example.squarboatassignment.ui.CandidateUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.squarboatassignment.R
import com.example.squarboatassignment.data.models.Candidate.Signup.NewSignUpUser
import com.example.squarboatassignment.ui.AllViewModel.CandidateviewModel.SignUpViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {
    lateinit var viewModel: SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initViewModel()
        signUpBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                SignupCandidate()
            }

        }
    }

    private suspend fun SignupCandidate() {
        val user  = NewSignUpUser("", emaillEt.text.toString(), nameeEt.text.toString(),
            passworddEt.text.toString() ,  ageEt.text.toString(), userRole.inputType)
        viewModel.createNewUser(user)

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        viewModel.getCreateNewUserObserver().observe(this, Observer <NewSignUpUser?>{

            if(it  == null) {
                Toast.makeText(this, "Failed to create User", Toast.LENGTH_LONG).show()
            } else {
                //{"code":201,"meta":null,"data":{"id":2877,"name":"xxxxxaaaaabbbbb","email":"xxxxxaaaaabbbbb@gmail.com","gender":"male","status":"active"}}
                Toast.makeText(this, "Successfully created User", Toast.LENGTH_LONG).show()
            }
        })
    }
}