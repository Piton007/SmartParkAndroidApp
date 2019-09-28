package com.example.smartpark.controllers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.smartpark.R
import com.example.smartpark.controllers.activities.network.SmartParkApi
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Driver

class LoginDriverActivity : AppCompatActivity() {
    private var username: String = ""
    private var password: String = ""
    private var usernamevalid: Boolean = false
    private var passwordvalid: Boolean = false
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

    override fun onResume() {
        super.onResume()
        login.setOnClickListener{
            username = inputEmail.text.toString()
            password = inputPassword.text.toString()

            username.apply {
                if(this.isBlank()){
                    usernamevalid = false
                }
                else{
                    usernamevalid = true
                }
            }
            password.apply {
                if(this.isBlank()){
                    passwordvalid = false
                }
                else{
                    passwordvalid = true
                }
            }

            if(passwordvalid and usernamevalid){
                var list: ArrayList<com.example.smartpark.controllers.activities.models.Driver>?
                SmartParkApi.getDrivers({
                    it?.forEach {
                        if(it.email.toString()== username){
                            if(it.dni.toString() == password){
                                val login = findViewById<Button>(R.id.login)
                                login.setOnClickListener { startActivity(Intent(this,MapActivityDriver::class.java)) }
                            }

                    }
                        else{
                        }
                    }
                },{
                    Log.d("NEARMETESTNewsApi", "${it.errorBody} ${it.localizedMessage}")
                }
                )
            }
        }
    }
}
