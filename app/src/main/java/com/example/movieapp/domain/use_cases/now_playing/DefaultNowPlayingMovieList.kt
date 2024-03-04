package com.example.movieapp.domain.use_cases.now_playing

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.models.main.ResultsMovieDomainModel
import com.example.movieapp.domain.repository.MovieListDataRepository
import javax.inject.Inject

class DefaultNowPlayingMovieList @Inject constructor(
    private val repository: MovieListDataRepository
):GetNowPlayingMovieList {
    override suspend fun invoke(): ResultStatus<List<ResultsMovieDomainModel>> {
        return repository.getNowPlayingMovieList()
    }
}