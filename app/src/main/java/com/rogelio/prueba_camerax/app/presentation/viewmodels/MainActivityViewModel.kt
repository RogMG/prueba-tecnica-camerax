package com.rogelio.prueba_camerax.app.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rogelio.core.data.repository.UsersRepositoryData
import com.rogelio.core.domain.models.UsersDTO
import com.rogelio.core.domain.repository.UsersRepository
import com.rogelio.core.domain.usecase.GetUsersUseCase
import com.rogelio.core.util.ResponseResult
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivityViewModel : ViewModel() {

    private val repository: UsersRepository = UsersRepositoryData()
    private val getUsersUseCase = GetUsersUseCase(repository)
    val usersData = MutableLiveData<UsersDTO>()
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
}
