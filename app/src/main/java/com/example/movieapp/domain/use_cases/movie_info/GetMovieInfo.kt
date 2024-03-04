package com.example.movieapp.domain.use_cases.movie_info

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.info.MovieInfoModelDomain

interface GetMovieInfo {

    suspend operator fun invoke(movieId: Int): ResultStatus<MovieInfoModelDomain>

}