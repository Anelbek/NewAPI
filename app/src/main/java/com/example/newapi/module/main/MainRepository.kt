package com.example.newapi.module.main

import com.example.newapi.network.NetWorkService

class MainRepository(private val netWorkService: NetWorkService) {
    suspend fun getMovieList() = netWorkService.getMovieList()
}