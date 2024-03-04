package com.example.movieapp.presentation.screens.main_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.movieapp.presentation.screens.main_screen.components.ErrorScreen
import com.example.movieapp.presentation.screens.main_screen.components.LoadedNavigation
import com.example.movieapp.presentation.screens.main_screen.components.LoadingScreen
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel,
    uiState: StateFlow<MainScreenUiState>,
    onBackPressedCallBack: () -> Unit,
    onNavigateToInfo: (Int) -> Unit,
    onClickSearch:() -> Unit
) {
    when (val uiStateFlow = uiState.collectAsState().value) {
        is MainScreenUiState.Loading -> {
            LoadingScreen()
        }

        is MainScreenUiState.Success -> {
            LoadedNavigation(
                uiState = uiStateFlow,
                onBackPressedCallBack = onBackPressedCallBack,
                onNavigateToInfo = onNavigateToInfo,
                onClickSearch = onClickSearch
            )
        }

        is MainScreenUiState.Error -> {
            ErrorScreen(
                tryAgainCallBack = viewModel::fetchMovies
            )
        }
    }

}




