package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.R

class AccountFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        return view
    }

}