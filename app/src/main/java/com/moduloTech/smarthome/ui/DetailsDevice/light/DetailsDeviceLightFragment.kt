package com.moduloTech.smarthome.ui.DetailsDevice.light

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.slider.Slider
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.databinding.DetailsDeviceLightFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import java.math.RoundingMode
import java.text.DecimalFormat

@AndroidEntryPoint

class DetailsDeviceLightFragment : Fragment() {
    private lateinit var binding: DetailsDeviceLightFragmentBinding
    private lateinit var device: Device.Light


    private val viewModel: DetailsDeviceLightViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailsDeviceLightFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getSelectedDevice()
    }

    private fun getSelectedDevice() {
        device =
            DetailsDeviceLightFragmentArgs.fromBundle(requireArguments()).argFromDeviceListFragment as Device.Light
        if (device != null) {
            if (device.mode.equals("ON")) binding.stateSwitchLight.isChecked =
                true else binding.stateSwitchLight.isChecked = false
            binding.deviceNameTv.text = device.name
            binding.deviceLightSilder.value = device.intensity.toFloat()
            binding.deviceIntensityTv.text = device.intensity.toFloat().toString()
            binding.deviceLightSilder.addOnChangeListener(Slider.OnChangeListener { slider, value, fromUser ->
                val df = DecimalFormat("#.##")
                df.roundingMode = RoundingMode.CEILING
                binding.deviceIntensityTv.text = df.format(value).toString()
            })

        }
    }


    override fun onPause() {
        val stateSwitch = when (binding.stateSwitchLight.isChecked) {
            true -> "ON"
            false -> "OFF"
        }
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        val silderLightvalue = binding.deviceLightSilder.value.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        viewModel.updateDeviceLight(device.id, silderLightvalue, stateSwitch)

        super.onPause()
    }
}