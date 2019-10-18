package com.example.smartpark.controllers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.smartpark.R
import com.example.smartpark.databinding.ActivityMapDriverBinding

class MapActivityDriver : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val binding=DataBindingUtil.setContentView<ActivityMapDriverBinding>(this, R.layout.activity_map_driver)
            drawerLayout=binding.drawerLayoutCore
            val navController=this.findNavController(R.id.navHostFragmentCore)
            NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController=this.findNavController(R.id.navHostFragmentCore)
        return NavigationUI.navigateUp(navController,drawerLayout)
    }
}
