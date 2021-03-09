package com.moduloTech.smarthome.ui.DetailsDevice.light

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.moduloTech.smarthome.data.repository.DeviceRespository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DetailsDeviceLightViewModel @ViewModelInject constructor(
        private var repository: DeviceRespository
) : ViewModel() {

    fun updateDeviceLight(id: Int, intensity: Double, mode: String) {
        GlobalScope.launch {
            repository.updateDeviceLight(id, intensity, mode)
        }

    }
}