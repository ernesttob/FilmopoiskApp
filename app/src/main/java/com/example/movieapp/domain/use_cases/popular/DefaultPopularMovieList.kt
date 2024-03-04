package com.example.movieapp.domain.use_cases.popular

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.models.main.ResultsMovieDomainModel
import com.example.movieapp.domain.repository.MovieListDataRepository
import javax.inject.Inject

class DefaultPopularMovieList @Inject constructor(
    private val repository: MovieListDataRepository
):GetPopularMovieList {
    override suspend fun invoke(): ResultStatus<List<ResultsMovieDomainModel>> {
        return repository.getPopularMovieList()
    }
}