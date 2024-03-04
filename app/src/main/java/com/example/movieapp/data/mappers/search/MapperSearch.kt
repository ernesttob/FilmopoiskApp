package com.example.movieapp.data.mappers.search

import com.example.movieapp.data.models.search.base_search_models.MovieSearchDataModel
import com.example.movieapp.data.models.search.base_search_models.MovieSearchResponseDataModel
import com.example.movieapp.data.models.search.search_model.MovieSearchModel
import com.example.movieapp.data.models.search.search_model.MovieSearchModelData
import com.example.movieapp.domain.domain_models.search.MovieSearchDomainModel
import com.example.movieapp.domain.domain_models.search.MovieSearchModelDomain
import com.example.movieapp.domain.domain_models.search.SearchMovieDomainModel
import com.example.movieapp.domain.domain_models.search.SearchMovieDomainResponseModel
import com.example.movieapp.presentation.presentation_model.search.MovieSearchPresentationDomain
import com.example.movieapp.presentation.presentation_model.search.SearchMoviePresentationModel
import com.example.movieapp.presentation.presentation_model.search.SearchMoviePresentationResponseModel

fun MovieSearchDataModel.toDomain() = SearchMovieDomainModel(
    adult = adult,
    backdropPath = backdropPath,
    genreIds = genreIds,
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTaitl,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
)

fun MovieSearchResponseDataModel.toDomain() = SearchMovieDomainResponseModel(
    result = result
)

fun MovieSearchModelData.toDomain() = MovieSearchDomainModel(
    results = results
)

fun MovieSearchModel.toDomain() = MovieSearchModelDomain(
    page = page,
    results = results,
    totalPages = totalPages,
    totalResults = totalResults
)

fun SearchMovieDomainModel.toUi() = SearchMoviePresentationModel(
    adult = adult,
    backdropPath = backdropPath,
    genreIds = genreIds,
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
)

fun MovieSearchResponseDataModel.toUi() = MovieSearchResponseDataModel(
    result = result
)

fun MovieSearchDomainModel.toUi() = SearchMoviePresentationResponseModel(
    result = results
)

fun MovieSearchModelDomain.toUi() = MovieSearchPresentationDomain(
    page = page,
    results = results,
    totalPages = totalPages,
    totalResults = totalResults
)