package com.moduloTech.smarthome.ui.ListDevices

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.moduloTech.smarthome.databinding.FragmentListDevicesBinding
import com.moduloTech.smarthome.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class ListDevicesFragment : Fragment(), DevicesAdapter.DeviceItemListener {

    private lateinit var binding: FragmentListDevicesBinding
    private val viewModel: ListDevicesViewModel by viewModels()
    private lateinit var adapter: DevicesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListDevicesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = DevicesAdapter(this)
        binding.deviceRv.layoutManager = LinearLayoutManager(requireContext())
        binding.deviceRv.adapter = adapter
    }

        private fun setupObservers() {
            viewModel.devices.observe(viewLifecycleOwner, Observer {
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                    }
                    Resource.Status.ERROR ->
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                    Resource.Status.LOADING ->
                        binding.progressBar.visibility = View.VISIBLE
                }
            })
        }

    override fun onClickedDevice(DeviceId: Int) {

    }
}