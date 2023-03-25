package com.hinderapp

import android.app.Application
import androidx.room.Room
import com.hinderapp.data.AppDatabase

class HinderApp: Application() {

    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, AppDatabase::class.java, AppDatabase.DB_NAME).build()
    }
}