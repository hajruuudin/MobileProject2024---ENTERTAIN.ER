package com.example.entertainer.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [User::class, Movie::class, UserMovie::class],
    version = 10
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun movieDao() : MovieDao
    abstract fun userMovieDao() : UserMovieDao
}