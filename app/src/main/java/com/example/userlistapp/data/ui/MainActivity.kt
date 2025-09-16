package com.example.userlistapp.data.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.userlistapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //carregando o Fragment //
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,UserListFragment())  //metodo replace substituirá o layout de Activity pela UI de Fragment
            .commit() //resposável por finalizar a transação e aplicar as mudanças
    }
}


//Essa camada é referente à VIEW (Container) //