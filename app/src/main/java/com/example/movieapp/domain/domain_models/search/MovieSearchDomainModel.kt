package com.example.movieapp.domain.domain_models.search

import com.example.movieapp.data.models.search.search_model.MovieSearchModel
import java.io.Serializable

data class MovieSearchDomainModel(
    val results: List<MovieSearchModel>
) : Serializable