package com.example.iot_api.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iot_api.viewModel.MainViewModel
import com.example.iot_api.viewModel.MainViewModelFactory
import com.example.iot_api.databinding.ActivityMainBinding
import com.example.iot_api.adapter.PostAdapter
import com.example.iot_api.api.RetrofitInstance
import com.example.iot_api.api.SimpleApi
import com.example.iot_api.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val postAdapter by lazy { PostAdapter() }
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        val repository=(application as MyActivity).repository
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView



        viewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        viewModel.post1.observe(this,{
            Log.d("Response","onCreate:${it.toString()}")
        })

    }
}