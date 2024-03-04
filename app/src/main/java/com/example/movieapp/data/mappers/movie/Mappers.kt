package com.example.movieapp.data.mappers.movie

import com.example.movieapp.data.models.main.MovieListModel
import com.example.movieapp.data.models.main.ResultsMovieModel
import com.example.movieapp.domain.domain_models.models.main.MovieListDomainModel
import com.example.movieapp.domain.domain_models.models.main.ResultsMovieDomainModel

fun ResultsMovieModel.toDomainModel() = ResultsMovieDomainModel(
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

fun MovieListModel.toDomainModel() = MovieListDomainModel(
    result = result.map { it.toDomainModel() }
)



