package com.example.movieapp.domain.use_cases.popular

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.models.main.ResultsMovieDomainModel

interface GetPopularMovieList {

    suspend operator fun invoke(): ResultStatus<List<ResultsMovieDomainModel>>

}