package com.moduloTech.smarthome.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.moduloTech.smarthome.data.model.Adress
import com.moduloTech.smarthome.data.model.api.response.ApiDevices
import com.moduloTech.smarthome.data.model.User

@Dao
interface Dao {
    @Query("SELECT * FROM device")
    fun getAllDevices(): List<ApiDevices>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDevices(devices: List<ApiDevices>)

    @Insert
    suspend fun insertUser(user: User)

    @Insert
    suspend fun insertUserAdress(adress: Adress)

    @Query("SELECT * FROM device ORDER BY productType ASC")
    fun getAlldevicesOrderedByType(): LiveData<List<ApiDevices>>

    @Query("SELECT * FROM device WHERE productType = :type")
    fun getDevicesByType(type: String): LiveData<List<ApiDevices>>

    @Query("DELETE FROM device WHERE id = :id")
    fun deleteById(id: Int)

    @Query("UPDATE device SET intensity =:intensity, mode =:state WHERE id = :id")
    fun updateDeviceLight(intensity: Double, id: Int, state: String)

    @Query("UPDATE device SET temperature =:temperature, mode =:state WHERE id = :id")
    fun updateDeviceHeater(temperature: Double, id: Int, state: String)

    @Query("UPDATE device SET position =:position WHERE id = :id")
    fun updateDeviceRoller(position: Double, id: Int)

    @Query("DELETE  FROM device")
    fun deleteAll()

    @Delete
    fun deleteAll(evices: List<ApiDevices>)


}