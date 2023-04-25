package com.rogelio.core.data.service

import com.rogelio.core.data.models.request.UsersRequestModelFields
import com.rogelio.core.data.models.response.UsersResponseModelFields
import com.rogelio.core.data.models.response.UsersResponseModelList
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("v1/sec_dev_interview")
    suspend fun setUser(@Body data: UsersRequestModelFields): Response<UsersResponseModelFields>

    @GET("v1/sec_dev_interview/?limit=100")
    suspend fun getUsers(): Response<List<UsersResponseModelFields>>


}