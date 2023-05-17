package com.example.newapi.module.detail

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.example.newapi.common.BASE_URL
import com.example.newapi.common.IMAGE_URL_FORMAT
import com.example.newapi.network.NetWorkService
import com.example.newapi.ui.theme.Shapes

@Composable
fun DetailScreen(
    service: NetWorkService,
    movieId: Long
) {
    val repository = DetailRepository(service)
    val viewModel = DetailViewModel(repository)


    //val movie = viewModel.movie.observeAsState()
    val movie = viewModel.movie.collectAsState(null)
    viewModel.getMovie(movieId)
    Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 12.dp)
    ) {
        if (movie.value != null) {
            val info = movie.value!!
            Card(modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
            ) {
                AsyncImage(model = String.format(IMAGE_URL_FORMAT, info.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop)
            }
            Column(Modifier.padding(horizontal = 16.dp)) {
                TextComponent(text = info.title)
                TextComponent(text = info.tagline)
                TextComponent(text = info.overview)
                LazyRowComponent(list = info.listNameLanguages) {
                    Text(text = it.nameLanguage, modifier = Modifier.padding(4.dp))
                }
                LazyRowComponent(list = info.genres) {
                    Text(text = it.name, modifier = Modifier.padding(4.dp))
                }
                TextComponent(text = info.releaseDate)

                Button(onClick = {  }) {
                    TextComponent(text = info.homepage)
                    WebViewContent()
                }

            }
        }
    }
}

@Composable
fun TextComponent(text: String, style: TextStyle = LocalTextStyle.current) {
    Spacer(modifier = Modifier.size(10.dp))
    Text(text = text, style = style)

}

@Composable
fun<T> LazyRowComponent(list: List<T>, content: @Composable (T) -> Unit) {
    Spacer(modifier = Modifier.size(10.dp))
    LazyRow {
        items(list) {
            Card(shape = Shapes.small) {
                content(it)
            }
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}

@Composable
fun WebViewContent(){

    val url = BASE_URL

    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}