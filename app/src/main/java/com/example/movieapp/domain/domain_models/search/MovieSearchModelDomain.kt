package com.example.movieapp.domain.domain_models.search

import com.example.movieapp.data.models.search.base_search_models.MovieSearchDataModel
import com.example.movieapp.data.models.search.search_model.MovieSearchModelData

data class MovieSearchModelDomain(
    val page: Int,
    val results: List<MovieSearchDataModel>,
    val totalPages: Int,
    val totalResults: Int
)