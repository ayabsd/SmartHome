package com.moduloTech.smarthome.data.service

import com.moduloTech.smarthome.data.model.api.response.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("data.json")
    suspend fun getDevices(): Response<ApiResponse>

}