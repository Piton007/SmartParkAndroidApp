package com.example.smartpark.controllers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.smartpark.R

class SelectUserActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_user)
        val btnDriver=findViewById<Button>(R.id.btnDriver)
        btnDriver.setOnClickListener{
            startActivity(Intent(this,
                LoginDriverActivity::class.java))
        }
        /*btnDriver.setOnClickListener{
            val intent= Intent(this,LoginDriverActivity::class.java)
            startActivity(intent)
        }*/
    }
}
