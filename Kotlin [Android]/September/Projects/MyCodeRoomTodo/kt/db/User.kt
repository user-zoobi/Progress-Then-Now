package com.example.roomdb.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(

    @ColumnInfo(name = "userName")
    var name: String,
    @ColumnInfo(name = "userEmail")
    var email: String,
    @ColumnInfo(name = "userPassword")
    var password: String

){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}