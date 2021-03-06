package com.moduloTech.smarthome.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.moduloTech.smarthome.data.model.ApiResponse

@Dao
interface Dao {

    @Query("SELECT * FROM device")
    fun getAllDevices() : LiveData<List<ApiResponse>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDevices(characters: List<ApiResponse>)


}