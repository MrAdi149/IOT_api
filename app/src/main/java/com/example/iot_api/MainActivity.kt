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
            Log.d("Response_is",response.toString())
            if(response.isSuccessful){
            response.body()?.forEach {
                Log.d("Response",it.id.toString())
                Log.d("Response",it.brand.toString())
                Log.d("Response",it.name.toString())
                Log.d("Response",it.price.toString())
            }

                 }

        })

    }
}