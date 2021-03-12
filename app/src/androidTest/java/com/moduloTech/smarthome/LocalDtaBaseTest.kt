package com.moduloTech.smarthome

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.moduloTech.smarthome.data.local.AppDatabase
import com.moduloTech.smarthome.data.local.Dao
import com.moduloTech.smarthome.data.model.api.response.ApiDevices
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Aya Boussaadia on 12,March,2021
 */

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class LocalDtaBaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var database: AppDatabase
    private lateinit var dao: Dao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.deviceDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertDevice() = runBlockingTest {
        val device1 = ApiDevices(201, "Light", "50", "OFF", "0", "0", "0")
        val device2 = ApiDevices(202, "Heater", "50", "OFF", "0", "0", "0")
        val device3 = ApiDevices(203, "Light", "50", "OFF", "0", "0", "0")
        val devices = ArrayList<ApiDevices>()
        devices.add(device1)
        devices.add(device2)
        devices.add(device3)
        dao.insertAllDevices(devices)

    }


}
