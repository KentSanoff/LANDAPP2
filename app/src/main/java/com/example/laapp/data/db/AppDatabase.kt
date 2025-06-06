package com.kentsanoff.landapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LandField::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun landFieldDao(): LandFieldDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "landapp_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
