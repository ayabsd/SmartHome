package com.moduloTech.smarthome.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
        val firstName: String,
        val lastName: String,
        val birthDate: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0

}