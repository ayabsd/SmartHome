package com.moduloTech.smarthome.ui.DetailsDevice.heater

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.slider.Slider
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.databinding.DetailsDeviceHeaterFragmentBinding
import com.moduloTech.smarthome.utils.OFF
import com.moduloTech.smarthome.utils.ON
import dagger.hilt.android.AndroidEntryPoint
import java.math.RoundingMode
import java.text.DecimalFormat

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

    fun initView() {
        if (device != null) {
            if (device.mode.equals("ON")) binding.stateSwitchTemperature.isChecked =
                true else binding.stateSwitchTemperature.isChecked = false
        }
        binding.deviceNameTv.text = device.name
        binding.deviceTemperature.value = device.temperature.toFloat()
        binding.deviceTemperatureTv.text = device.temperature.toFloat().toString()
        binding.deviceTemperature.addOnChangeListener(Slider.OnChangeListener { slider, value, fromUser ->
            binding.deviceTemperatureTv.text =
                value.toBigDecimal().setScale(1, RoundingMode.UP).toDouble().toString()
        })


    }

    override fun onPause() {
        onSaveChanges()
        super.onPause()
    }


    fun onSaveChanges() {
        val stateSwitch = when (binding.stateSwitchTemperature.isChecked) {
            true -> ON
            false -> OFF
        }
        val silderLightvalue = binding.deviceTemperature.value.toBigDecimal().toDouble()
        viewModel.updateDeviceHeater(device.id, silderLightvalue, stateSwitch)

    }
}