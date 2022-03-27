package com.example.iot_api.api

import com.example.iot_api.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {
    @GET("products.json")
    suspend fun getPost(): Response<List<Post>>

    @GET("products.json/{productNumber}")
    suspend fun getPost2(
        @Path("productNumber") number:Int
    ):Response<List<Post>>
}