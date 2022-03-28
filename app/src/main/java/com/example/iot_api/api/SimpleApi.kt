package com.example.iot_api.api

import com.example.iot_api.model.PostItem
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("products.json")
    suspend fun getPost(): Response<PostItem>
}