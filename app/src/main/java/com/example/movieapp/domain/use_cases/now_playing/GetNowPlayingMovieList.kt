package com.example.movieapp.domain.use_cases.now_playing

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.models.main.ResultsMovieDomainModel

interface GetNowPlayingMovieList {

    suspend operator fun invoke(): ResultStatus<List<ResultsMovieDomainModel>>

}