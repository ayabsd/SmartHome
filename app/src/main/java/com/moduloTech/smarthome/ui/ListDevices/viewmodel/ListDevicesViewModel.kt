package com.moduloTech.smarthome.ui.ListDevices.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.moduloTech.smarthome.data.model.ApiDevices
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.data.repository.DeviceRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ListDevicesViewModel @ViewModelInject constructor(
    var repository: DeviceRespository
) : ViewModel() {

    val typeDevice = MutableLiveData<String>()
    val devices = repository.getDevices()

    val devicesByType = Transformations.switchMap(typeDevice) { type ->
        repository.getAllDevicesByType(type)
    }

    fun startFilterDevice(type: String) {
        typeDevice.value = type
    }

    fun deleteDevice(device: Device) {

        GlobalScope.launch(Dispatchers.IO) {
            repository.deleteDevice(device)

        }



    }

}