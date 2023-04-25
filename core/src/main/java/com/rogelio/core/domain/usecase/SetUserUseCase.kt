package com.rogelio.core.domain.usecase

import com.rogelio.core.data.models.response.UsersResponseModelFields
import com.rogelio.core.domain.models.UsersFieldsRequestDTO
import com.rogelio.core.domain.repository.UsersRepository
import com.rogelio.core.util.ResponseResult

class SetUserUseCase(val repository: UsersRepository) {

    suspend operator fun invoke(data: UsersFieldsRequestDTO): ResponseResult<UsersResponseModelFields>{
        return repository.setUsers(data)
    }

}