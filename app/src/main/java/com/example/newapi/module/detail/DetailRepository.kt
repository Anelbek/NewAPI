package com.example.newapi.module.detail

import com.example.newapi.model.request.response.DetailMovieResponse
import com.example.newapi.model.request.response.ListMovieResponse
import com.example.newapi.model.request.response.Movie
import com.example.newapi.network.NetWorkService
import retrofit2.Call
import retrofit2.Response

class DetailRepository(private val netWorkService: NetWorkService)

{
    suspend fun getMovie(id: Long): Response<DetailMovieResponse> {

        return netWorkService.getMovieItem(id)
    }
}