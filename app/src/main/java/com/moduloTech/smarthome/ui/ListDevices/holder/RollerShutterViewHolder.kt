package com.moduloTech.smarthome.ui.ListDevices.holder

import android.view.View
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.ui.ListDevices.adapter.OnClickListenner
import kotlinx.android.synthetic.main.item_device_light.view.device_name_tv
import kotlinx.android.synthetic.main.item_device_roller.view.*

class RollerShutterViewHolder(itemView: View) : BaseViewHolder<Device.RollerShutter>(itemView) {

    override fun bind(device: Device.RollerShutter, listener: OnClickListenner, position: Int) {
        itemView.device_name_tv.text = device.name
        itemView.device_position_tv.text = device.position
        itemView.delete_bt_roller.setOnClickListener {
            listener.onButtonDeleteClick(device = device, position = position)

        }
        itemView.setOnClickListener {
            listener.onDeviceClick(device , view = itemView)

        }


    }


}
