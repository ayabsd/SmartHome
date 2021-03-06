package com.moduloTech.smarthome.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "device")
data class ApiDevices (
    @PrimaryKey
    val id: Int,
    val deviceName: String,
    val productType: String?,
    val intensity: String?,
    val mode: String?,
    val position: String?,
    val temperature: String?)
