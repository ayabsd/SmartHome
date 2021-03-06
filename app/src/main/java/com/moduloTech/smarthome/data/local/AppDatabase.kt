package com.moduloTech.smarthome.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.moduloTech.smarthome.data.model.Adress
import com.moduloTech.smarthome.data.model.User
import com.moduloTech.smarthome.data.model.api.response.ApiDevices

@Database(entities = [ApiDevices::class, User::class, Adress::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun deviceDao(): Dao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
                instance ?: synchronized(this) {
                    instance
                            ?: buildDatabase(context).also {
                                instance = it
                            }
                }

        private fun buildDatabase(appContext: Context) =
                Room.databaseBuilder(appContext, AppDatabase::class.java, "smart_home").allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
    }

}