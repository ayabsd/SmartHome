package com.moduloTech.smarthome.data.repository

import com.moduloTech.smarthome.data.Dao
import com.moduloTech.smarthome.data.remote.RemoteDataSource
import com.moduloTech.smarthome.utils.performGetOperation
import javax.inject.Inject

class DeviceRespository @Inject constructor(

    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: Dao

) {

    fun getDevices() = performGetOperation(
        databaseQuery = { localDataSource.getAllDevices() },
        networkCall = { remoteDataSource.getAllDevices() },
        saveCallResult = { localDataSource.insertAllDevices(it.devices) }
    )
}