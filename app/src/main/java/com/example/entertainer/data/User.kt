package com.example.entertainer.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.entertainer.model.MovieCategories

/* Entity for USERS: The primary key is User ID. Password is NOT ENCRYPTED */
@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val username: String,
    val name: String,
    val surname: String,
    val email: String,
    val password: String,
    val favourite: MovieCategories,
    val isAdmin: Boolean
)
