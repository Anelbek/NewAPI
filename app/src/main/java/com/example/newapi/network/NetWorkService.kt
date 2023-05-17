package com.example.newapi.network


import com.example.newapi.model.request.response.DetailMovieResponse
import com.example.newapi.model.request.response.ListMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface NetWorkService {
    @GET("3/discover/movie")
    suspend fun getMovieList(): Response<ListMovieResponse>

    @GET("3/movie/{movie_id}")
    suspend fun getMovieItem(@Path("id") id: Long): Response<DetailMovieResponse>
}

