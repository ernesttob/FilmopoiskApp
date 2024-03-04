package com.example.movieapp.data.mappers.reviews

import com.example.movieapp.data.models.reviews.AuthorDetails
import com.example.movieapp.domain.domain_models.reviews.AuthorDetailsDomain
import com.example.movieapp.domain.domain_models.reviews.MovieReviewsDomainModel
import com.example.movieapp.data.models.reviews.MovieReviewsModel
import com.example.movieapp.data.models.reviews.ResultModel
import com.example.movieapp.domain.domain_models.reviews.ResultDomain
import com.example.movieapp.presentation.presentation_model.reviews.AuthorDetailsPresentation
import com.example.movieapp.presentation.presentation_model.reviews.MovieReviewsPresentationModel
import com.example.movieapp.presentation.presentation_model.reviews.ResultPresentation

fun AuthorDetails.toDomain() = AuthorDetailsDomain(
    avatarPath = avatarPath,
    name = name,
    rating = rating,
    username = username
)

fun MovieReviewsModel.toDomain() = MovieReviewsDomainModel(
    id = id,
    page = page,
    results = resultModels,
    totalPages = totalPages,
    totalResults = totalResults,
)

fun ResultModel.toDomain() = ResultDomain(
    author = author,
    authorDetails = authorDetails,
    content = content,
    createdAt = createdAt,
    id = id,
    updatedAt = updatedAt,
    url = url,
)

fun AuthorDetailsDomain.toUi() = AuthorDetailsPresentation(
    avatarPath = avatarPath,
    name = name,
    rating = rating,
    username = username
)

fun MovieReviewsDomainModel.toUi() = MovieReviewsPresentationModel(
    id = id,
    page = page,
    results = results,
    totalPages = totalPages,
    totalResults = totalResults,
)

fun ResultDomain.toUi() = ResultPresentation(
    author = author,
    authorDetails = authorDetails,
    content = content,
    createdAt = createdAt,
    id = id,
    updatedAt = updatedAt,
    url = url,
)