package com.example.userlistapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"  // URL base da API (substitua pela URL real da sua API)

    // Instância do Retrofit configurada
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)  // Define a URL base
            .addConverterFactory(GsonConverterFactory.create())  // Converte a resposta JSON para objetos Kotlin
            .build()
            .create(ApiService::class.java)  // Cria a interface ApiService para as requisições
    }
}


//Essa camada se refere à MODEL (Configuração dos dados)
//Configura o cliente (Retrofit) para acessar a fonte de dados remota (API)