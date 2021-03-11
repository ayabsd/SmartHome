package com.moduloTech.smarthome.ui.user

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moduloTech.smarthome.data.model.Adress
import com.moduloTech.smarthome.data.model.User
import com.moduloTech.smarthome.data.repository.DeviceRespository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class UserViewModel @ViewModelInject constructor(
    private var repository: DeviceRespository
) : ViewModel() {

    val user = repository.getUserFromLocal()
    val adress = repository.geAdressFromLocal()
    val userUpdateStatus = MutableLiveData<Boolean>()


    fun updateUserAdress(user: User, adress: Adress) {
        GlobalScope.launch {
            if (repository.upateUser(user) == 1 && repository.upateAdress(adress) == 1)
                userUpdateStatus.postValue(true)
            else
                userUpdateStatus.postValue(false)


        }
    }
}
