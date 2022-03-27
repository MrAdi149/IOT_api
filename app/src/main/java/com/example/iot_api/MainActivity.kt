package com.example.iot_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iot_api.databinding.ActivityMainBinding
import com.example.iot_api.model.Post
import com.example.iot_api.adapter.PostAdapter
import com.example.iot_api.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val repository=Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel= ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]
        viewModel.getPost()
        binding.button.setOnClickListener {
            val myNumber=binding.numberEditText.text.toString()
            viewModel.getPost2(Integer.parseInt(myNumber))
            viewModel.myResponse1.observe(this, Observer {response->
                Log.d("Response_is",response.toString())
                if(response.isSuccessful){
                    binding.textView.text=response.body().toString()

                }else{
                    binding.textView.text=response.code().toString()
                }

            })
        }

    }
}