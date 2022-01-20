package com.example.squarboatassignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import com.example.squarboatassignment.R
import com.example.squarboatassignment.ui.CandidateUi.LoginActivity
import com.example.squarboatassignment.ui.RecruiterUi.RecruiterLoginActivity
import kotlinx.android.synthetic.main.activity_chose_one.*

class ChoseOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chose_one)


        buTestUpdateText2.setOnClickListener{
            val intent = Intent(this , RecruiterLoginActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener{
            val intent = Intent(this , LoginActivity::class.java)
            startActivity(intent)
        }

    }
}


