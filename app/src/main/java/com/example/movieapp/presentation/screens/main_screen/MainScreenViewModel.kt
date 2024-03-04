package com.example.movieapp.presentation.screens.main_screen

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.base.models.ResponseStatus
import com.example.movieapp.data.mappers.movie.toUiModel
import com.example.movieapp.domain.use_cases.now_playing.DefaultNowPlayingMovieList
import com.example.movieapp.domain.use_cases.popular.DefaultPopularMovieList
import com.example.movieapp.domain.use_cases.top_rated.DefaultTopRatedMovieList
import com.example.movieapp.domain.use_cases.upcoming.DefaultUpcomingMovieList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getPopularMoviesDataUseCase: DefaultPopularMovieList,
    private val getNowPlayingMoviesDataUseCase: DefaultNowPlayingMovieList,
    private val getTopRatedMoviesDataUseCase: DefaultTopRatedMovieList,
    private val getUpcomingMoviesDataUseCase: DefaultUpcomingMovieList,
) : ViewModel() {

    private val _uiState: MutableStateFlow<MainScreenUiState> =
        MutableStateFlow(MainScreenUiState.Loading)
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, throwable -> }

    init {
        fetchMovies()
    }

    fun fetchMovies() {
        viewModelScope.launch(handle + Dispatchers.IO) {
            val popularResponse = getPopularMoviesDataUseCase()
            val upcomingResponse = getUpcomingMoviesDataUseCase()
            val nowPLayingResponse = getNowPlayingMoviesDataUseCase()
            val topRatedResponse = getTopRatedMoviesDataUseCase()
            if (
                popularResponse.status == ResponseStatus.SUCCESS &&
                topRatedResponse.status == ResponseStatus.SUCCESS &&
                upcomingResponse.status == ResponseStatus.SUCCESS &&
                nowPLayingResponse.status == ResponseStatus.SUCCESS
            ) {
                _uiState.update {
                    MainScreenUiState.Success(
                        moviePopular = popularResponse.data?.map { it.toUiModel() }
                            ?: emptyList(),
                        movieUpcoming = upcomingResponse.data?.map { it.toUiModel() }
                            ?: emptyList(),
                        movieTopRated = topRatedResponse.data?.map { it.toUiModel() }
                            ?: emptyList(),
                        movieNowPlaying = nowPLayingResponse.data?.map { it.toUiModel() }
                            ?: emptyList(),
                    )
                }
            } else {
                topRatedResponse.errorThrowable?.message?.let { topRated ->
                    upcomingResponse.errorThrowable?.message?.let { upcoming ->
                        nowPLayingResponse.errorThrowable?.message?.let { nowPlaying ->
                            popularResponse.errorThrowable?.message?.let { popular ->
                                if (popularResponse == UnknownHostException()
                                    && topRatedResponse == UnknownHostException()
                                    && upcomingResponse == UnknownHostException()
                                    && nowPLayingResponse == UnknownHostException()
                                ){
                                    _uiState.update {
                                        MainScreenUiState.Error(
                                            topRatedMessage = topRated,
                                            upcomingMessage = upcoming,
                                            nowPlayingMessage = nowPlaying,
                                            popularMessage = popular,
                                            isErrorWithConnection = true
                                        )
                                    }
                                } else {
                                    _uiState.update {
                                        MainScreenUiState.Error(
                                            topRatedMessage = topRated,
                                            upcomingMessage = upcoming,
                                            nowPlayingMessage = nowPlaying,
                                            popularMessage = popular,
                                            isErrorWithConnection = false
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
