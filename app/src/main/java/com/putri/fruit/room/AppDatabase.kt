package com.putri.fruit.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// membuat class AppDatabase dengan menyertakan studentEntitiy dan fungsi abstract studentDao
@Database(entities = [StudentEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao() : StudentDao

    // deklarasi instance dari AppDatabase dengan nilai null
    // menghasilkan hasil instance sebagai AppDatabase
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "student_database")
                        .build()
                }
            }
            return INSTANCE as AppDatabase
        }
    }
}