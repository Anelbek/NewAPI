//package com.example.newapi.room
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//
//import com.example.newapi.model.request.response.MovieDao
//import com.example.newapi.network.NetWorkService
//import kotlinx.coroutines.*
//
//class MovieRepository(private val movieDao: MovieDao) {
//    lateinit var service: NetWorkService
//    val allMovies: LiveData<List<Movie2>> = movieDao.getAllMovies()
//    val searchResults = MutableLiveData<List<Movie2>>()
//
//
//    private val coroutineScope = CoroutineScope(Dispatchers.Main)
//
//    fun insertMovie(newMovie: Movie2) {
//        coroutineScope.launch(Dispatchers.IO) {
//            movieDao.insert(newMovie)
//        }
//    }
//
//    fun deleteMovie(title: String) {
//        coroutineScope.launch(Dispatchers.IO) {
//            movieDao.deleteMovie(title)
//        }
//    }
//
//    fun findMovie(title: String) {
//        coroutineScope.launch(Dispatchers.Main) {
//
//            searchResults.value = asyncFind(title).await()
//        }
//    }
//
//    private fun asyncFind(title: String): Deferred<List<Movie2>?> =
//        coroutineScope.async(Dispatchers.IO) {
//            return@async movieDao.findMovie(title)
//        }
//
//}