package com.moduloTech.smarthome.ui.DetailsDevice

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moduloTech.smarthome.R
import com.moduloTech.smarthome.data.model.Device
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsDeviceRollerFragment : Fragment() {
    private lateinit var viewModel: DetailsDeviceRollerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_device_roller_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsDeviceRollerViewModel::class.java)
        getDevice()
    }


    private fun getDevice() {
       // val device: Device? =
          //  DetailsDevicfromBundle(requireArguments()).argFromDeviceListFragment

    }

}