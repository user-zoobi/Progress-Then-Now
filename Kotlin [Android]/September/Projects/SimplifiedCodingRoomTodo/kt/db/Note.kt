package com.example.retrofitclient.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NoteTable")
data class Note(

    @ColumnInfo(name = "noteTitle")
    var title: String,

    @ColumnInfo(name = "noteDescription")
    var note: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}