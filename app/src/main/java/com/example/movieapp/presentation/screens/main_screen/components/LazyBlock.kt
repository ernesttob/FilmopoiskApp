package com.example.movieapp.presentation.screens.main_screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp.presentation.components.MovieItem
import com.example.movieapp.presentation.presentation_model.movie.MoviePresentationModel

@Composable
fun LazyBlock(
    movieList: List<MoviePresentationModel>,
    modifier: Modifier = Modifier,
    onNavigateToInfo: (Int) -> Unit
) {
    LazyRow(
        modifier = modifier.padding(top = 10.dp)
    ) {
        items(
            items = movieList, key = { it.movieId }
        ) {
            MovieItem(
                model = it,
                onNavigateToInfo = onNavigateToInfo
            )
        }
    }
}