package com.example.movieapp.domain.use_cases.top_rated

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.models.main.ResultsMovieDomainModel
import com.example.movieapp.domain.repository.MovieListDataRepository
import javax.inject.Inject

class DefaultTopRatedMovieList @Inject constructor(
    private val repository: MovieListDataRepository
) : GetTopRatedMovieList {
    override suspend fun invoke(): ResultStatus<List<ResultsMovieDomainModel>> {
        return repository.getTopRatedMovieList()
    }
}