package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "accounts_table")
data class OneAccount(

        @PrimaryKey(autoGenerate = true) val id : Int = 0,
        val siteName : String,
        val siteUrl : String? = null,
        val siteIcon : String? = null,
        val sitePassword : String,
        val siteDescription : String? = null


)