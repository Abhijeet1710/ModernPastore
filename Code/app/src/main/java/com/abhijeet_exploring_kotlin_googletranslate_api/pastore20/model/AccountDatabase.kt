package com.abhijeet_exploring_kotlin_googletranslate_api.pastore20.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [OneAccount::class], version = 2, exportSchema = false)
abstract class AccountDatabase : RoomDatabase() {

     abstract fun accountDao() : AccountDao

    companion object {
        private var INSTANCE : AccountDatabase? = null

        fun getDatabase(context: Context) : AccountDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AccountDatabase::class.java,
                        "accounts_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}