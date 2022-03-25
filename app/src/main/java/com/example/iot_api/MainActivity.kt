package com.example.iot_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.iot_api.api.SimpleApi
import com.example.iot_api.api.RetrofitInstance
import com.example.iot_api.model.Post
import com.example.iot_api.repository.Repository
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val repository=Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel= ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {response->
            if(response.isSuccessful){
                Log.d("Response",response.body()?.id.toString())
                Log.d("Response",response.body()?.brand!!)
                Log.d("Response",response.body()?.name!!)
                Log.d("Response",response.body()?.price.toString())
            }

        })

    }
}