package com.hinderapp.data.repository

import androidx.lifecycle.LiveData
import com.hinderapp.data.model.User

interface UserRepository {

    fun getUser(): LiveData<User>

    suspend fun insert(user: User)

    suspend fun update(user: User)

    suspend fun delete(user: User)
}