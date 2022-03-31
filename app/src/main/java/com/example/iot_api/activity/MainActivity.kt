package com.example.iot_api.activity

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.iot_api.viewModel.MainViewModel
import com.example.iot_api.viewModel.MainViewModelFactory
import com.example.iot_api.databinding.ActivityMainBinding
import com.example.iot_api.adapter.PostAdapter
import com.example.iot_api.api.RetrofitInstance
import com.example.iot_api.api.SimpleApi
import com.example.iot_api.model.PostItem
import com.example.iot_api.repository.Repository
import com.example.iot_api.room.PostDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {

//        val repository=(application as MyActivity).repository
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitInstance = RetrofitInstance

        val data = retrofitInstance.getInstance()

        val RoomDao=PostDatabase.getDatabase(applicationContext).post1Dao()
        val repository=Repository(RoomDao)

//Api ignore
        val ai: ApplicationInfo = applicationContext.packageManager
            .getApplicationInfo(applicationContext.packageName, PackageManager.GET_META_DATA)
        val value = ai.metaData["keyValue"]

        val key = value.toString()
        Toast.makeText(applicationContext,key,Toast.LENGTH_LONG).show()


        val adapter=PostAdapter()
        binding.recyclerView.adapter=adapter

        viewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        viewModel.getPost().observe(this, Observer {

            adapter.setData(it)

        })

        data.create(SimpleApi::class.java).getPost().enqueue(object : Callback<List<PostItem>?>{
            override fun onResponse(
                call: Call<List<PostItem>?>,
                response: Response<List<PostItem>?>
            ) {
                val response=response.body()!!
                viewModel.insertPost(response)
            }

            override fun onFailure(call: Call<List<PostItem>?>, t: Throwable) {


            }

        })

//        recyclerView.apply {
//            layoutManager=LinearLayoutManager(this@MainActivity)
//            postAdapter=PostAdapter(this@MainActivity)
//            adapter=postAdapter
//            val divider=DividerItemDecoration(applicationContext,VERTICAL)
//            addItemDecoration(divider)
//        }
    }
}