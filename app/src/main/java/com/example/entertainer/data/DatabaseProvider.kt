package com.example.entertainer.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

object DatabaseProvider {
    private var db: AppDatabase? = null

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

private class DatabaseProviderCallback : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        // Enable foreign key constraints
        db.execSQL("PRAGMA foreign_keys=ON;")
    }
}