package com.example.movieapp.data.utils

object Constants {
    const val BASE_URL="https://api.themoviedb.org/3/"
    const val GET_NOW_PLAYING_MOVIES="movie/now_playing"
    const val GET_POPULAR_MOVIES="movie/popular"
    const val GET_TOP_RATED_MOVIES="movie/top_rated"
    const val GET_UPCOMING_MOVIES="movie/upcoming"
    const val GET_MOVIE_REVIEWS="movie/{movie_id}/reviews"
    const val API_KEY="eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyZmVlY2Y1N2IyOWU4NDJlM2Y1M2RhZDA0MDI1ODkwMiIsInN1YiI6IjY1Y2RmYWU3ZDhhZjY3MDE4NzkwMzhiNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.DnV1he41pHxlENq05o47e-CnH3zQBk0DV97MbCNpDIc"
    const val FETCH_MOVIE_INFO="movie/{movie_id}"
    const val EMPTY_STRING = ""
    const val POSTER_PATH_URL = "https://image.tmdb.org/t/p/original"
    const val POSTER = "https://image.tmdb.org/t/p/w342"
    const val GET_SEARCH = "movie/search"
}