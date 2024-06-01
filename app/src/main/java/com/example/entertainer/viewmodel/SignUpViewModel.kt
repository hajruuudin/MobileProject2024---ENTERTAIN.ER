package com.example.entertainer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entertainer.data.User
import com.example.entertainer.data.UserDao
import kotlinx.coroutines.launch

class SignUpViewModel(
    val userDao: UserDao
) : ViewModel() {

    fun registerUser(user: User){
        viewModelScope.launch {
            userDao.insert(user)
        }
    }
}