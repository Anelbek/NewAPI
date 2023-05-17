package com.example.newapi.module.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newapi.model.request.response.Movie
import com.example.newapi.network.NetWorkService

@Composable
fun MainScreen(modifier: Modifier = Modifier, service: NetWorkService, onClick: (Long) -> Unit) {
    val repository = MainRepository(service)
    val viewModel = MainViewModel(repository)

    viewModel.getMovieList()

    val movies = viewModel.movies.observeAsState()

    if (movies.value != null) {

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            items(movies.value!!) {
                item -> 
                MovieCard(movie = item, modifier, onClick)

            }
        }
    }
}

@Composable
fun MovieCard(movie: Movie, modifier: Modifier,onClick: (Long) -> Unit) {

    Card(modifier = Modifier
        .fillMaxSize()
        .height(150.dp)
        .padding(10.dp)
        .clickable { onClick.invoke(movie.id) },
    shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)) {
                    AsyncImage(
                        model = String.format("https://image.tmdb.org/t/p/w500/%s", movie.image),
                        contentDescription = null,
                        modifier = Modifier.size(150.dp)
                    )

                    Column( modifier = Modifier.weight(1f)
                    ) {
                        Text(text = movie.title,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = movie.overview,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

        }

    }

}