package com.example.userlistapp.data.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userlistapp.R
import com.example.userlistapp.data.api.RetrofitClient
import com.example.userlistapp.data.repository.UserRepository


//Essa camada é referente à VIEW (UI)
// infla o layout XML / configura os componentes visuais RecyclerView//
// observa os dados expostos pelo ViewModel reagindo às mudanças //


class UserListFragment : Fragment() {  //é necessário que a classe herde de Fragment// A classe irá ser responsável por inflar o layout e exibir  a lista de usuários. //


    private lateinit var userViewModel : UserViewModel
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter: UserAdapter

    override fun onCreateView( //metodo obrigatorio para inflar o layout do fragment// metodo exclusivo de fragments//
        inflater: LayoutInflater, //inflater é responsável por converter o arquivo XML em um objeto de interface visual.
        container: ViewGroup?, //container remete à activity onde ele será inserido // O terceiro parametro "false" impede que o layout seja adicionado diretamente ao container//
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_list, container, false) //definimos que o layout inflado  será o XML fragment_user_list//

        //"Econtrando" o RecyclerView
        recyclerView = view.findViewById(R.id.recycleViewUsers)
        recyclerView.layoutManager = LinearLayoutManager(context) //definir o layoutManager como LinearLayout para que os itens do RecyclerView sejam organizados em uma lista vertical


        adapter = UserAdapter(listOf()) //inicializa o adapter com uma lista vazia
        recyclerView.adapter = adapter

        //Cria o repositório e o ViewModel com ViewModelFactory
        val userRepository = UserRepository(RetrofitClient.apiService)
        val factory = UserViewModelFactory(userRepository)
        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)


        userViewModel.userList.observe(viewLifecycleOwner,{ users ->
            adapter.updateUsers(users)
        })

        userViewModel.errorMessage.observe(viewLifecycleOwner, { error ->
            Toast.makeText(context,"Erro: $error", Toast.LENGTH_SHORT).show()
        })


        userViewModel.fetchUsers() //chamada da função de busca dos usuários



        return view
    }
}