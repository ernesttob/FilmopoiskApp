package com.example.movieapp.domain.use_cases.reviews

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.reviews.MovieReviewsDomainModel
import com.example.movieapp.domain.repository.MovieListDataRepository
import javax.inject.Inject

class DefaultMovieReviewsUseCaseImpl @Inject constructor(
    private val repository: MovieListDataRepository
) : MovieReviewUseCase {
    override suspend fun invoke(movieId: Int): ResultStatus<MovieReviewsDomainModel> {
        return repository.getMovieReviews(movieId)
    }
}