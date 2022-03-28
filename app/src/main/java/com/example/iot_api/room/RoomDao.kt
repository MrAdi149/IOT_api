package com.example.iot_api.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import retrofit2.Response


@Dao
interface RoomDao {

    @Insert
    suspend fun insertPost(post: Response<List<Post>>)


    @Query("SELECT * FROM post")
    suspend fun getPost():Response<List<Post>>

}