package com.example.movieapp.presentation.screens.details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.models.ResponseStatus
import com.example.movieapp.data.mappers.info.toUiModel
import com.example.movieapp.data.mappers.reviews.toUi
import com.example.movieapp.domain.use_cases.movie_info.DefaultMovieInfo
import com.example.movieapp.domain.use_cases.reviews.DefaultMovieReviewsUseCaseImpl
import com.example.movieapp.presentation.presentation_model.info.MovieInfoModelPresentation
import com.example.movieapp.presentation.presentation_model.reviews.MovieReviewsPresentationModel
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
class DetailScreenViewModel @Inject constructor(
    private val getMovieInfo: DefaultMovieInfo,
    private val getMovieReviews: DefaultMovieReviewsUseCaseImpl
) : ViewModel() {

    private val _uiState: MutableStateFlow<DetailsScreenUiState> =
        MutableStateFlow(DetailsScreenUiState.Loading)
    val uiState: StateFlow<DetailsScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, throwable -> }

    fun fetchMovieInfo(movieId: Int) {
        viewModelScope.launch(handle + Dispatchers.IO) {
            val resultMovieInfo = getMovieInfo(movieId)
            val resultMovieReview = getMovieReviews(movieId)
            if (resultMovieInfo.status == ResponseStatus.SUCCESS) {
                _uiState.update {
                    DetailsScreenUiState.Success(
                        detailMovie = resultMovieInfo.data?.toUiModel()
                            ?: MovieInfoModelPresentation.unknown,
                        reviewsMovie = resultMovieReview.data?.toUi()
                            ?: MovieReviewsPresentationModel.unknown
                    )
                }
            } else {
                resultMovieInfo.errorThrowable?.message?.let { message ->
                    if (
                        resultMovieInfo == UnknownHostException()
                    ) {
                        _uiState.update {
                            DetailsScreenUiState.Error(
                                errorMessage = message,
                                isErrorWithConnection = true
                            )
                        }
                    } else {
                        _uiState.update {
                            DetailsScreenUiState.Error(
                                errorMessage = message,
                                isErrorWithConnection = false
                            )
                        }
                    }
                }
            }
        }
    }
}


