package com.example.userlistapp.data.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.userlistapp.data.repository.UserRepository

class UserViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Classe de ViewModel Desconhecida")
    }
}


//Essa camada se refere à VIEWMODEL (factory) //
//Cria as instancias da VIEWMODEL e injeta as dependencias (repostirtory)//