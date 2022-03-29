package com.example.iot_api.activity

import android.app.Application
import com.example.iot_api.api.RetrofitInstance
import com.example.iot_api.api.SimpleApi
import com.example.iot_api.repository.Repository
import com.example.iot_api.room.PostDatabase

class MyActivity:Application() {

    lateinit var repository: Repository
    override fun onCreate(){
        super.onCreate()
        val simpleApi= RetrofitInstance.getInstance().create(SimpleApi::class.java)

        val database=PostDatabase.getDatabase(applicationContext)
         repository= Repository(simpleApi,database)
    }


}