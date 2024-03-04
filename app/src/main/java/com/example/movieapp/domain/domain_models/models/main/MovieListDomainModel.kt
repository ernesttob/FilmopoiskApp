package com.example.movieapp.domain.domain_models.models.main

import java.io.Serializable

data class MovieListDomainModel(
    val result: List<ResultsMovieDomainModel>
): Serializable {
    companion object {
        val unknown = MovieListDomainModel(
            result = emptyList()
        )
    }
}
