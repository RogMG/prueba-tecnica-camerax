package com.rogelio.core.util

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

    fun getRetrofitObject(): Retrofit {
        val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("xc-token", "J38b4XQNLErVatKIh4oP1jw9e_wYWkS86Y04TMNP")
                    return@Interceptor chain.proceed(builder.build())
                },
            )
        }.build()

        val retrofitInstance = Retrofit.Builder()
            .baseUrl("https://api.devdicio.net:8444/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofitInstance
    }
}
