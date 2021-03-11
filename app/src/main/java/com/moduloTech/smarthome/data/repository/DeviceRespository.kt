package com.moduloTech.smarthome.data.repository

import com.moduloTech.smarthome.data.local.Dao
import com.moduloTech.smarthome.data.model.Adress
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.data.model.User
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

    private fun getDevicesFromServer() = performGetOperation(
        databaseQuery = { localDataSource.getAlldevicesOrderedByType() },
        networkCall = { remoteDataSource.getAllDevices() },
        saveCallResult = {
            localDataSource.insertAllDevices(it.devices)
            localDataSource.insertUser(User(it.user.firstName, it.user.lastName, it.user.birthDate))
            localDataSource.insertUserAdress(
                Adress(
                    it.user.address.city,
                    it.user.address.street,
                    it.user.address.streetCode,
                    it.user.address.postalCode,
                    it.user.address.country
                )
            )

        }


    )

    private fun getDevicesFromLocal() = performLocalOperation(
        databaseQuery = { localDataSource.getAlldevicesOrderedByType() }
    )

    fun deleteDevice(device: Device) {
        localDataSource.deleteById(device.id)
    }

    fun updateDeviceLight(id: Int, intensity: Double, state: String) {
        localDataSource.updateDeviceLight(intensity, id = id, state = state)
    }

    fun updateDeviceHeater(id: Int, temperature: Double, state: String) {
        localDataSource.updateDeviceHeater(temperature, id = id, state = state)
    }

    fun updateDeviceRoller(id: Int, position: Double) {
        localDataSource.updateDeviceRoller(position, id = id)
    }

    fun getUserFromLocal() = localDataSource.getUser()

    fun geAdressFromLocal() = localDataSource.getAdress()

    fun upateUser(user: User): Int {
        return localDataSource.updateUser(user)
    }

    fun upateAdress(adress: Adress): Int {
        return localDataSource.updateAdress(adress)
    }


}