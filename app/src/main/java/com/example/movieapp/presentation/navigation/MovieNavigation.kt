package com.example.movieapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.screens.details_screen.DetailDestination
import com.example.movieapp.presentation.screens.details_screen.DetailScreen
import com.example.movieapp.presentation.screens.details_screen.DetailScreenViewModel
import com.example.movieapp.presentation.screens.main_screen.HomeDestination
import com.example.movieapp.presentation.screens.main_screen.MainScreen
import com.example.movieapp.presentation.screens.main_screen.MainScreenViewModel
import com.example.movieapp.presentation.screens.search_screen.SearchDestination
import com.example.movieapp.presentation.screens.search_screen.SearchScreen
import com.example.movieapp.presentation.screens.search_screen.SearchScreenViewModel
import com.example.movieapp.presentation.screens.splash_screen.SplashDestination
import com.example.movieapp.presentation.screens.splash_screen.SplashScreen

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun MovieNavigation(
    onBackPressedCallBack: () -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SplashDestination.route
    ) {
        composable(SplashDestination.route) {
            SplashScreen(
                callbackScreen = { navController.navigate(HomeDestination.route) }
            )
        }
        composable(HomeDestination.route) {
            val viewModel: MainScreenViewModel = hiltViewModel()
            MainScreen(
                viewModel = viewModel,
                uiState = viewModel.uiState,
                onBackPressedCallBack = onBackPressedCallBack,
                onNavigateToInfo = { movieId ->
                    navController.navigate("${DetailDestination.route}/$movieId")
                },
                onClickSearch = {navController.navigate(SearchDestination.route)}
            )
        }
        composable(
            route = DetailDestination.routeWithArgs,
            arguments = DetailDestination.arguments
        ) { navBackStackEntry ->
            val movieId = navBackStackEntry.arguments?.getInt(DetailDestination.movieId) ?: 0
            val viewModel: DetailScreenViewModel = hiltViewModel()
            DetailScreen(
                onGetMovieInfo = {
                    viewModel.fetchMovieInfo(movieId)
                },
                viewModel = viewModel,
                uiState = viewModel.uiState,
                backToScreen = { navController.navigate(HomeDestination.route) }
            )
            composable(SearchDestination.route){
                val viewModel: SearchScreenViewModel = hiltViewModel()
                SearchScreen()
            }
        }
    }
}