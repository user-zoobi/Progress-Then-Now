package com.example.retrofitclient.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(note: Note)

    @Query("SELECT * FROM NoteTable ORDER BY id DESC")
    suspend fun getNotes():List<Note>

    @Insert
    fun addMultipleNotes(vararg note: Note)
}