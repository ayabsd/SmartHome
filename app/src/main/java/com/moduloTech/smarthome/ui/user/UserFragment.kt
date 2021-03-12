package com.moduloTech.smarthome.ui.user

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.moduloTech.smarthome.R
import com.moduloTech.smarthome.data.model.Adress
import com.moduloTech.smarthome.data.model.User
import com.moduloTech.smarthome.utils.convertDateToLong
import com.moduloTech.smarthome.utils.convertdateNumberToDate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.user_fragment.*
import java.util.*


@Suppress("DEPRECATION")
@AndroidEntryPoint
class UserFragment : Fragment(), View.OnClickListener {

    companion object;

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setupObservers()
        initView()
        initDatePicker()

    }

    private fun setupObservers() {
        viewModel.user.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it != null) initUser(user = it)

        })
        viewModel.adress.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it != null) initAdress(adress = it)

        })

        viewModel.userUpdateStatus.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it == true)
                Toast.makeText(activity, resources.getString(R.string.app_user_upated), Toast.LENGTH_LONG).show()
            else
                Toast.makeText(activity, resources.getString(R.string.app_user_not_upated), Toast.LENGTH_LONG).show()

        })
    }

    private fun initView() {
        birth_date_tv.isFocusable = true
        birth_date_tv.isFocusableInTouchMode = true
        birth_date_tv.inputType = InputType.TYPE_NULL
        validate_update.setOnClickListener(this)
    }

    private fun initDatePicker() {
        birth_date_tv.setOnClickListener {
            val mCurrentDate = Calendar.getInstance()
            val mYear = mCurrentDate[Calendar.YEAR]
            val mMonth = mCurrentDate[Calendar.MONTH]
            val mDay = mCurrentDate[Calendar.DAY_OF_MONTH]
            val mDatePicker =
                DatePickerDialog(
                    requireContext(), R.style.DatePickerDialog,
                    OnDateSetListener { datePicker_, selectedYear, selectedMonth, selectedDay ->

                        birth_date_tv.setText("$selectedDay/$selectedMonth/$selectedYear")

                    }, mYear, mMonth, mDay
                )

            mDatePicker.show()
        }
    }


    private fun initUser(user: User) {
        first_name_tv?.setText(user.firstName)
        last_name_tv?.setText(user.lastName)
        birth_date_tv?.setText(convertdateNumberToDate(user.birthDate.toLong()))
        first_name_tv?.setText(user.firstName)

    }

    private fun initAdress(adress: Adress) {
        city_tv?.setText(adress.city)
        contry_tv?.setText(adress.country)
        code_city_tv?.setText(adress.postalCode)
        code_street_tv?.setText(adress.streetCode)
        street_tv?.setText(adress.street)
    }

    private fun validateUpdate() {
        val user = User(
            firstName = first_name_tv.text.toString(),
            lastName = last_name_tv.text.toString(),
            birthDate = convertDateToLong(birth_date_tv.text.toString()).toString()
        )
        val adress = Adress(
            city_tv.text.toString(),
            street_tv.text.toString(),
            code_street_tv.text.toString(),
            code_city_tv.text.toString(),
            contry_tv.text.toString()
        )
        viewModel.updateUserAdress(user, adress)
    }

    override fun onClick(p0: View?) {
        if (!city_tv.text.isNullOrEmpty() && !street_tv.text.isNullOrEmpty()
            && !code_street_tv.text.isNullOrEmpty() && !code_city_tv.text.isNullOrEmpty()
            && !contry_tv.text.isNullOrEmpty() && !first_name_tv.text.isNullOrEmpty()
            && !last_name_tv.text.isNullOrEmpty()
            && !birth_date_tv.text.isNullOrEmpty()
        ) validateUpdate()
    }


}


