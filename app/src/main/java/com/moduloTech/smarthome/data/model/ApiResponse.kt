package com.moduloTech.smarthome.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "device")
data class ApiResponse (
    @PrimaryKey
    val id: String,
    val deviceName: String,
    val productType: String,
    val intensity: String,
    val mode: String,
    val position: String,
    val temperature: String)
