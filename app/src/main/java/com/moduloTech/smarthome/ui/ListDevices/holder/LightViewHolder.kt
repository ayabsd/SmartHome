package com.moduloTech.smarthome.ui.ListDevices.holder

import android.view.View
import android.view.animation.AnimationUtils
import com.moduloTech.smarthome.R
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.ui.ListDevices.adapter.OnClickListenner
import com.moduloTech.smarthome.utils.OFF
import com.moduloTech.smarthome.utils.ON
import kotlinx.android.synthetic.main.item_device_light.view.*

class LightViewHolder(itemView: View) : BaseViewHolder<Device.Light>(itemView) {

    override fun bind(device: Device.Light, listener: OnClickListenner, position: Int) {
        itemView.device_name_tv.text = device.name
        itemView.device_intensity_tv.text = device.intensity
        when (device.mode.toUpperCase()) {
            ON -> itemView.state_switch.isChecked = true
            OFF -> itemView.state_switch.isChecked = false
        }

        itemView.delete_bt_light.setOnClickListener {
            listener.onButtonDeleteClick(device = device, position = position)
        }
        itemView.setOnClickListener {
            listener.onDeviceClick(device, view = itemView)

        }



    }


}
