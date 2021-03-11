package com.moduloTech.smarthome.ui.DetailsDevice.heater

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.databinding.DetailsDeviceHeaterFragmentBinding
import com.moduloTech.smarthome.utils.OFF
import com.moduloTech.smarthome.utils.ON
import dagger.hilt.android.AndroidEntryPoint
import java.math.RoundingMode

@AndroidEntryPoint
class DetailsDeviceHeaterFragment : Fragment() {
    private lateinit var binding: DetailsDeviceHeaterFragmentBinding
    private lateinit var device: Device.Heater
    private val viewModel: DetailsDeviceHeaterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailsDeviceHeaterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDevice()
        initView()
    }

    private fun getDevice() {
        device =
            DetailsDeviceHeaterFragmentArgs.fromBundle(requireArguments()).argFromDeviceListFragment as Device.Heater

    }

    private fun initView() {
        if (device != null) {
            binding.switchHeater.isChecked = device.mode == ON
        }
        binding.deviceNameTv.text = device.name
        binding.deviceTemperature.value = device.temperature.toFloat()
        binding.deviceTemperatureTv.text = device.temperature.toFloat().toString()
        binding.deviceTemperature.addOnChangeListener { slider, value, fromUser ->
            binding.deviceTemperatureTv.text =
                value.toBigDecimal().setScale(1, RoundingMode.UP).toDouble().toString()
        }


    }

    override fun onPause() {
        onSaveChanges()
        super.onPause()
    }


    private fun onSaveChanges() {
        val stateSwitch = when (binding.switchHeater.isChecked) {
            true -> ON
            false -> OFF
        }
        val silderLightvalue = binding.deviceTemperature.value.toBigDecimal().toDouble()
        viewModel.updateDeviceHeater(device.id, silderLightvalue, stateSwitch)

    }
}