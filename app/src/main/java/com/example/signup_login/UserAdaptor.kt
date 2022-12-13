package com.example.signup_login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdaptor (val ListUser:List<User>?):RecyclerView.Adapter<UserAdaptor.ViewHolder>(){
    inner class ViewHolder(item:View):RecyclerView.ViewHolder(item){
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.users_item,parent,false)
        return ViewHolder(item)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            val tvName:TextView? = findViewById(R.id.tvName)
            val tvEmail:TextView? = findViewById(R.id.tvEmail)
            val tvGender:TextView? = findViewById(R.id.tvRole)

            tvName?.text = ListUser?.get(position)?.name.toString()
            tvEmail?.text = ListUser?.get(position)?.email.toString()
            tvGender?.text = ListUser?.get(position)?.role.toString()
        }
    }
    override fun getItemCount(): Int {
        return ListUser!!.size
    }

}