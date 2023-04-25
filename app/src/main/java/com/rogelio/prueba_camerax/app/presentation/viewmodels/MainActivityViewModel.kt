package com.rogelio.prueba_camerax.app.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rogelio.core.data.mappers.UsersListMapper
import com.rogelio.core.data.mappers.UsersRequestMapper
import com.rogelio.core.data.repository.UsersRepositoryData
import com.rogelio.core.domain.models.UsersDTO
import com.rogelio.core.domain.models.UsersFieldsRequestDTO
import com.rogelio.core.domain.repository.UsersRepository
import com.rogelio.core.domain.usecase.GetUsersUseCase
import com.rogelio.core.domain.usecase.SetUserUseCase
import com.rogelio.core.util.ResponseResult
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivityViewModel : ViewModel() {

    private val getUsersMappper = UsersListMapper()
    private val setUsersMapper = UsersRequestMapper()
    private val repository: UsersRepository = UsersRepositoryData(getUsersMappper, setUsersMapper)
    private val getUsersUseCase = GetUsersUseCase(repository)
    private val setUsersUseCase = SetUserUseCase(repository)
    private var usersFields = UsersFieldsRequestDTO()
    val usersData = MutableLiveData<UsersDTO>()
    val userCreatedResponse = MutableLiveData<String>()
    val exception = MutableLiveData<Exception>()

    fun getUsersData() {
        viewModelScope.launch {
            val result = getUsersUseCase.invoke()
            when (result) {
                is ResponseResult.Success -> {
                    usersData.postValue(result.data ?: UsersDTO())
                }
                is ResponseResult.Error -> {
                    exception.postValue(result.exception)
                }
            }
        }
    }

    fun saveUserData(data: UsersFieldsRequestDTO) {
        usersFields = data
    }

    fun saveImageInData(image: String) {
        usersFields.datos?.imagen = image
        viewModelScope.launch{
            val result = setUsersUseCase.invoke(usersFields)
            when (result) {
                is ResponseResult.Success -> {
                    userCreatedResponse.postValue("Usuario creado exitosamente con ID: ${result.data.id}")
                }
                is ResponseResult.Error -> {
                    exception.postValue(result.exception)
                }
            }
        }
    }
}
