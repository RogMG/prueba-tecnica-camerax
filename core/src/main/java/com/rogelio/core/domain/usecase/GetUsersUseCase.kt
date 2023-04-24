package com.rogelio.core.domain.usecase

import com.rogelio.core.domain.models.UsersDTO
import com.rogelio.core.domain.repository.UsersRepository
import com.rogelio.core.util.ResponseResult

class GetUsersUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(): ResponseResult<UsersDTO> {
        return repository.getUsers()
    }

}