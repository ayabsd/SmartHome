package com.moduloTech.smarthome.ui.ListDevices

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.moduloTech.smarthome.data.repository.DeviceRespository


class ListDevicesViewModel @ViewModelInject constructor(
    repository: DeviceRespository
) : ViewModel() {

    val devices = repository.getDevices()
}