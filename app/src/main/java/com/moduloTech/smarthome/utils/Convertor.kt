@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.moduloTech.smarthome.utils

import androidx.room.TypeConverter
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.data.model.api.response.ApiDevices
import java.text.SimpleDateFormat

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
@TypeConverter
fun convertdateNumberToDate(dateNumber: Long?): String {
    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    return simpleDateFormat.format(dateNumber)
}
@TypeConverter
fun convertDateToLong(date: String?): Long {
    val df = SimpleDateFormat("dd/MM/yyyy")
    return df.parse(date).time
}


