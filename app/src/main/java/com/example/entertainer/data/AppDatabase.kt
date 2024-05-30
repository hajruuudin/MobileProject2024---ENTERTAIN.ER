package com.example.entertainer.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.entertainer.data.UserMovieDao

@Database(
    entities = [User::class, Movie::class, UserMovie::class],
    version = 7
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun movieDao() : MovieDao
    abstract fun userMovieDao() : UserMovieDao
}