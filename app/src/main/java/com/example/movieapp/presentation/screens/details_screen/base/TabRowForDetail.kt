package com.example.movieapp.presentation.screens.details_screen.base

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants
import com.example.movieapp.presentation.screens.details_screen.DetailsScreenUiState
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRowDetailScreen(
    modifier: Modifier = Modifier,
    uiState: DetailsScreenUiState.Success
) {
    val listOfParts = listOf(
        "About Movie",
        "Reviews",
        "Cast"
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { listOfParts.size })

    val coroutineScope = rememberCoroutineScope()
    val defaultIndicator = @Composable { tabPositions: List<TabPosition> ->
        Box(
            modifier = modifier
                .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                .height(3.dp)
                .background(
                    color = Color.Gray
                ),
        )
    }
    Column(
        modifier = Modifier, verticalArrangement = Arrangement.Center
    ) {
        ScrollableTabRow(
            modifier = Modifier,
            selectedTabIndex = pagerState.currentPage,
            indicator = defaultIndicator,
            containerColor = Color.Transparent
        ) {
            listOfParts.forEachIndexed { index, _ ->
                Tab(text = {
                    Text(
                        text = listOfParts[index],
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }, selected = pagerState.currentPage == index, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                })
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
        ) { index ->
            when (index) {
                0 -> OverviewMovie(uiState = uiState)
                1 -> ReviewsMovie(uiState = uiState)
                2 -> CastMovie(uiState = uiState)
            }
        }
    }
}

@Composable
fun OverviewMovie(
    uiState: DetailsScreenUiState.Success,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .padding(horizontal = 18.dp)
            .padding(top = 10.dp),
        text = uiState.detailMovie.overview,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun ReviewsMovie(
    uiState: DetailsScreenUiState.Success,
) {
    val result = uiState.reviewsMovie.results.getOrNull(1)
    if (result != null) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.CenterHorizontally),
                model = result.authorDetails.avatarPath,
                placeholder = painterResource(id = R.drawable.loaded),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = result.authorDetails.username,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { }

            ClickableText(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = AnnotatedString(result.url),
                style = TextStyle(textDecoration = TextDecoration.Underline),
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(result.url)
                    launcher.launch(intent)
                }
            )
        }
    }
}

@Composable
fun CastMovie(
    uiState: DetailsScreenUiState.Success,
) {
    Text(
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .padding(top = 10.dp),
        text = "Cast",
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
}
