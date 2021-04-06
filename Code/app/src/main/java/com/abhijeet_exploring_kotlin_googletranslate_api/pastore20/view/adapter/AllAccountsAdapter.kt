package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.view.adapter

import android.accounts.Account
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.R
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.model.OneAccount


class AllAccountsAdapter : RecyclerView.Adapter<AllAccountsAdapter.AllAccountsViewHolder>() {

    private var allAccountsList = emptyList<OneAccount>()
    inner class AllAccountsViewHolder(private val itemView : View) : RecyclerView.ViewHolder(itemView) {
        var id: TextView = itemView.findViewById(R.id.tvId)
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val lastUpdateTime: TextView = itemView.findViewById(R.id.tvLastUpdateTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllAccountsViewHolder {
        return AllAccountsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.account_row, parent, false))
    }

    override fun onBindViewHolder(holder: AllAccountsViewHolder, position: Int) {
        val id = allAccountsList[position].id
        val title = allAccountsList[position].siteName
        val lastTime = "10 days Ago.."

        holder.id.text = id.toString()
        holder.title.text = title
        holder.lastUpdateTime.text = lastTime

    }

    override fun getItemCount(): Int = allAccountsList.size

    fun setData(list: List<OneAccount>) {
        allAccountsList = list
        notifyDataSetChanged()
    }

}