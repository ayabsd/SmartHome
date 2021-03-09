package com.moduloTech.smarthome.ui.DetailsDevice.heater

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moduloTech.smarthome.data.repository.DeviceRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailsDeviceHeaterViewModel @ViewModelInject constructor(
        private var repository: DeviceRespository
) : ViewModel() {

    fun updateDeviceHeater(id: Int, temperature: Double, mode: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDeviceHeater(id, temperature, mode)
        }
    }
}