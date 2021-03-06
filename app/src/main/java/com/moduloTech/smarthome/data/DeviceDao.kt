package com.moduloTech.smarthome.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.moduloTech.smarthome.data.model.ApiDevices

@Dao
interface Dao {
    @Query("SELECT * FROM device")
    fun getAllDevices() : LiveData<List<ApiDevices>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDevices(devices: List<ApiDevices>)


}