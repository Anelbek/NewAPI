//package com.example.newapi.room
//
//import android.app.Application
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.example.newapi.model.request.response.MoviesDatabase
//
//class MovieViewModel(application: Application) : ViewModel() {
//
//    val allMovies: LiveData<List<Movie2>>
//    private val repository: MovieRepository
//    val searchResults: MutableLiveData<List<Movie2>>
//
//    init {
//        val movieDb = MoviesDatabase.getDatabase(application)
//        val movieDao = movieDb.movieDao()
//        repository = MovieRepository(movieDao)
//
//        allMovies = repository.allMovies
//        searchResults = repository.searchResults
//    }
//
//    fun insertMovie(movie: Movie2) {
//        repository.insertMovie(movie)
//    }
//
//    fun findMovie(title: String) {
//        repository.findMovie(title)
//    }
//
//    fun deleteMovie(title: String) {
//        repository.deleteMovie(title)
//    }
//}