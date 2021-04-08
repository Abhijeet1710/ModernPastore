package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AccountDao {
    @Query("SELECT * FROM accounts_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<OneAccount>>

//    @Query("SELECT * FROM accounts_table WHERE id = :id1")
//    fun getAccount(id1 : Int) : OneAccount

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAccount(oneAccount: OneAccount)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateAccount(oneAccount: OneAccount)

    @Delete
    suspend fun deleteAccount(oneAccount: OneAccount)

}