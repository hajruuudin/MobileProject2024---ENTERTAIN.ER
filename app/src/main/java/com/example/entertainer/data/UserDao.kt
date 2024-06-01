package com.example.entertainer.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.entertainer.data.User
import kotlinx.coroutines.flow.Flow

/* Database Access Object for USERS */
@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Update
    suspend fun update(user: User)

    /**
     * Retrieves the specified user by their ID. Used to open the profile page.
     *
     * @param id The ID of the user to be retrieved.
     * @return The user with the specified ID.
     */
    @Query("SELECT * FROM User WHERE id = :id")
    suspend fun getUser(id: Int) : User
}