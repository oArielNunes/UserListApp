package com.example.userlistapp.data.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userlistapp.R

//Essa camada representa o ADAPTER  //
//Atua como uma ponte entre a View (RecyclerView) e os dados (List<User>)
// Seu trabalho é pegar os dados fornecidos pelo ViewModel (via Fragment)
// e preencher os views do layout. Não é estritamente parte do MVVM, mas é um componente key para a View.
//data class que representa o modelo de dados da aplicação (MODEL) //

// Modelo de dados do Usuário
data class User(val name: String, val email: String)

// Adapter do RecyclerView
class UserAdapter(private var userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    // ViewHolder que representa cada item da lista // serve apenas para guardar as referencias //
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.userName)  // Referências para as views
        val emailTextView: TextView = itemView.findViewById(R.id.userEmail)
    }

    // Metodo que infla o layout de cada item da lista e cria o ViewHolder // como deve ser o modelo //
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(itemView)
    }

    // Preenche os dados do ViewHolder com as informações do usuário // com quais dados vou preencher o modelo? //
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.nameTextView.text = user.name  // Preenche o nome
        holder.emailTextView.text = user.email  // Preenche o e-mail
    }

    // Retorna o tamanho da lista para o RecyclerView
    override fun getItemCount(): Int {
        return userList.size
    }

    // Função para atualizar a lista de usuários no Adapter
    fun updateUsers(newUsers: List<User>) {
        userList = newUsers  // Atualiza a lista interna de usuários
        notifyDataSetChanged()  // Notifica o RecyclerView para atualizar os dados
    }
}
