package com.example.retrofitclient.ui

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.retrofitclient.R
import com.example.retrofitclient.db.Note
import com.example.retrofitclient.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch

class AddNoteFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        save_button.setOnClickListener {

            val noteTitle = et_Title.text.toString()
            val noteBody = et_Note.text.toString()

            if (noteTitle.isEmpty()){
                et_Note.error = "note require"
                et_Note.requestFocus()
                return@setOnClickListener
            }

            if (noteBody.isEmpty()){
                et_Title.error = "note require"
                et_Title.requestFocus()
                return@setOnClickListener
            }

            launch {
                val noteClass = Note(noteTitle,noteBody)
               context?.let {
                   NoteDatabase(it).noteDao().insert(noteClass)
                    it.toast("Note Saved")
               }
            }

        }
    }

}