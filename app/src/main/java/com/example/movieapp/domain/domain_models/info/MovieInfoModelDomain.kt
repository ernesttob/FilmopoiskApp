package com.example.movieapp.domain.domain_models.info

import com.example.movieapp.data.models.info.BelongsToCollection
import com.example.movieapp.data.models.info.Genre
import com.example.movieapp.data.models.info.ProductionCompany
import com.example.movieapp.data.models.info.ProductionCountry
import com.example.movieapp.data.models.info.SpokenLanguage
import java.io.Serializable

data class MovieInfoModelDomain(
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
) : Serializable