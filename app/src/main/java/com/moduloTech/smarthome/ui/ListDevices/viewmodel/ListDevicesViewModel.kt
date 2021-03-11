package com.moduloTech.smarthome.ui.ListDevices.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.data.repository.DeviceRespository


class ListDevicesViewModel @ViewModelInject constructor(
        private var repository: DeviceRespository
) : ViewModel() {

    var devices = repository.getDevices()

    fun deleteDevice(device: Device) {
        repository.deleteDevice(device)
    }


}


