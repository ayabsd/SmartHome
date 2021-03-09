package com.moduloTech.smarthome.ui.DetailsDevice.roller

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moduloTech.smarthome.data.repository.DeviceRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DetailsDeviceRollerViewModel @ViewModelInject constructor(
        private var repository: DeviceRespository
) : ViewModel() {


    fun updateDeviceRoller(id: Int, position: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDeviceRoller(id, position)
        }
    }
}
