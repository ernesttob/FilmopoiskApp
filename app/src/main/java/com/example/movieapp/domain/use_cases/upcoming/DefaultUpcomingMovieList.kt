package com.example.movieapp.domain.use_cases.upcoming

import android.util.Log
import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.models.main.ResultsMovieDomainModel
import com.example.movieapp.domain.repository.MovieListDataRepository
import javax.inject.Inject

class DefaultUpcomingMovieList @Inject constructor(
    private val repository: MovieListDataRepository
): GetUpcomingMovieList {
    override suspend fun invoke(): ResultStatus<List<ResultsMovieDomainModel>> {
        return repository.getUpcomingMovieList()
    }
}