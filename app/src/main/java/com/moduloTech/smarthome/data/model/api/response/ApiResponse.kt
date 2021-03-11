package com.moduloTech.smarthome.data.model.api.response

import com.moduloTech.smarthome.data.model.User


data class ApiResponse(
        val devices: List<ApiDevices>,
        val user : ApiUser
)