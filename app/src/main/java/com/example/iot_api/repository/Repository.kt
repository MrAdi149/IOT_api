package com.example.iot_api.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.iot_api.api.RetrofitInstance
import com.example.iot_api.api.SimpleApi
import com.example.iot_api.model.PostItem
import com.example.iot_api.model.ProductColor
import com.example.iot_api.room.PostDatabase
import retrofit2.Response

class Repository(private val simpleApi: SimpleApi,private val postDatabase: PostDatabase) {
    private val post1LiveData= MutableLiveData<PostItem>()

    val post2:LiveData<PostItem>
    get() = post1LiveData

    suspend fun getPost1(){
        val result = simpleApi.getPost()
        if (result.body()!=null){
            postDatabase.post1Dao().insertPost(result.body()!!.id.postitem)
            post1LiveData.postValue(result.body())
        }
    }
}

