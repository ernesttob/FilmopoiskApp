package com.example.movieapp.domain.domain_models.reviews

import com.example.movieapp.data.models.reviews.ResultModel


data class MovieReviewsDomainModel(
    val id: Int,
    val page: Int,
    val results: List<ResultModel>,
    val totalPages: Int,
    val totalResults: Int
)