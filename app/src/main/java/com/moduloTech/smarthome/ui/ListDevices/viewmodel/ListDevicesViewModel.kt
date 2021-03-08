package com.moduloTech.smarthome.ui.ListDevices.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.data.repository.DeviceRespository


class ListDevicesViewModel @ViewModelInject constructor(
    private var repository: DeviceRespository
) : ViewModel() {

    private val typeDevice = MutableLiveData<String>()
    val devices = repository.getDevices()

    val devicesByType = Transformations.switchMap(typeDevice) { type ->
        repository.getAllDevicesByType(type)
    }

    fun startFilterDevice(type: String) {
        typeDevice.value = type
    }

    fun deleteDevice(device: Device) {
        repository.deleteDevice(device)

    }

}