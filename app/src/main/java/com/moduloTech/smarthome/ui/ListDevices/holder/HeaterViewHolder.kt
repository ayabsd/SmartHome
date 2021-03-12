package com.moduloTech.smarthome.ui.ListDevices.holder

import android.view.View
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.ui.ListDevices.adapter.OnClickListenner
import com.moduloTech.smarthome.utils.OFF
import com.moduloTech.smarthome.utils.ON
import kotlinx.android.synthetic.main.item_device_heater.view.*
import kotlinx.android.synthetic.main.item_device_light.view.device_name_tv
import java.util.*

class HeaterViewHolder(itemView: View) : BaseViewHolder<Device.Heater>(itemView) {

    override fun bind(device: Device.Heater, listener: OnClickListenner, position: Int) {
        itemView.device_temperature_tv.text = device.temperature
        itemView.device_name_tv.text = device.name
        when (device.mode.toUpperCase(Locale.ROOT)) {
            ON -> itemView.state_switch_heater.isChecked = true
            OFF -> itemView.state_switch_heater.isChecked = false
        }
        itemView.delete_bt_heater.setOnClickListener {
            listener.onButtonDeleteClick(device = device, position = position)

        }
        itemView.setOnClickListener {
            listener.onDeviceClick(device, view = itemView)

        }


    }


}
