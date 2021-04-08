package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.repository

import androidx.lifecycle.LiveData
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.model.OneAccount
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.model.AccountDao

class AccountRepository(private val accountDao: AccountDao) {

    val readAll : LiveData<List<OneAccount>> = accountDao.readAllData()

    suspend fun addAccount(oneAccount: OneAccount){
        accountDao.addAccount(oneAccount)
    }
    suspend fun updateAccount(oneAccount: OneAccount){
        accountDao.updateAccount(oneAccount)
    }
    suspend fun deleteAccount(oneAccount: OneAccount){
        accountDao.deleteAccount(oneAccount)
    }
//    fun getAccount(id : Int) : OneAccount = accountDao.getAccount(id)

}