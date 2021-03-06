package com.moduloTech.smarthome.ui.DetailsDevice.roller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.databinding.DetailsDeviceRollerFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import java.math.RoundingMode

@AndroidEntryPoint
class DetailsDeviceRollerFragment : Fragment() {
    private lateinit var binding: DetailsDeviceRollerFragmentBinding
    private lateinit var device: Device.RollerShutter
    private val viewModel: DetailsDeviceRollerViewModel by viewModels()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DetailsDeviceRollerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDevice()
        intView()
    }

    /*Get selected device From DeviceListFragment  */
    private fun getDevice() {
        device =
                DetailsDeviceRollerFragmentArgs.fromBundle(requireArguments()).argFromDeviceListFragment as Device.RollerShutter

    }

    /*This initView and display device data */
    private fun intView() {
        binding.deviceNameTv.text = device.name
        binding.deviceRollerValue.value = device.position.toFloat()
        binding.rollerPositionTv.text = device.position
        binding.deviceRollerValue.addOnChangeListener { slider, value, fromUser ->
            binding.rollerPositionTv.text =
                    value.toBigDecimal().setScale(1, RoundingMode.UP).toDouble().toString()


        }
    }

    override fun onPause() {
        onSaveChanges()
        super.onPause()
    }

    /* Update deviceRoller data in my local data base  */
    private fun onSaveChanges() {
        val sildertvalue =
                binding.deviceRollerValue.value.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        viewModel.updateDeviceRoller(device.id, sildertvalue)

    }
}