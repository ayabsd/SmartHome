package com.moduloTech.smarthome.ui.ListDevices.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moduloTech.smarthome.R
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.ui.ListDevices.holder.BaseViewHolder
import com.moduloTech.smarthome.ui.ListDevices.holder.HeaterViewHolder
import com.moduloTech.smarthome.ui.ListDevices.holder.LightViewHolder
import com.moduloTech.smarthome.ui.ListDevices.holder.RollerShutterViewHolder
import com.moduloTech.smarthome.utils.TYPE_ALL
import com.moduloTech.smarthome.utils.TYPE_HEATER
import com.moduloTech.smarthome.utils.TYPE_LIGHT
import com.moduloTech.smarthome.utils.TYPE_ROLLER

interface OnClickListenner {
    fun onButtonDeleteClick(device: Device?, position: Int)
    fun onDeviceClick(device: Device? , view : View)
}

class DevicesAdapter :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    private var devices = ArrayList<Device>()
    private var filtredArray = ArrayList<Device>()
    private var filterType: String = TYPE_ALL


    private lateinit var listener: OnClickListenner

    companion object {
        private const val HOLDER_TYPE_LIGHT_ = 0
        private const val HOLDER_TYPE_ROLLER = 1
        private const val HOLDER_TYPE_Heater = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            HOLDER_TYPE_LIGHT_ -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_device_light, parent, false)
                LightViewHolder(
                    view
                )
            }
            HOLDER_TYPE_Heater -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_device_heater, parent, false)
                HeaterViewHolder(
                    view
                )
            }
            HOLDER_TYPE_ROLLER -> {
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
        return filtredArray.size
    }


    fun setListener(listener: OnClickListenner) {
        this.listener = listener
    }

    fun removeDevice(device: Device) {
        filtredArray.remove(device)
        notifyDataSetChanged()
    }
    fun removeAll() {
        filtredArray.clear()
        devices.clear()
    }
    fun getArray() : ArrayList<Device>{
        return devices
    }


    fun filterWithType(type: String) {
        this.filterType = type
        filtredArray.clear()
        when (type) {
            TYPE_ROLLER -> filtredArray.addAll(devices.filterIsInstance(Device.RollerShutter::class.java))
            TYPE_LIGHT -> filtredArray.addAll(devices.filterIsInstance(Device.Light::class.java))
            TYPE_HEATER -> filtredArray.addAll(devices.filterIsInstance(Device.Heater::class.java))
            TYPE_ALL -> filtredArray.addAll(devices)
        }
        notifyDataSetChanged()
    }

    fun filterDevices(type: String, items: ArrayList<Device>) {
        this.filterType = type
        this.filtredArray.clear()
        this.devices.clear()
        this.devices = items
        when (type) {
            TYPE_ROLLER -> filtredArray.addAll(items.filterIsInstance(Device.RollerShutter::class.java))
            TYPE_LIGHT -> filtredArray.addAll(items.filterIsInstance(Device.Light::class.java))
            TYPE_HEATER -> filtredArray.addAll(items.filterIsInstance(Device.Heater::class.java))
            TYPE_ALL -> filtredArray.addAll(items)


        }
        notifyDataSetChanged()
    }

    fun getFilterType(): String {
        return filterType
    }


    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = filtredArray[position]
        when (holder) {
            is LightViewHolder -> holder.bind(element as Device.Light, listener, position)
            is HeaterViewHolder -> holder.bind(element as Device.Heater, listener, position)
            is RollerShutterViewHolder -> holder.bind(
                element as Device.RollerShutter,
                listener,
                position
            )
            else -> throw IllegalArgumentException()
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (filtredArray[position]) {
            is Device.Light -> HOLDER_TYPE_LIGHT_
            is Device.Heater -> HOLDER_TYPE_Heater
            is Device.RollerShutter -> HOLDER_TYPE_ROLLER
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }


}





