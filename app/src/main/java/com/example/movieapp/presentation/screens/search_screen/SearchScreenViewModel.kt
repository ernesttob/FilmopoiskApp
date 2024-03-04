package com.example.movieapp.presentation.screens.search_screen

import androidx.lifecycle.ViewModel
import com.example.movieapp.domain.use_cases.search.DefaultGetMovieSearchImpl
import com.example.movieapp.domain.use_cases.search.GetMovieSearch
import com.example.movieapp.presentation.screens.main_screen.MainScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val getMovieSearch: DefaultGetMovieSearchImpl
):ViewModel() {

    private val _uiState: MutableStateFlow<SearchScreenUiState> =
        MutableStateFlow(SearchScreenUiState.Loading)
    val uiState: StateFlow<SearchScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, throwable -> }


}