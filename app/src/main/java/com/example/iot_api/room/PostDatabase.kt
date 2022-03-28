package com.example.iot_api.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Post::class], version = 1)
abstract class PostDatabase: RoomDatabase() {


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