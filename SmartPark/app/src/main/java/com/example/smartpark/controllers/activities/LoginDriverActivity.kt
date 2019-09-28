package com.example.smartpark.controllers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.smartpark.R

class LoginDriverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val register=findViewById<TextView>(R.id.txtRegister)
        register.setOnClickListener{
            startActivity(Intent(this,SignUpActivity::class.java))
        }
        val inputEmail=findViewById<TextView>(R.id.inputEmail)
        inputEmail.requestFocus()
    }
}
