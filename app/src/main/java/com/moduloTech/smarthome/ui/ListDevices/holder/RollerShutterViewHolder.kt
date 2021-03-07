package com.moduloTech.smarthome.ui.ListDevices.holder

import android.view.View
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.ui.ListDevices.holder.BaseViewHolder
import kotlinx.android.synthetic.main.item_device_light.view.*
import kotlinx.android.synthetic.main.item_device_light.view.device_name_tv
import kotlinx.android.synthetic.main.item_device_roller.view.*

class RollerShutterViewHolder(itemView: View) : BaseViewHolder<Device.RollerShutter>(itemView) {

    override fun bind(item: Device.RollerShutter) {
        itemView.device_name_tv.text = item.name
        itemView.device_position_tv.text = item.position

    }


}
