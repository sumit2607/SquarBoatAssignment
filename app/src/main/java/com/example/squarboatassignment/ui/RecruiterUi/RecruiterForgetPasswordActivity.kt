package com.example.squarboatassignment.ui.RecruiterUi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.squarboatassignment.R
import com.example.squarboatassignment.data.models.Recruiter.ForgetPassword.NewForgetPasword
import com.example.squarboatassignment.ui.AllViewModel.RecruiterViewModel.ForgetPasswordViewModel
import com.example.squarboatassignment.ui.CandidateUi.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecruiterForgetPasswordActivity : AppCompatActivity() {
    lateinit var viewModel: ForgetPasswordViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recruiter_forget_password)


        signInBtn.setOnClickListener{
            val intent = Intent(this , SignUpActivity::class.java)
            startActivity(intent)
        }

        initViewModel()
        signInBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                ForgetPassword()
            }

        }
    }

    private suspend fun ForgetPassword() {
        val user  = NewForgetPasword( EtEmail.text.toString(), EtPassword.text.toString())
        viewModel.forPasswordForget (user)

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(ForgetPasswordViewModel::class.java)
        viewModel.getPasswordForget().observe(this, Observer <NewForgetPasword?>{

            if(it  == null) {
                Toast.makeText(this, "Failed to create User", Toast.LENGTH_LONG).show()
            } else {
                //{"code":201,"meta":null,"data":{"id":2877,"name":"xxxxxaaaaabbbbb","email":"xxxxxaaaaabbbbb@gmail.com","gender":"male","status":"active"}}
                Toast.makeText(this, "Successfully created User", Toast.LENGTH_LONG).show()

            }
        })
    }
}