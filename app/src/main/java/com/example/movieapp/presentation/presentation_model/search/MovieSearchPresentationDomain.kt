package com.example.movieapp.presentation.presentation_model.search

import com.example.movieapp.data.models.search.base_search_models.MovieSearchDataModel
import com.example.movieapp.data.models.search.search_model.MovieSearchModelData

data class MovieSearchPresentationDomain(
    val page: Int,
    val results: List<MovieSearchDataModel>,
    val totalPages: Int,
    val totalResults: Int
)