package com.moduloTech.smarthome.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.moduloTech.smarthome.data.model.ApiDevices
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

fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(t: T?) {
            observer.onChanged(t)
            removeObserver(this)
        }
    })
}