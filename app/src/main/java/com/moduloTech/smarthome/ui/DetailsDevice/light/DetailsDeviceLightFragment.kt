package com.moduloTech.smarthome.ui.DetailsDevice.light

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.databinding.DetailsDeviceLightFragmentBinding
import com.moduloTech.smarthome.utils.OFF
import com.moduloTech.smarthome.utils.ON
import dagger.hilt.android.AndroidEntryPoint
import java.math.RoundingMode

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
        getDevice()
        initView()
    }

    private fun getDevice() {
        device =
                DetailsDeviceLightFragmentArgs.fromBundle(requireArguments()).argFromDeviceListFragment as Device.Light
    }

    private fun initView() {
        binding.switchLight.isChecked = device.mode == ON
        binding.deviceNameTv.text = device.name
        binding.deviceLightSilder.value = device.intensity.toFloat()
        binding.deviceIntensityTv.text = device.intensity.toFloat().toString()
        binding.deviceLightSilder.addOnChangeListener { slider, value, fromUser ->
            binding.deviceIntensityTv.text =
                    value.toBigDecimal().setScale(1, RoundingMode.UP).toDouble().toString()


        }
    }

    override fun onPause() {
        val stateSwitch = when (binding.switchLight.isChecked) {
            true -> ON
            false -> OFF
        }
        val silderLightvalue =
                binding.deviceLightSilder.value.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        viewModel.updateDeviceLight(device.id, silderLightvalue, stateSwitch)
        super.onPause()
    }
}