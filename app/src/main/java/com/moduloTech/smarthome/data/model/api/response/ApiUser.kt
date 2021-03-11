package com.moduloTech.smarthome.data.model.api.response


data class ApiUser(
        val firstName: String,
        val lastName: String,
        val birthDate: String,
        var address :ApiAdress,

)