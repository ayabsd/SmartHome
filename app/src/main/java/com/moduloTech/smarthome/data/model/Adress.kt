package com.moduloTech.smarthome.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "adresse")
data class Adress(
        val city: String,
        val street: String,
        val streetCode: String,
        val postalCode: String,
        val country: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0

}

