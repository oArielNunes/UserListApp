package com.example.userlistapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel (private val userRepository: UserRepository) : ViewModel(){

    private val _userList = MutableLiveData<List<User>>() //Dados do usuário
    val userList: LiveData<List<User>> get() = _userList

    private val _errorMessage = MutableLiveData<String?>() // Mesnagem de erro//
    val errorMessage: LiveData<String> get() = _errorMessage as LiveData<String>

    //Função que busca os usuários //
    fun fetchUsers(){
        userRepository.getUsersFromApi { users, error ->
            if (users != null) {
                _userList.postValue(users)
            } else {
                _errorMessage.postValue(error)
            }
        }
    }
}