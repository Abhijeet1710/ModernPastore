package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.common

import android.content.Context
import android.widget.Toast

class Common {
    companion object {
        var MODE : String = "LIGHT"
    }

    fun toast(context: Context, msg : String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    fun validateIp(title: String, password: String, rePassword: String) : Boolean {
        if(title.isNotEmpty() && password.isNotEmpty() && password == rePassword)
            return true
        return false
    }

}