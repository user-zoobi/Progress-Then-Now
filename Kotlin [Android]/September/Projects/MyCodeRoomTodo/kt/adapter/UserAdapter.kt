package com.example.roomdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb.R
import com.example.roomdb.db.User
import kotlinx.android.synthetic.main.user_viewholder_activity.view.*

class UserAdapter(val user:List<User>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_viewholder_activity, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val data = user[position]
        holder.itemView.apply {
            text_name.text = data.name
            text_email.text = data.email
            text_password.text = data.password
        }
    }

    override fun getItemCount(): Int {
        return user.size
    }
}