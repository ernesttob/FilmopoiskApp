package com.example.movieapp.presentation.screens.main_screen


import androidx.compose.runtime.Stable
import com.example.movieapp.presentation.presentation_model.movie.MoviePresentationModel
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenUiState {

    @Stable
    data class Success(
        val moviePopular: List<MoviePresentationModel>,
        val movieTopRated: List<MoviePresentationModel>,
        val movieUpcoming: List<MoviePresentationModel>,
        val movieNowPlaying: List<MoviePresentationModel>,
    ) : MainScreenUiState()

    data object Loading : MainScreenUiState()

    @Immutable
    data class Error(
        val topRatedMessage: String,
        val upcomingMessage: String,
        val nowPlayingMessage: String,
        val popularMessage: String,
        val isErrorWithConnection: Boolean
    ) : MainScreenUiState()

}
