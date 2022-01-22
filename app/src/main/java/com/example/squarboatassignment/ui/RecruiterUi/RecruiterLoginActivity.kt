package com.example.squarboatassignment.ui.RecruiterUi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.squarboatassignment.R
import com.example.squarboatassignment.data.models.Recruiter.Login.NewRecruiterLogin
import com.example.squarboatassignment.ui.AllViewModel.RecruiterViewModel.RecruiterSignInViewModel
import com.example.squarboatassignment.ui.CandidateUi.ForgetPassword
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.EtEmail
import kotlinx.android.synthetic.main.activity_login.EtPassword
import kotlinx.android.synthetic.main.activity_login.signInBtn
import kotlinx.android.synthetic.main.activity_recrutar_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecruiterLoginActivity : AppCompatActivity() {

    lateinit var viewModel: RecruiterSignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recrutar_login)

        forgetPasswordr.setOnClickListener{
            val intent = Intent(this , RecruiterForgetPasswordActivity::class.java)
            startActivity(intent)
        }

        button5.setOnClickListener{
            val intent = Intent(this , PostJobActivity::class.java)
            startActivity(intent)
        }



        TvSignUp.setOnClickListener{
            val intent = Intent(this , RecruiterSignUp::class.java)
            startActivity(intent)
        }


        initViewModel()
        signInBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Login()
            }

        }
    }

    private suspend fun Login() {
        val user  = NewRecruiterLogin( EtEmail.text.toString(), EtPassword.text.toString())
        viewModel.RecruiterSignIn(user)

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(RecruiterSignInViewModel::class.java)
        viewModel.getCreateNewUserObserver().observe(this, Observer <NewRecruiterLogin?>{

            if(it  == null) {
                Toast.makeText(this, "Failed to create User", Toast.LENGTH_LONG).show()
            } else {
                //{"code":201,"meta":null,"data":{"id":2877,"name":"xxxxxaaaaabbbbb","email":"xxxxxaaaaabbbbb@gmail.com","gender":"male","status":"active"}}
                Toast.makeText(this, "Successfully created User", Toast.LENGTH_LONG).show()

            }
        })
    }
}
