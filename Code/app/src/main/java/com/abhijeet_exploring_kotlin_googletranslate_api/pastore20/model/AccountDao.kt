package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AccountDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAccount(oneAccount: OneAccount)

    @Query("SELECT * FROM accounts_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<OneAccount>>

}