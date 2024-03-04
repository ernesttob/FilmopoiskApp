package com.example.movieapp.presentation.screens.details_screen

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.movieapp.presentation.navigation.Destination

object DetailDestination : Destination {
    override val route: String
        get() = "detail_screen"

    const val movieId = "movieId"
    val routeWithArgs = "$route/{$movieId}"

    val arguments = listOf(navArgument(movieId) { type = NavType.IntType })
}