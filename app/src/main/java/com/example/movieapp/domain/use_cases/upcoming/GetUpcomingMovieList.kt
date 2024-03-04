package com.example.movieapp.domain.use_cases.upcoming

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.models.main.ResultsMovieDomainModel

interface GetUpcomingMovieList {

    suspend operator fun invoke (): ResultStatus<List<ResultsMovieDomainModel>>

}