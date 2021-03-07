package com.moduloTech.smarthome.ui.ListDevices.holder

import android.view.View
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.ui.ListDevices.holder.BaseViewHolder
import kotlinx.android.synthetic.main.item_device_heater.view.*
import kotlinx.android.synthetic.main.item_device_light.view.*
import kotlinx.android.synthetic.main.item_device_light.view.device_name_tv

class HeaterViewHolder(itemView: View) : BaseViewHolder<Device.Heater>(itemView) {

    override fun bind(item: Device.Heater) {
        itemView.device_temperature_tv.text = item.temperature
        itemView.device_name_tv.text = item.name
        if (item.mode.toUpperCase().equals("ON")) itemView.state_switch_heater.isChecked = true
        itemView.isEnabled = false

    }


}
