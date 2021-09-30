package com.example.roomdb.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM users ORDER BY id DESC")
    suspend fun selectUsers(): List<User>
}