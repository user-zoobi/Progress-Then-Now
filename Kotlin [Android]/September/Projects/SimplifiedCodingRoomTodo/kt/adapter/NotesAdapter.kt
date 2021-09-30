package com.example.retrofitclient.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitclient.R
import com.example.retrofitclient.db.Note
import kotlinx.android.synthetic.main.note_layout.view.*

class NotesAdapter(val note:List<Note>): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_layout, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val data = note[position]
        holder.itemView.apply {
            TV_Note.text = data.note
            TV_Title.text = data.title
        }
    }

    override fun getItemCount(): Int {
        return note.size
    }
}