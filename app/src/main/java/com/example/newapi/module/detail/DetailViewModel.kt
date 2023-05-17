package com.example.newapi.module.detail

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.newapi.model.request.response.DetailMovieResponse
import com.example.newapi.module.main.MainRepository
import com.example.newapi.module.main.MainViewModel
import com.example.newapi.network.NetWorkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(val repository: DetailRepository): ViewModel() {

    val movie = MutableStateFlow<DetailMovieResponse?>(null)

    @SuppressLint("SuspiciousIndentation")
    fun getMovie(movieId: Long) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (movie.value != null)
                movie.value = repository.getMovie(movieId).body()!!


            }

        }
    }



}


