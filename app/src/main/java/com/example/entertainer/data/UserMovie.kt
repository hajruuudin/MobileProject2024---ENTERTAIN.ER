package com.example.entertainer.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.entertainer.data.Movie
import com.example.entertainer.data.User
import com.example.entertainer.model.MovieCategories

/* Entity for USER MOVIES: This on is a middle table used to determine a users watchlist, statistics and watched movies */
/* Should not objects of this type as it is only used as an intermediate table! */
/* Foreign keys: Movie ID and User ID */
@Entity(
    tableName = "UserMovie",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Movie::class,
            parentColumns = ["id"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class UserMovie(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: Int,
    val movieId: Int,
    val watched: Boolean = false,
    val watchlist: Boolean = false
)