package com.example.movieapp.domain.use_cases.search

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.search.SearchMovieDomainModel

interface GetMovieSearch {

    suspend operator fun invoke(query: String):ResultStatus<List<SearchMovieDomainModel>>

}