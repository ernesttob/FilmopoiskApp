package com.example.movieapp.presentation.screens.details_screen

import com.example.movieapp.presentation.presentation_model.info.MovieInfoModelPresentation
import com.example.movieapp.presentation.presentation_model.reviews.MovieReviewsPresentationModel
import javax.annotation.concurrent.Immutable

@Immutable
sealed class DetailsScreenUiState {

    @Immutable
    data class Success (
        val detailMovie: MovieInfoModelPresentation,
        val reviewsMovie: MovieReviewsPresentationModel
    ):DetailsScreenUiState()

    data object Loading: DetailsScreenUiState()

    @Immutable
    data class Error(
        val errorMessage:String,
        val isErrorWithConnection: Boolean
    ):DetailsScreenUiState()

}