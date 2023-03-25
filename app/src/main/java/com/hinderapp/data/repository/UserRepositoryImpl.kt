package com.hinderapp.data.repository

import androidx.lifecycle.LiveData
import com.hinderapp.HinderApp
import com.hinderapp.data.AppDatabase
import com.hinderapp.data.model.User
import kotlinx.coroutines.coroutineScope

class UserRepositoryImpl: UserRepository {

    private val database: AppDatabase by lazy {
        HinderApp.database
    }

    override fun getUser(): LiveData<User> = database.userDao().getUser()

    override suspend fun insert(user: User) = coroutineScope {
        database.userDao().insert(user)
    }

    override suspend fun update(user: User) = coroutineScope {
        database.userDao().update(user)
    }

    override suspend fun delete(user: User) = coroutineScope {
        database.userDao().delete(user)
    }

}