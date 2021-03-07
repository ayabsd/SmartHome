package com.moduloTech.smarthome.ui.ListDevices.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moduloTech.smarthome.R
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.ui.ListDevices.holder.BaseViewHolder
import com.moduloTech.smarthome.ui.ListDevices.holder.HeaterViewHolder
import com.moduloTech.smarthome.ui.ListDevices.holder.LightViewHolder
import com.moduloTech.smarthome.ui.ListDevices.holder.RollerShutterViewHolder


class DevicesAdapter(
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    private val items = ArrayList<Device>()

    companion object {
        private const val TYPE_LIGHT = 0
        private const val TYPE_ROLLER = 1
        private const val TYPE_Heater = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_LIGHT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_device_light, parent, false)
                LightViewHolder(
                    view
                )
            }
            TYPE_Heater -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_device_heater, parent, false)
                HeaterViewHolder(
                    view
                )
            }
            TYPE_ROLLER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_device_roller, parent, false)
                RollerShutterViewHolder(
                    view
                )
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: ArrayList<Device>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = items[position]
        when (holder) {
            is LightViewHolder -> holder.bind(element as Device.Light)
            is HeaterViewHolder -> holder.bind(element as Device.Heater)
            is RollerShutterViewHolder -> holder.bind(element as Device.RollerShutter)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        val comparable = items[position]
        return when (comparable) {
            is Device.Light -> TYPE_LIGHT
            is Device.Heater -> TYPE_Heater
            is Device.RollerShutter -> TYPE_ROLLER
            else -> throw IllegalArgumentException("Invalid type of data " + position)
        }
    }


}





