//package com.example.newapi.model.request.response
//
//
//import androidx.lifecycle.LiveData
//import androidx.room.*
//import com.example.newapi.room.Movie2
//
//
//@Dao
//interface MovieDao {
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun insert(movie: Movie2)
//
//    @Query("SELECT * FROM movies WHERE title = :title")
//    fun findMovie(title: String): List<Movie2>
//
//    @Query("DELETE FROM movies WHERE title = :title")
//    fun deleteMovie(title: String)
//
//    @Query("SELECT * FROM movies")
//    fun getAllMovies(): LiveData<List<Movie2>>
//
//}