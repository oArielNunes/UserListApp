package com.example.userlistapp.data.repository

import com.example.userlistapp.data.ui.User
import com.example.userlistapp.data.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val apiService: ApiService) {

    // função para buscar os usuários da API
    fun getUsersFromApi(callback: (List<User>?, String?) -> Unit) { //passa os dados ou erros para o ViewModel através de callbacks
        apiService.getUsers().enqueue(object : Callback<List<User>> {
            override  fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    callback(response.body(), null)
                } else {
                    callback(null,"Erro ao buscar dados da API")
                }
            }

            override fun onFailure(call: Call<List<User>?>, t: Throwable) {
                callback(null, t.message)
            }
        })
    }
}