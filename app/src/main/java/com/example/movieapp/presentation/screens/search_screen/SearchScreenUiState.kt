package com.example.movieapp.presentation.screens.search_screen

import androidx.compose.runtime.Stable
import com.example.movieapp.presentation.presentation_model.search.SearchMoviePresentationModel
import javax.annotation.concurrent.Immutable

@Immutable
sealed class SearchScreenUiState {

    @Stable
    data class Success(
        val searchModel: List<SearchMoviePresentationModel>
    ) : SearchScreenUiState()

    data object Loading : SearchScreenUiState()

    @Immutable
    data class Error(
        val massage: String,
        val errorWithConnection: Boolean
    ) : SearchScreenUiState()

}