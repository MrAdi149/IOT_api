package com.example.iot_api.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iot_api.model.PostItem
import com.example.iot_api.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository):ViewModel() {
//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.getPost()
//        }
//    }
//    val post1: PostItem
//    get()=repository.insertPost(post1)

    fun getPost(): LiveData<List<PostItem>>{
        return repository.getPost()
    }
    fun insertPost(postItem: List<PostItem>){
        viewModelScope.launch(Dispatchers.IO) {
            for (i in postItem){
                repository.insertPost(i)
            }
        }
    }

}