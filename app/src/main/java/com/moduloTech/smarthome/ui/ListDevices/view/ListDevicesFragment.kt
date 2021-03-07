package com.moduloTech.smarthome.ui.ListDevices.view

import android.os.Bundle
import android.view.*
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.moduloTech.smarthome.R
import com.moduloTech.smarthome.databinding.FragmentListDevicesBinding
import com.moduloTech.smarthome.ui.ListDevices.viewmodel.ListDevicesViewModel
import com.moduloTech.smarthome.ui.ListDevices.adapter.DevicesAdapter
import com.moduloTech.smarthome.utils.Resource
import com.moduloTech.smarthome.utils.convertResponse
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class ListDevicesFragment : Fragment() {

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

        setHasOptionsMenu(true);


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = DevicesAdapter()
        binding.deviceRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.deviceRv.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.devices.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(convertResponse(it.data)))
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

            R.id.roller_shutter_action -> Toast.makeText(activity, "dbndnbdsb", Toast.LENGTH_LONG).show()
            R.id.light_action -> Toast.makeText(activity, "dbndnbdsb", Toast.LENGTH_LONG).show()
            R.id.heater_action -> Toast.makeText(activity, "dbndnbdsb", Toast.LENGTH_LONG).show()

        }

        return super.onOptionsItemSelected(item)
    }
    private fun retriveDaWithType() {
        viewModel.devices.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(convertResponse(it.data)))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }
}
