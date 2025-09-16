package com.example.userlistapp.data.api

import com.example.userlistapp.data.ui.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users") //Endpoint para pegar a lista de usuários //
    fun getUsers(): Call<List<User>>  // retorna a lista
}