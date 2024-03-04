package com.example.movieapp.domain.use_cases.search

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.search.SearchMovieDomainModel
import com.example.movieapp.domain.repository.MovieListDataRepository
import javax.inject.Inject

class DefaultGetMovieSearchImpl @Inject constructor(
    private val repository: MovieListDataRepository
):GetMovieSearch {
    override suspend fun invoke(query: String): ResultStatus<List<SearchMovieDomainModel>> {
        return repository.getMovieSearch(query)
    }
}