package com.moduloTech.smarthome.ui.ListDevices

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moduloTech.smarthome.data.model.ApiDevices
import com.moduloTech.smarthome.databinding.ItemDeviceBinding


class DevicesAdapter(private val listener: DeviceItemListener) : RecyclerView.Adapter<DeviceViewHolder>() {

    interface DeviceItemListener {
        fun onClickedDevice(DeviceId: Int)
    }

    private val items = ArrayList<ApiDevices>()

    fun setItems(items: ArrayList<ApiDevices>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val binding: ItemDeviceBinding = ItemDeviceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeviceViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) = holder.bind(items[position])
}

class DeviceViewHolder(private val itemBinding: ItemDeviceBinding, private val listener: DevicesAdapter.DeviceItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {
    private lateinit var Device: ApiDevices

    @SuppressLint("SetTextI18n")
    fun bind(item: ApiDevices) {
        this.Device = item
        itemBinding.deviceNameTv.text = item.deviceName

    }

    override fun onClick(v: View?) {
    }

}
