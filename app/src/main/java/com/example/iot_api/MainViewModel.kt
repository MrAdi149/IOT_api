package com.example.iot_api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iot_api.model.Post
import com.example.iot_api.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {

    val myResponse:MutableLiveData<Response<Post>> = MutableLiveData()

            fun getPost(){
                viewModelScope.launch {
                   val response = repository.getPost()
                    myResponse.value=response
                }
            }

}