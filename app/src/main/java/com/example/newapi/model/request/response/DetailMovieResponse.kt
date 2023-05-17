package com.example.newapi.model.request.response

import android.icu.math.BigDecimal
import com.google.gson.annotations.SerializedName

//data class DetailMovie(val results: List<DetailMovieResponse>)

data class DetailMovieResponse(
    val id: Long,
    val title: String,
    val overview: String,
    val budget: BigDecimal,
    val genres: List<Genres>,
    @SerializedName("spoken_languages")
    val listNameLanguages: List<SpokenLanguages>,
    @SerializedName("backdrop_path")
    val image: String,
    val tagline: String,
    val releaseDate: String,
    val homepage: String
)

data class SpokenLanguages(
    @SerializedName("english_name")
    val nameLanguage: String
)

data class Genres(
    @SerializedName("english_name")
    val id: Int,
    val name: String
)