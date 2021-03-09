package com.moduloTech.smarthome.ui.DetailsDevice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.moduloTech.smarthome.R

class DetailsDeviceHeaterFragment : Fragment() {

    private lateinit var viewModel: DetailsDeviceHeaterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_device_heater_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsDeviceHeaterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}