package com.example.movieapp.data.mappers.info

import com.example.movieapp.data.models.info.BelongsToCollection
import com.example.movieapp.data.models.info.Genre
import com.example.movieapp.data.models.info.MovieInfoModel
import com.example.movieapp.data.models.info.ProductionCompany
import com.example.movieapp.data.models.info.ProductionCountry
import com.example.movieapp.data.models.info.SpokenLanguage
import com.example.movieapp.domain.domain_models.info.BelongsToCollectionDomain
import com.example.movieapp.domain.domain_models.info.GenreDomain
import com.example.movieapp.presentation.presentation_model.info.BelongsToCollectionPresentation
import com.example.movieapp.presentation.presentation_model.info.GenrePresentation
import com.example.movieapp.domain.domain_models.info.MovieInfoModelDomain
import com.example.movieapp.domain.domain_models.info.ProductionCompanyDomain
import com.example.movieapp.domain.domain_models.info.ProductionCountryDomain
import com.example.movieapp.domain.domain_models.info.SpokenLanguageDomain
import com.example.movieapp.presentation.presentation_model.info.MovieInfoModelPresentation
import com.example.movieapp.presentation.presentation_model.info.ProductionCompanyPresentation
import com.example.movieapp.presentation.presentation_model.info.ProductionCountryPresentation
import com.example.movieapp.presentation.presentation_model.info.SpokenLanguagePresentation

fun BelongsToCollection.toDomainModel() = BelongsToCollectionDomain(
    backdropPath = backdropPath,
    id = id,
    name = name,
    posterPath = posterPath
)

fun Genre.toDomainModel() = GenreDomain(
    id = id,
    name = name
)

fun ProductionCompany.toDomainMode() = ProductionCompanyDomain(
    id = id,
    logoPath = logoPath,
    name = name,
    originCountry = originCountry
)

fun ProductionCountry.toDomainModel() = ProductionCountryDomain(
    name = name,
    iso31661 = iso31661
)

fun SpokenLanguage.toDomainModel() = SpokenLanguageDomain(
    englishName = englishName,
    name = name,
    iso6391 = iso6391
)

fun MovieInfoModel.toDomain() = MovieInfoModelDomain(
    adult = adult,
    backdropPath = backdropPath,
    belongsToCollection = listOf(belongsToCollection),
    budget = budget,
    genres = genres,
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies,
    productionCountries = productionCountries,
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages,
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
)

fun BelongsToCollectionDomain.toUiModel() = BelongsToCollectionPresentation(
    backdropPath = backdropPath,
    id = id,
    name = name,
    posterPath = posterPath
)

fun GenreDomain.toUiModel() = GenrePresentation(
    id = id,
    name = name
)

fun ProductionCompanyDomain.toUiModel() = ProductionCompanyPresentation(
    id = id,
    logoPath = logoPath,
    name = name,
    originCountry = originCountry
)

fun ProductionCountryDomain.toUiModel() = ProductionCountryPresentation(
    name = name,
    iso31661 = iso31661
)

fun SpokenLanguageDomain.toUiModel() = SpokenLanguagePresentation(
    englishName = englishName,
    name = name,
    iso6391 = iso6391
)

fun MovieInfoModelDomain.toUiModel() = MovieInfoModelPresentation(
    adult = adult,
    backdropPath = backdropPath,
    belongsToCollection = belongsToCollection,
    budget = budget,
    genres = genres,
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies,
    productionCountries = productionCountries,
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages,
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
)