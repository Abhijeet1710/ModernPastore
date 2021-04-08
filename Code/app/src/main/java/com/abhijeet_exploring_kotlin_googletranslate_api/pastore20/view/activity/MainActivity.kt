package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.R
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.common.Common
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) setTheme(R.style.Theme_Pastore20)

        binding.btnBulb.setOnClickListener {
            changeTheme()
        }

    }

    private fun changeTheme() {
        if(Common.MODE == "LIGHT"){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            Common.MODE = "DARK";
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            Common.MODE = "LIGHT";
        }
    }


}