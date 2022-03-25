package com.example.iot_api.api

import com.example.iot_api.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("/products.json")
    suspend fun getPost(): Response<Post>
}