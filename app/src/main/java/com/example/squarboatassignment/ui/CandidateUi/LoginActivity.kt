package com.example.squarboatassignment.ui.CandidateUi

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.squarboatassignment.R
import com.example.squarboatassignment.data.models.Candidate.Login.Login
import com.example.squarboatassignment.ui.AllViewModel.CandidateviewModel.CandidateSigninViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.EtEmail
import kotlinx.android.synthetic.main.activity_login.EtPassword
import kotlinx.android.synthetic.main.activity_login.signInBtn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: CandidateSigninViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        forgetPassword.setOnClickListener{
            val intent = Intent(this , ForgetPassword::class.java)
            startActivity(intent)
        }

        button6.setOnClickListener{
            val intent = Intent(this , AvailableJobs::class.java)
            startActivity(intent)
        }

        TvSignUp2.setOnClickListener{
            val intent = Intent(this , SignUpActivity::class.java)
            startActivity(intent)
        }

        initViewModel()
        signInBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                LoginCandidate()
            }

        }
    }

    private suspend fun LoginCandidate() {
        val user  = Login( EtEmail.text.toString(), EtPassword.text.toString())
        viewModel.signInNewUser(user)

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(CandidateSigninViewModel::class.java)
        viewModel.getCreateNewUserObserver().observe(this, Observer <Login?>{

            if(it  == null) {
                Toast.makeText(this, "Failed to create User", Toast.LENGTH_LONG).show()
            } else {
                //{"code":201,"meta":null,"data":{"id":2877,"name":"xxxxxaaaaabbbbb","email":"xxxxxaaaaabbbbb@gmail.com","gender":"male","status":"active"}}
                Toast.makeText(this, "Successfully created User", Toast.LENGTH_LONG).show()

            }
        })
    }
}