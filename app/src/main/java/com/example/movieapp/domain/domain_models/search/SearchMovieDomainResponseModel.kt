package com.example.movieapp.domain.domain_models.search

import com.example.movieapp.data.models.search.base_search_models.MovieSearchDataModel
import com.example.movieapp.presentation.presentation_model.search.SearchMoviePresentationResponseModel
import java.io.Serializable

data class SearchMovieDomainResponseModel(
    val result: List<MovieSearchDataModel>
) : Serializable {
    companion object {
        val unknown = SearchMoviePresentationResponseModel(
            result = emptyList()
        )
    }
}