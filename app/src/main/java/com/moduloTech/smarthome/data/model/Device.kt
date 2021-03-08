package com.moduloTech.smarthome.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
sealed class Device : Parcelable {
    abstract val id: Int
    abstract val name: String

    @Parcelize  data class Light(
        override val id: Int,
        override val name: String,
        val intensity: String,
        val mode: String
    ) : Device(),Parcelable

    @Parcelize  data class Heater(
        override val id: Int,
        override val name: String,
        val mode: String,
        val temperature: String
    ) : Device() ,Parcelable

    @Parcelize  data class RollerShutter(
        override val id: Int,
        override val name: String,
        val position: String
    ) : Device(),Parcelable
}