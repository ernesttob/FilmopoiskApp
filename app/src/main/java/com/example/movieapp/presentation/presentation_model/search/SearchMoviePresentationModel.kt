package com.example.movieapp.presentation.presentation_model.search

import androidx.compose.runtime.Stable
import com.example.movieapp.data.utils.Constants.EMPTY_STRING
import java.io.Serializable

@Stable
data class SearchMoviePresentationModel(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
) : Serializable {
    companion object {
        val unknown = SearchMoviePresentationModel(
            adult = false,
            backdropPath = EMPTY_STRING,
            genreIds = listOf(0),
            id = 0,
            originalLanguage = EMPTY_STRING,
            originalTitle = EMPTY_STRING,
            overview = EMPTY_STRING,
            popularity = 0.0,
            posterPath = EMPTY_STRING,
            releaseDate = EMPTY_STRING,
            title = EMPTY_STRING,
            video = false,
            voteAverage = 0.0,
            voteCount = 0
        )
    }
}
