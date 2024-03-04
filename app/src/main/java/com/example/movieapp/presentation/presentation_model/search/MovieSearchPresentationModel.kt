package com.example.movieapp.presentation.presentation_model.search

import com.example.movieapp.data.models.search.search_model.MovieSearchModel
import java.io.Serializable

data class MovieSearchPresentationModel(
    val results: List<MovieSearchModel>
) : Serializable