package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.R
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.model.OneAccount


class AllAccountsAdapter(val view : View, private val listner : OnItemClicked) : RecyclerView.Adapter<AllAccountsAdapter.AllAccountsViewHolder>() {

    private var allAccountsList = emptyList<OneAccount>()

    inner class AllAccountsViewHolder(private val itemView : View) : RecyclerView.ViewHolder(itemView) {
        var id: TextView = itemView.findViewById(R.id.tvId)
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val password: TextView = itemView.findViewById(R.id.tvPassword)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
        val currItem: ConstraintLayout = itemView.findViewById(R.id.clCurrentItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllAccountsViewHolder {
        return AllAccountsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.account_row, parent, false))
    }

    override fun onBindViewHolder(holder: AllAccountsViewHolder, position: Int) {
        val id = allAccountsList[position].id
        val title = allAccountsList[position].siteName
        val pass =  allAccountsList[position].sitePassword
        val desc =  allAccountsList[position].siteDescription

        holder.id.text = id.toString()
        holder.title.text = title
        holder.password.text = pass
        holder.password.text = desc

        holder.currItem.setOnClickListener {
            listner.onItemClickedEvent(view, allAccountsList[position])
        }
    }

    override fun getItemCount(): Int = allAccountsList.size

    fun setData(list: List<OneAccount>) {
        allAccountsList = list
        notifyDataSetChanged()
    }

}


interface OnItemClicked {
    fun onItemClickedEvent(view : View, oneAccount: OneAccount)
}