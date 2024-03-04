package com.example.movieapp.data.remote

import com.example.movieapp.data.models.info.MovieInfoModel
import com.example.movieapp.data.models.main.MovieListModel
import com.example.movieapp.data.models.reviews.MovieReviewsModel
import com.example.movieapp.data.models.search.search_model.MovieSearchModel
import com.example.movieapp.data.utils.Constants.FETCH_MOVIE_INFO
import com.example.movieapp.data.utils.Constants.GET_MOVIE_REVIEWS
import com.example.movieapp.data.utils.Constants.GET_NOW_PLAYING_MOVIES
import com.example.movieapp.data.utils.Constants.GET_POPULAR_MOVIES
import com.example.movieapp.data.utils.Constants.GET_SEARCH
import com.example.movieapp.data.utils.Constants.GET_TOP_RATED_MOVIES
import com.example.movieapp.data.utils.Constants.GET_UPCOMING_MOVIES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieService {

    @GET(GET_TOP_RATED_MOVIES)
    suspend fun getTopRatedMovieList(
        @Query("language") language: String = "en"
    ): Response<MovieListModel>

    @GET(FETCH_MOVIE_INFO)
    suspend fun getMovieInfo(
        @Path("movie_id") movieId: Int,
    ):Response<MovieInfoModel>

    @GET(GET_MOVIE_REVIEWS)
    suspend fun getMovieReviews(
        @Path("movie_id") movieId: Int
    ):Response<MovieReviewsModel>

    @GET(GET_POPULAR_MOVIES)
    suspend fun getPopularMovieList(
        @Query("language") language: String = "en"
    ): Response<MovieListModel>

    @GET(GET_NOW_PLAYING_MOVIES)
    suspend fun getNowPlayingMovieList(
        @Query("language") language: String = "en"
    ): Response<MovieListModel>

    @GET(GET_UPCOMING_MOVIES)
    suspend fun getUpcomingMovieList(
        @Query("language") language: String = "en"
    ): Response<MovieListModel>

    @GET(GET_SEARCH)
    suspend fun getKinofySearch(
        @Query("page") page: String = GET_SEARCH,
        @Query("query") searchQuery: String,
    ): Response<MovieSearchModel>


}