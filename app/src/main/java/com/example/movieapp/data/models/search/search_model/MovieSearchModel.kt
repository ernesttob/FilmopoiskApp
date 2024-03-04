package com.example.movieapp.data.models.search.search_model

import com.example.movieapp.data.models.search.base_search_models.MovieSearchDataModel
import com.google.gson.annotations.SerializedName

data class MovieSearchModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieSearchDataModel>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)