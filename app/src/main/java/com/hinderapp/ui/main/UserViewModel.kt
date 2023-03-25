package com.hinderapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hinderapp.HinderApp
import com.hinderapp.data.Repositories
import com.hinderapp.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    val user: LiveData<User> by lazy {
        Repositories.userRepository.getUser()
    }

    fun addUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        Repositories.userRepository.insert(user)
    }

    fun updateUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        Repositories.userRepository.update(user)
    }

    fun clear() = viewModelScope.launch(Dispatchers.IO) {
        HinderApp.database.clearAllTables()
    }
}