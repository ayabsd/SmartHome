package com.moduloTech.smarthome.ui.DetailsDevice

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moduloTech.smarthome.R

class DetailsDeviceHeaterFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsDeviceHeaterFragment()
    }

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