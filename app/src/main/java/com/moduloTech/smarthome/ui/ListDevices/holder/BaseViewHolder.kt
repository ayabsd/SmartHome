package com.moduloTech.smarthome.ui.ListDevices.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.moduloTech.smarthome.ui.ListDevices.adapter.OnClickListenner

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T, listener: OnClickListenner, position: Int)
}