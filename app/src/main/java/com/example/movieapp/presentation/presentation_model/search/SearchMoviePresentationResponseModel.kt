package com.example.movieapp.presentation.presentation_model.search

import com.example.movieapp.data.models.search.search_model.MovieSearchModel
import com.example.movieapp.domain.domain_models.search.SearchMovieDomainResponseModel
import java.io.Serializable

data class SearchMoviePresentationResponseModel(
    val result: List<MovieSearchModel>
) : Serializable {
    companion object {
        val unknown = SearchMovieDomainResponseModel(
            result = emptyList()
        )
    }
}