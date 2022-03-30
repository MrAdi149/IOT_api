package com.example.iot_api.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.iot_api.api.SimpleApi
import com.example.iot_api.model.Post
import com.example.iot_api.model.PostItem
import com.example.iot_api.room.PostDatabase
import com.example.iot_api.util.MyUtil

class Repository(
    private val simpleApi: SimpleApi,
    private val postDatabase: PostDatabase,
    private val applicationContext: Context

) {
    private val post1LiveData= MutableLiveData<List<PostItem>>()

    val post2:LiveData<List<PostItem>>
    get() = post1LiveData

    suspend fun getPost1(){

        if (MyUtil.isInternetAvailable(applicationContext)){
            val result = simpleApi.getPost()
            if (result.body()!=null){
               postDatabase.post1Dao().insertPost(result.body()!!)
                post1LiveData.postValue(result.body())
            }
        }else{

            val post1 = postDatabase.post1Dao().getPost()
           // val postList= PostItem(Post(post1),success = true)

           // post1LiveData.postValue(postList)
        }
    }
}

