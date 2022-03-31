package com.example.iot_api.repository

import androidx.lifecycle.LiveData
import com.example.iot_api.model.PostItem
import com.example.iot_api.room.RoomDao


class Repository(private val RoomDao:RoomDao){

     suspend fun insertPost(postItem: PostItem){
        RoomDao.insertPost(postItem)
    }

     fun getPost():LiveData<List<PostItem>>{
        return RoomDao.getPost()
    }

}

