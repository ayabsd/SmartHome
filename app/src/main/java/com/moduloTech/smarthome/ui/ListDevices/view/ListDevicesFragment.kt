package com.moduloTech.smarthome.ui.ListDevices.view

import android.os.Bundle
import android.view.*
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.moduloTech.smarthome.R
import com.moduloTech.smarthome.data.model.Device
import com.moduloTech.smarthome.databinding.FragmentListDevicesBinding
import com.moduloTech.smarthome.ui.ListDevices.adapter.DevicesAdapter
import com.moduloTech.smarthome.ui.ListDevices.adapter.OnClickListenner
import com.moduloTech.smarthome.ui.ListDevices.viewmodel.ListDevicesViewModel
import com.moduloTech.smarthome.utils.*
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class ListDevicesFragment : Fragment(), OnClickListenner {

    private lateinit var binding: FragmentListDevicesBinding
    private val viewModel: ListDevicesViewModel by viewModels()
    private lateinit var adapter: DevicesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

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
        adapter = DevicesAdapter()
        adapter.setListener(this)
        binding.deviceRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.deviceRv.adapter = adapter

    }

    private fun setupObservers() {
        viewModel.devices.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) {
                        adapter.filterDevices(
                                adapter.getFilterType(), ArrayList(convertResponse(it.data))

                        )


                    }
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.roller_shutter_action -> adapter.filterWithType(TYPE_ROLLER)
            R.id.light_action -> adapter.filterWithType(TYPE_LIGHT)
            R.id.heater_action -> adapter.filterWithType(TYPE_HEATER)
            R.id.all_action -> adapter.filterWithType(TYPE_ALL)
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onButtonDeleteClick(device: Device?, position: Int) {
        if (device != null) {
            viewModel.deleteDevice(device)
            adapter.removeDevice(device)

        }
    }

    override fun onDeviceClick(device: Device?, view: View) {
        when (device) {
            is Device.Light -> Navigation.findNavController(view).navigate(
                    ListDevicesFragmentDirections.actionToLightDevice(device!!))

            is Device.RollerShutter -> Navigation.findNavController(view).navigate(
                    ListDevicesFragmentDirections
                            .actionToRollerDevice(device!!))
            is Device.Heater -> Navigation.findNavController(view).navigate(ListDevicesFragmentDirections
                    .actionToHeaterDevice(device!!))
            else -> throw IllegalArgumentException()
        }

    }


}