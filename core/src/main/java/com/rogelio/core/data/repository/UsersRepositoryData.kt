package com.rogelio.core.data.repository

import com.rogelio.core.data.mappers.UsersListMapper
import com.rogelio.core.data.models.response.UsersResponseModelFields
import com.rogelio.core.data.models.response.UsersResponseModelList
import com.rogelio.core.data.service.ApiService
import com.rogelio.core.domain.mappers.MapperTransform
import com.rogelio.core.domain.models.UsersDTO
import com.rogelio.core.domain.repository.UsersRepository
import com.rogelio.core.util.ResponseResult
import com.rogelio.core.util.RetrofitObject

class UsersRepositoryData : UsersRepository {

    val retrofit = RetrofitObject.getRetrofitObject().create(ApiService::class.java)
    val mapper: MapperTransform<List<UsersResponseModelFields>, UsersDTO> = UsersListMapper()

    override suspend fun getUsers(): ResponseResult<UsersDTO> {
        return try {
            val data = retrofit.getUsers()
            if (data.isSuccessful) {
                ResponseResult.Success(mapper.transform(data.body()))
            } else {
                ResponseResult.Error(Exception(data.errorBody()?.string()))
            }
        } catch (e: Exception) {
            ResponseResult.Error(e)
        }
    }
}
