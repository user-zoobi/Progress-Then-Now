package com.example.retrofitclient.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.retrofitclient.R
import com.example.retrofitclient.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerview_notes.setHasFixedSize(true)
        recyclerview_notes.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        launch {
            context?.let {
                val notesAdapter = NoteDatabase(it).noteDao().getNotes()
                recyclerview_notes.adapter = NotesAdapter(notesAdapter)
            }
        }

        add_button.setOnClickListener {
            val addNote = AddNoteFragment()
            requireFragmentManager().beginTransaction().apply {
                replace(R.id.fragment, addNote).addToBackStack(null).commit()
            }
        }
    }
}