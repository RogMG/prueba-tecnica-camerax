package com.rogelio.core.domain.repository

import com.rogelio.core.domain.models.UsersDTO
import com.rogelio.core.util.ResponseResult
import retrofit2.Response

interface UsersRepository {
    suspend fun getUsers(): ResponseResult<UsersDTO>
}