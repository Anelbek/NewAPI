//package com.example.newapi.model.request.response
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.newapi.room.Movie2
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//
//@Database(entities = [Movie2::class], version = 1)
//abstract class MoviesDatabase : RoomDatabase() {
//
//    abstract fun movieDao(): MovieDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: MoviesDatabase? = null
//        private const val DB_NAME = "movies.db"
//
//        fun getDatabase(context: Context): MoviesDatabase {
//            return INSTANCE ?: synchronized(this) {
//
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    MoviesDatabase::class.java, DB_NAME
//                )
//                    .createFromAsset("")
//                    .build()
//                INSTANCE = instance
//
//                instance
//            }
//
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////suspend fun rePopulateDb(database: MoviesDatabase?) {
////    database?.let { db ->
////        withContext(Dispatchers.IO) {
////            val movieDao: MovieDao = db.movieDao()
////
////            movieDao.deleteAll()
////
////            val movieOne = Movie(title = "MovieMovie", image = "", overview = "")
////
////            movieDao.insert(movieOne)
////        }
////    }
////}
