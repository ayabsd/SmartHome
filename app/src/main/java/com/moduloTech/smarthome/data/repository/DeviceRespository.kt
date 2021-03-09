package com.moduloTech.smarthome.data.repository

import com.moduloTech.smarthome.data.Dao
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.data.remote.RemoteDataSource
import com.moduloTech.smarthome.utils.performGetOperation
import com.moduloTech.smarthome.utils.performLocalOperation
import javax.inject.Inject

class DeviceRespository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: Dao

) {

    fun getDevices() = when (localDataSource.getAllDevices().isNullOrEmpty()) {
        true -> getDevicesFromServer()
        else -> getDevicesFromLocal()
    }

    fun getDevicesFromServer() = performGetOperation(
        databaseQuery = { localDataSource.getAlldevicesOrderedByType() },
        networkCall = { remoteDataSource.getAllDevices() },
        saveCallResult = { localDataSource.insertAllDevices(it.devices) }
    )

    fun getDevicesFromLocal() = performLocalOperation(
        databaseQuery = { localDataSource.getAlldevicesOrderedByType() }
    )

    fun deleteDevice(device: Device) {
        localDataSource.deleteById(device.id)
    }

    fun updateDeviceLight(id: Int, intensity: Double, state: String) {
        localDataSource.update(intensity, id = id , state = state )
    }

}