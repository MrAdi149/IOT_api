package com.example.iot_api.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.iot_api.model.Post
import com.example.iot_api.model.PostItem
import retrofit2.Response


@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(postitem: List<PostItem>)


    @Query("SELECT * FROM postitem")
    suspend fun getPost():List<PostItem>

}