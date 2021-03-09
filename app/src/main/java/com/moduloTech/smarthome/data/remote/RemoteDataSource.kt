package com.moduloTech.smarthome.data.remote

import com.moduloTech.smarthome.data.service.ApiService
import javax.inject.Inject


class RemoteDataSource @Inject constructor(
    private val service: ApiService
): BaseDataSource() {

    suspend fun getAllDevices() = getResult { service.getDevices() }


}