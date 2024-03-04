package com.example.movieapp.domain.use_cases.reviews

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.reviews.MovieReviewsDomainModel

interface MovieReviewUseCase {

    suspend operator fun invoke(movieId: Int): ResultStatus<MovieReviewsDomainModel>

}