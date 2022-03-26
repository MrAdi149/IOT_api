package com.example.iot_api.repository

import com.example.iot_api.api.RetrofitInstance
import com.example.iot_api.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost():Response<List<Post>>{
        return RetrofitInstance.api.getPost()
    }
}