package com.example.movieapp.presentation.components

import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants
import com.example.movieapp.presentation.presentation_model.movie.MoviePresentationModel
import com.example.movieapp.presentation.theme.PurpleForText
import com.example.movieapp.presentation.theme.YellowForStar

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    model: MoviePresentationModel,
    onNavigateToInfo: (Int) -> Unit
) {
    val voteAverage = (model.voteAverage).toInt()
    Box(
        modifier = modifier
            .padding(
                top = 8.dp,
                end = 8.dp,
                bottom = 8.dp
            )
            .clickable { onNavigateToInfo(model.movieId) }
    ) {
        Column {
            Card(
                modifier = Modifier
                    .height(200.dp)
                    .width(150.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                AsyncImage(
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
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(start = 7.dp)
                        .fillMaxWidth()
                )
            } else {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 7.dp),
                    text = model.title,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = modifier.fillMaxWidth()
            ) {
                Icon(
                    modifier = modifier.size(20.dp),
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = YellowForStar
                )
                Text(
                    modifier = modifier
                        .fillMaxSize()
                        .align(Alignment.CenterVertically),
                    text = "$voteAverage",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Black
                )
                Text(
                    modifier = modifier.padding(top = 1.dp, start = 1.dp),
                    text = stringResource(R.string.playd_txt),
                    color = PurpleForText,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                )
            }
        }
    }
}

