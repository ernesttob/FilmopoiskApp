package com.example.movieapp.presentation.presentation_model.movie

import androidx.compose.runtime.Stable
import com.example.movieapp.domain.domain_models.models.main.ResultsMovieDomainModel
import java.io.Serializable

@Stable
data class MoviePresentationModel(
    val backdropPath: String,
    val genreIds: List<Int>,
    val movieId: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int,
) : Serializable {
    companion object {
        val unknown = ResultsMovieDomainModel(
            backdropPath = "",
            genreIds = listOf(0),
            movieId = 0,
            originalLanguage = "",
            originalTitle = "",
            overview = "",
            popularity = 0.0,
            posterPath = "",
            releaseDate = "",
            title = "",
            voteAverage = 0.0,
            voteCount = 0,
        )
    }
}