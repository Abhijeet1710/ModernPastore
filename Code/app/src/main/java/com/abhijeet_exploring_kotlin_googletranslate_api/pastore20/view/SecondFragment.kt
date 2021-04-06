package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.R
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.common.Common
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.model.OneAccount
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.view_model.MainViewModel


class SecondFragment : Fragment() {

    lateinit var btnAdd : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_second, container, false)

        init(view);
        functionality(view);

        return view
    }

    private fun init(view: View) {

        btnAdd = view.findViewById(R.id.btnAddAccount)

    }

    private fun functionality(view: View) {

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        btnAdd.setOnClickListener {

            val title = view.findViewById<EditText>(R.id.etTitle).text.toString()
            val password = view.findViewById<EditText>(R.id.etPassword).text.toString()
            val oneAccount = OneAccount(siteName = title, sitePassword = password)
            viewModel.addAccount(oneAccount)
            Toast.makeText(activity, "Added Successfully", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_firstFragment)

        }



    }



}