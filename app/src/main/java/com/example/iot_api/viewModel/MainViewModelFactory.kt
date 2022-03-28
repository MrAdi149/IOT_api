package com.example.iot_api.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.iot_api.repository.Repository

class MainViewModelFactory(private val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
         return MainViewModel(repository) as T
    }
}