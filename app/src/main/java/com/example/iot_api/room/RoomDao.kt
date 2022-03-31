package com.example.iot_api.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.iot_api.model.PostItem


@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(postitem:PostItem)


    @Query("SELECT * FROM postitem")
     fun getPost():LiveData<List<PostItem>>

}