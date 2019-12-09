package com.example.mywallet

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface InOutLogDao{
    @Insert
    suspend fun insertLog(inOutLog: InOutLog)

    @Query("SELECT * FROM in_out_log")
    suspend fun getLog(): LiveData<List<InOutLog>>
}