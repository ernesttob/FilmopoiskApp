package com.example.movieapp.presentation.screens.details_screen.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Text
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants
import com.example.movieapp.presentation.presentation_model.info.MovieInfoModelPresentation
import com.example.movieapp.presentation.screens.details_screen.DetailsScreenUiState

@Composable
fun LoadedDetailScreen(
    uiState: DetailsScreenUiState.Success,
    modifier: Modifier = Modifier,
    backToScreen:() -> Unit
) {
    val iconColor = if (isSystemInDarkTheme()) {
        androidx.compose.ui.graphics.Color.White
    } else {
        androidx.compose.ui.graphics.Color.Black
    }
    val runTime = uiState.detailMovie.runtime
    val releaseDate = uiState.detailMovie.releaseDate
    val year = releaseDate.substring(0, 4)
    val model = uiState.detailMovie

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Row(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = modifier
                        .padding(10.dp)
                        .size(25.dp)
                        .clickable { backToScreen() },
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(iconColor)
                )
                Text(
                    modifier = modifier
                        .padding(start = 120.dp, top = 2.dp)
                        .align(Alignment.CenterVertically),
                    text = stringResource(R.string.detail),
                    fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    modifier = modifier
                        .padding(start = 125.dp)
                        .size(25.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(iconColor)
                )
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                AsyncImage(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .height(250.dp)
                        .fillMaxWidth(),
                    model = Constants.POSTER_PATH_URL + model.backdropPath,
                    placeholder = painterResource(id = R.drawable.loaded),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                )
                Card(
                    modifier = modifier
                        .padding(start = 28.dp)
                        .width(90.dp)
                        .height(160.dp)
                        .align(Alignment.TopStart)
                        .graphicsLayer {
                            translationY = 500f
                        },
                    shape = RoundedCornerShape(10.dp)
                ) {
                    AsyncImage(
                        modifier = Modifier,
                        model = Constants.POSTER_PATH_URL + model.posterPath,
                        placeholder = painterResource(id = R.drawable.loaded),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                    )
                }

                if (model.title.length > 14) {
                    val firstPart = model.title.take(14)
                    val secondPart = model.title.drop(14)

                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(firstPart)
                                append("\n")
                                append(secondPart)
                            }
                        },
                        fontSize = 24.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .graphicsLayer {
                                translationX = 110f
                                translationY = 190f
                            }
                            .align(Alignment.BottomCenter)
                    )
                } else {
                    Text(
                        modifier = modifier
                            .graphicsLayer {
                                translationX = 110f
                                translationY = 150f
                            }
                            .align(Alignment.BottomCenter),
                        text = model.title,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            }
            Row(
                modifier = modifier
                    .padding(top = 100.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = modifier
                        .padding(start = 40.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = R.drawable.date_svg),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(iconColor)
                )
                Text(
                    modifier = modifier
                        .padding(start = 3.dp)
                        .align(Alignment.CenterVertically),
                    text = "$year  |",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                )
                Image(
                    modifier = modifier
                        .padding(start = 10.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = R.drawable.time_svg),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(iconColor)
                )
                Text(
                    modifier = modifier
                        .padding(start = 3.dp)
                        .align(Alignment.CenterVertically),
                    text = "$runTime Minutes  |",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                )
                Image(
                    modifier = modifier
                        .padding(start = 10.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = R.drawable.ticket_svg),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(iconColor)
                )
                Text(
                    modifier = modifier
                        .padding(start = 3.dp)
                        .align(Alignment.CenterVertically),
                    text = "Action",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                )
            }
            TabRowDetailScreen(
                modifier = modifier
                .fillMaxWidth()
                .width(20.dp), uiState = uiState)
        }
    }
}
