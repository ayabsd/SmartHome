package com.moduloTech.smarthome.ui.ListDevices.holder

import android.view.View
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.ui.ListDevices.adapter.OnItemClickListener
import kotlinx.android.synthetic.main.item_device_light.view.*

class LightViewHolder(itemView: View) : BaseViewHolder<Device.Light>(itemView) {

    override fun bind(device: Device.Light, listener: OnItemClickListener ,  position: Int) {
        itemView.device_name_tv.text = device.name
        itemView.device_intensity_tv.text = device.intensity
        if (device.mode.toUpperCase() == "ON") itemView.state_switch.isChecked = true
        itemView.delete_bt_light.setOnClickListener {
            listener.onItemClick(device = device , position = position)

        }

    }


}
