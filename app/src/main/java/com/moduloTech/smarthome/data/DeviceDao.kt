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
    fun getAllDevices(): List<ApiDevices>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDevices(devices: List<ApiDevices>)

    @Query("SELECT * FROM device ORDER BY productType ASC")
    fun getAlldevicesOrderedByType(): LiveData<List<ApiDevices>>

    @Query("SELECT * FROM device WHERE productType = :type")
    fun getDevicesByType(type: String): LiveData<List<ApiDevices>>

    @Query("DELETE FROM device WHERE id = :id")
     fun deleteById(id: Int)

    @Query("UPDATE device SET intensity =:intensity, mode =:state WHERE id = :id")
    fun update(intensity: Double, id: Int , state : String)

}