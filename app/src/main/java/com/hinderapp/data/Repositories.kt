package com.hinderapp.data

import com.hinderapp.data.repository.UserRepository
import com.hinderapp.data.repository.UserRepositoryImpl

object Repositories {
    val userRepository: UserRepository by lazy {
        UserRepositoryImpl()
    }
}