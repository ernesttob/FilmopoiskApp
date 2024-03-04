package com.example.movieapp.domain.use_cases.movie_info

import android.util.Log
import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.info.MovieInfoModelDomain
import com.example.movieapp.domain.repository.MovieListDataRepository
import javax.inject.Inject

class DefaultMovieInfo @Inject constructor(
    private val repository: MovieListDataRepository
) : GetMovieInfo {
    override suspend fun invoke(movieId: Int): ResultStatus<MovieInfoModelDomain> {
        return repository.getMovieInfoList(movieId = movieId)
    }
}