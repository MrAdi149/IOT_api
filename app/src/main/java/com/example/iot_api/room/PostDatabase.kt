package com.example.iot_api.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.iot_api.model.Post
import com.example.iot_api.model.PostItem


@Database(entities = [PostItem::class], version = 1)
abstract class PostDatabase: RoomDatabase() {

    abstract fun post1Dao():RoomDao


    companion object{
        private var INSTANCE: PostDatabase?=null
        fun getDatabase(context: Context):PostDatabase{
            if (INSTANCE==null){

                INSTANCE= Room.databaseBuilder(
                    context,
                    PostDatabase::class.java,
                    "postDB"
                ).build()

            }
            return INSTANCE!!
        }
    }
}