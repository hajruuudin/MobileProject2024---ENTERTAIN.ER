package com.example.entertainer.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

object DatabaseProvider {
    private var db: AppDatabase? = null

    /* Creating the database instance */
    fun getDatabase(context: Context) : AppDatabase {
        if (db == null){
            db = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "movies_db"
            )
                .addCallback(DatabaseProviderCallback())
                .fallbackToDestructiveMigration()
                .build()
        }

        return db!!;
    }
}

/* Implementing foreign keys: NOT IN USE NOW! */
private class DatabaseProviderCallback : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        db.execSQL("PRAGMA foreign_keys=ON;")
    }
}