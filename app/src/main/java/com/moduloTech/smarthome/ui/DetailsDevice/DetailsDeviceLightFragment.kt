package com.moduloTech.smarthome.ui.DetailsDevice

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moduloTech.smarthome.R

class DetailsDeviceLightFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsDeviceLightFragment()
    }

    private lateinit var viewModel: DetailsDeviceLightViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_device_light_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsDeviceLightViewModel::class.java)
        // TODO: Use the ViewModel
    }

}