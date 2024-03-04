package com.example.movieapp.presentation.screens.details_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import com.example.movieapp.R
import com.example.movieapp.presentation.screens.details_screen.base.LoadedDetailScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.flow.StateFlow

@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel,
    uiState: StateFlow<DetailsScreenUiState>,
    onGetMovieInfo: () -> Unit,
    backToScreen: () -> Unit
) {

    val colorBackgroundLight = MaterialTheme.colorScheme.background
    val systemUiController = rememberSystemUiController()

    when (val uiStateFlow = uiState.collectAsState().value) {
        is DetailsScreenUiState.Loading -> {
            DetailLoadingScreen()
        }
        is DetailsScreenUiState.Success -> {
            LoadedDetailScreen(
                uiState = uiStateFlow,
                backToScreen = backToScreen
            )
        }
        is DetailsScreenUiState.Error -> {
            ErrorScreen(
                tryAgainCallBack = {
                    viewModel::fetchMovieInfo
                }
            )
        }
    }
    LaunchedEffect(key1 = true) {
        onGetMovieInfo()
    }

    SideEffect {
        systemUiController.setStatusBarColor(color = colorBackgroundLight)
        systemUiController.setNavigationBarColor(colorBackgroundLight)
    }
}


@Composable
fun ErrorScreen(
    tryAgainCallBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.no_connection),
                fontWeight = FontWeight.Medium,
                fontSize = 23.sp,
            )
            Button(
                shape = RoundedCornerShape(12.dp),
                onClick = {
                    tryAgainCallBack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.try_again),
                    color = MaterialTheme.colorScheme.background,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun DetailLoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}