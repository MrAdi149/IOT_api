package com.example.iot_api.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iot_api.model.PostItem
import com.example.iot_api.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPost1()
        }
    }
    val post1:LiveData<PostItem>
    get() = repository.post1
}