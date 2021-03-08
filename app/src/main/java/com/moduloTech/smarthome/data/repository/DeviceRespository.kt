package com.moduloTech.smarthome.data.repository

import androidx.lifecycle.LiveData
import com.moduloTech.smarthome.data.Dao
import com.moduloTech.smarthome.data.model.ApiDevices
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.data.remote.RemoteDataSource
import com.moduloTech.smarthome.utils.performGetOperation
import javax.inject.Inject

class DeviceRespository @Inject constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: Dao

) {

    fun getDevices() = performGetOperation(
            databaseQuery = { localDataSource.getAlldevicesOrderedByType() },
            networkCall = { remoteDataSource.getAllDevices() },
            saveCallResult = { localDataSource.insertAllDevices(it.devices) }
    )


    fun deleteDevice(device: Device){
       localDataSource.deleteById(device.id)
    }
}