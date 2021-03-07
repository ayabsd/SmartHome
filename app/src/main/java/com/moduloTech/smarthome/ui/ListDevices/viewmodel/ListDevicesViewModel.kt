package com.moduloTech.smarthome.ui.ListDevices.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.moduloTech.smarthome.data.model.ApiDevices
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.data.repository.DeviceRespository


class ListDevicesViewModel @ViewModelInject constructor(
    repository: DeviceRespository
) : ViewModel() {

    val devices = repository.getDevices()
    val devicesByType = repository.getDevices()



}