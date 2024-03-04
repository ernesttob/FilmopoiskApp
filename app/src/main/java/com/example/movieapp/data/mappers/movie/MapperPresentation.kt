package com.example.movieapp.data.mappers.movie

import com.example.movieapp.domain.domain_models.models.main.MovieListDomainModel
import com.example.movieapp.domain.domain_models.models.main.ResultsMovieDomainModel
import com.example.movieapp.presentation.presentation_model.movie.MoviePresentationModel
import com.example.movieapp.presentation.presentation_model.movie.MovieResponsePresentationModel


fun ResultsMovieDomainModel.toUiModel() = MoviePresentationModel(
    backdropPath = backdropPath,
    genreIds = genreIds,
    movieId = movieId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    voteAverage = voteAverage,
    voteCount = voteCount,
)

fun MovieListDomainModel.toUiModel() = MovieResponsePresentationModel(
    results = result.map { it.toUiModel() }
)