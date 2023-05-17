package com.example.newapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.newapi.module.detail.DetailScreen
import com.example.newapi.module.main.MainScreen
import com.example.newapi.network.NetworkServiceHolder

import com.example.newapi.ui.theme.NewAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(topBar = {}
                    ) { paddingValues ->
                        val navController = rememberNavController()
                        val service = NetworkServiceHolder.getInstance()
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Main.route,
                            Modifier.padding(paddingValues)
                        ) {
                            composable(Screen.Main.route) {
                                MainScreen(
                                    service = service
                                ) {
                                    id ->
                                    navController.navigate(Screen.Detail.route.replace("{id}", id.toString()))
                                }
                            }
                            composable(Screen.Detail.route) {
                                DetailScreen(service = service, movieId = it.arguments?.getString("id")!!.toLong())
                            }

                        }


                    }



//                    val owner = LocalViewModelStoreOwner.current
//
//                    owner?.let {
//                        val viewModel: MovieViewModel = viewModel(
//                            it,
//                            "MovieViewModel",
//                            MovieViewModelFactory(
//                                LocalContext.current.applicationContext
//                                        as Application
//                            )
//                        )
//
//                        ScreenSetup(viewModel)
//                    }
                    //MainScreen(service = NetworkServiceHolder.getInstance())
                    //DBScreen()
                }
            }
        }
    }
}
sealed class Screen(val route: String) {
    object Main: Screen("main")
    object Detail: Screen("datail/{id}")
}


//@Composable
//fun ScreenSetup(viewModel: MovieViewModel) {
//
//    val allMovies by viewModel.allMovies.observeAsState(listOf())
//    val searchResults by viewModel.searchResults.observeAsState(listOf())
//
//    MovieScreen(
//        allMovies = allMovies,
//        searchResults = searchResults,
//        viewModel = viewModel
//    )
//}

//@Composable
//fun MovieScreen(
//    allMovies: List<Movie2>,
//    searchResults: List<Movie2>,
//    viewModel: MovieViewModel
//) {
//    var title by remember { mutableStateOf("") }
//    var searching by remember { mutableStateOf(false) }
//
//    val onMovieTextChange = { text: String ->
//        title = text
//    }
//
//    Column(
//        horizontalAlignment = CenterHorizontally,
//        modifier = Modifier
//            .fillMaxWidth()
//    ) {
//        CustomTextField(
//            title = "Title",
//            textState = title,
//            onTextChange = onMovieTextChange,
//            keyboardType = KeyboardType.Text
//        )
//
//        Row(
//            horizontalArrangement = Arrangement.SpaceEvenly,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp)
//        ) {
//            Button(onClick = {
//                viewModel.insertMovie(
//                    Movie2(
//                        id = 1,
//                        title,
//                        image = "",
//                        overview = ""
//                    )
//                )
//                searching = false
//            }) {
//                Text("Добавить")
//            }
//
//            Button(onClick = {
//                searching = true
//                viewModel.findMovie(title)
//            }) {
//                Text("Поиск")
//            }
//
//            Button(onClick = {
//                searching = false
//                viewModel.deleteMovie(title)
//            }) {
//                Text("Удалить")
//            }
//
//            Button(onClick = {
//                searching = false
//                title = ""
//            }) {
//                Text("Очистить")
//            }
//        }
//    }
//
//    LazyColumn(
//        Modifier
//            .fillMaxWidth()
//            .padding(10.dp)
//    ) {
//        val list = if (searching) searchResults else allMovies
//
//        item {
//            DBScreen(row1 = "ID", row2 = "Фильм")
//        }
//
//        items(list) {movie ->
//            MovieRow(id = movie.id, title = movie.title)
//        }
//
//    }
//}