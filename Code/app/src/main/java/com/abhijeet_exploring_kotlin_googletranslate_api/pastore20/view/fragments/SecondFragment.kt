package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.view.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.R
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.model.OneAccount
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.view_model.MainViewModel
import java.lang.Thread.sleep


class SecondFragment : Fragment() {

    lateinit var btnAdd : Button
    lateinit var doneBack : ConstraintLayout
    lateinit var done : ImageView
    lateinit var msg : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_second, container, false)
        init(view);
        functionality(view);
        return view
    }

    private fun init(view: View) {
        btnAdd = view.findViewById(R.id.btnAddAccount)
        doneBack = view.findViewById(R.id.clDoneBack)
        done = view.findViewById(R.id.ivDone)
//        msg = view.findViewById(R.id.tvMsg)

    }

    private fun functionality(view: View) {
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        btnAdd.setOnClickListener {
            val title = view.findViewById<EditText>(R.id.etTitle).text.toString().trim()
            val password = view.findViewById<EditText>(R.id.etPassword).text.toString().trim()
            val rePassword = view.findViewById<EditText>(R.id.etRePassword).text.toString().trim()

            if(validateIp(title, password, rePassword)){
                try {
                    val oneAccount = OneAccount(siteName = title, sitePassword = password)
                    viewModel.addAccount(oneAccount)
//                    GlobalScope.launch { animateDone("Added Successfully") }
                    closeKeyboard()
                    Toast.makeText(activity, "Added Successfully", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_firstFragment)

                }catch (e : Exception){
                    Toast.makeText(activity, "$e", Toast.LENGTH_SHORT).show()
//                    animateNotDone("Internal Error")
                }

            }else{
//                animateNotDone("Invalid Input")
                Toast.makeText(activity, "Invalid Input", Toast.LENGTH_SHORT).show()
            }


        }

    }

    private fun closeKeyboard() {
        val imm = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }

    private fun animateDone(msg: String) {
        doneBack.visibility = View.VISIBLE
        doneBack.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.fragment_fade_enter))
        sleep(100)
        done.visibility = View.VISIBLE
        done.setImageResource(R.drawable.ic_done)
        done.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.fragment_fade_enter))
        sleep(700)
        doneBack.visibility = View.GONE
        done.visibility = View.GONE
    }

    private fun animateNotDone(msg : String) {
        doneBack.visibility = View.VISIBLE
        doneBack.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.fragment_fade_enter))
        sleep(100)
        done.visibility = View.VISIBLE
        done.setImageResource(R.drawable.ic_fail)
        done.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.fragment_fade_enter))
        sleep(700)
        doneBack.visibility = View.GONE
        done.visibility = View.GONE

    }

    private fun validateIp(title: String, password: String, rePassword: String) : Boolean {
        if(title.isNotEmpty() && password.isNotEmpty() && password == rePassword)
            return true
        return false
    }


}