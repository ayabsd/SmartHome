package com.moduloTech.smarthome.data

import com.moduloTech.smarthome.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("data.json")
    suspend fun getDevices(): Response<ApiResponse>

}