package com.moduloTech.smarthome.data.model.api.response


data class ApiResponse(
        val devices: List<ApiDevices>,
        val user: ApiUser
)