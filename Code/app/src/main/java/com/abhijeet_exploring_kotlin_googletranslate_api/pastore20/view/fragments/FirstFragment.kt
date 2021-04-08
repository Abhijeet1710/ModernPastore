package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.R
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.view.adapter.AllAccountsAdapter
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.view_model.MainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FirstFragment : Fragment() {

    private lateinit var fabAddAccount : FloatingActionButton
    private lateinit var accountsRecyclerView: RecyclerView
    lateinit var adapter : AllAccountsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        init(view);
        functionality(view);
        return view
    }

    private fun init(view: View) {
        fabAddAccount = view.findViewById(R.id.fabAddAccount)
        accountsRecyclerView = view.findViewById(R.id.rvAllAccounts)

    }

    private fun functionality(view: View) {
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setUpRecyclerView(view)

        viewModel.readAll.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })

        fabAddAccount.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment)
        }

    }

    private fun setUpRecyclerView(view: View) {
        val layoutManager = LinearLayoutManager(activity)
        adapter = AllAccountsAdapter(view)
        accountsRecyclerView.layoutManager = layoutManager
        accountsRecyclerView.setHasFixedSize(true)
        accountsRecyclerView.adapter = adapter
    }



}