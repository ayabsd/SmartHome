package com.moduloTech.smarthome.data.model

sealed class Device {
    abstract val id: String
    abstract val name: String

    data class Light(
        override val id: String,
        override val name: String,
        val intensity: String,
        val mode: String
    ) : Device()

    data class Heater(
        override val id: String,
        override val name: String,
        val mode: String,
        val temperature: String
    ) : Device()

    data class RollerShutter(
        override val id: String,
        override val name: String,
        val position: String
    ) : Device()
}