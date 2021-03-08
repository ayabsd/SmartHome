package com.moduloTech.smarthome.ui.ListDevices.holder

import android.view.View
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.ui.ListDevices.adapter.OnItemClickListener
import kotlinx.android.synthetic.main.item_device_heater.view.*
import kotlinx.android.synthetic.main.item_device_light.view.device_name_tv

class HeaterViewHolder(itemView: View) : BaseViewHolder<Device.Heater>(itemView) {

    override fun bind(device: Device.Heater, listener: OnItemClickListener, position: Int) {
        itemView.device_temperature_tv.text = device.temperature
        itemView.device_name_tv.text = device.name
        if (device.mode.toUpperCase() == "ON") itemView.state_switch_heater.isChecked = true
        itemView.isEnabled = false
        itemView.delete_bt_heater.setOnClickListener {
            listener.onItemClick(device = device , position = position)

        }
    }


}
