package com.moduloTech.smarthome.utils

import com.moduloTech.smarthome.data.model.api.response.ApiDevices
import com.moduloTech.smarthome.data.model.Device

fun convertResponse(devicesApi: List<ApiDevices>): List<Device> {
    return devicesApi.map {
        when (it.productType) {
            TYPE_LIGHT -> Device.Light(
                id = it.id,
                name = it.deviceName,
                intensity = it.intensity!!,
                mode = it.mode!!
            )

            TYPE_HEATER -> Device.Heater(
                id = it.id,
                name = it.deviceName,
                mode = it.mode!!,
                temperature = it.temperature!!
            )

            TYPE_ROLLER -> Device.RollerShutter(
                id = it.id,
                name = it.deviceName,
                position = it.position!!
            )
            else -> throw Exception()
        }
    }
}


