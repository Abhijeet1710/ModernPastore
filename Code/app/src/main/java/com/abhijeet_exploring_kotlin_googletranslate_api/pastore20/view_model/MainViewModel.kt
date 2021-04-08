package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.model.OneAccount
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.model.AccountDatabase
import com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.repository.AccountRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val readAll : LiveData<List<OneAccount>>
    private val accountRepository : AccountRepository


    init {
        val accountDao = AccountDatabase.getDatabase(application).accountDao()
        accountRepository = AccountRepository(accountDao)
        readAll = accountRepository.readAll
    }

    fun addAccount(oneAccount: OneAccount){
        viewModelScope.launch {
            accountRepository.addAccount(oneAccount)
        }
    }
//    fun getAccount(id : Int) : OneAccount{
////        viewModelScope.launch {
//            return accountRepository.getAccount(id)
////        }
//    }
    fun updateAccount(oneAccount: OneAccount){
        viewModelScope.launch {
            accountRepository.updateAccount(oneAccount)
        }
    }
    fun deleteAccount(oneAccount: OneAccount){
        viewModelScope.launch {
            accountRepository.deleteAccount(oneAccount)
        }
    }



}