package com.example.mywallet

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(InOutLog::class),version = 1)
abstract class InOutLogDatabase : RoomDatabase() {
    abstract var inOutLogDao: InOutLogDao
    companion object {
        @Volatile
        private var INSTANCE: InOutLogDatabase? = null

        fun getDatabase(context: Context): InOutLogDatabase{
            var tempDB = INSTANCE
            if(tempDB != null){
                tempDB = INSTANCE
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InOutLogDatabase::class.java,
                    "inoutlog_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}