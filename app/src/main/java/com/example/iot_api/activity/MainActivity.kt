package com.example.iot_api.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout.VERTICAL
import android.widget.Toast
import androidx.lifecycle.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iot_api.viewModel.MainViewModel
import com.example.iot_api.viewModel.MainViewModelFactory
import com.example.iot_api.databinding.ActivityMainBinding
import com.example.iot_api.adapter.PostAdapter
import com.example.iot_api.api.RetrofitInstance
import com.example.iot_api.api.SimpleApi
import com.example.iot_api.model.PostItem
import com.example.iot_api.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private lateinit var recyclerView:RecyclerView
     lateinit var postAdapter: PostAdapter


    override fun onCreate(savedInstanceState: Bundle?) {

        val repository=(application as MyActivity).repository
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        recyclerView.apply {
//            layoutManager=LinearLayoutManager(this@MainActivity)
//            postAdapter=PostAdapter(this@MainActivity)
//            adapter=postAdapter
//            val divider=DividerItemDecoration(applicationContext,VERTICAL)
//            addItemDecoration(divider)
//        }
        viewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        viewModel.post1.observe(this, Observer {

            postAdapter.setData(it)

        })
    }
}