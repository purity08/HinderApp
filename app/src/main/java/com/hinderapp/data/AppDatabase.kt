package com.hinderapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hinderapp.data.dao.UserDao
import com.hinderapp.data.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        const val DB_NAME = "HINDER_DB"
    }

    abstract fun userDao(): UserDao
}