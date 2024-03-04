package com.example.movieapp.presentation.presentation_model.info

import com.example.movieapp.data.models.info.BelongsToCollection
import com.example.movieapp.data.models.info.Genre
import com.example.movieapp.data.models.info.ProductionCompany
import com.example.movieapp.data.models.info.ProductionCountry
import com.example.movieapp.data.models.info.SpokenLanguage
import java.io.Serializable

data class MovieInfoModelPresentation(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: List<BelongsToCollection>,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
) : Serializable {
    companion object {
        val unknown = MovieInfoModelPresentation(
            adult = false,
            backdropPath = "",
            belongsToCollection = listOf(),
            budget = 0,
            genres = listOf(),
            homepage = "",
            id = 0,
            imdbId = "",
            originalLanguage = "",
            originalTitle = "",
            overview = "",
            popularity = 0.0,
            posterPath = "",
            productionCompanies = listOf(),
            productionCountries = listOf(),
            releaseDate = "",
            revenue = 0,
            runtime = 0,
            spokenLanguages = listOf(),
            status = "",
            tagline = "",
            title = "title",
            video = false,
            voteAverage = 0.0,
            voteCount = 0,

            )
    }
}