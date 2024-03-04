package com.example.movieapp.presentation.screens.main_screen.components

import android.annotation.SuppressLint
import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.example.movieapp.R
import com.example.movieapp.presentation.screens.main_screen.MainScreenUiState
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("AutoboxingStateCreation", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoadedNavigation(
    uiState: MainScreenUiState.Success,
    modifier: Modifier = Modifier,
    onBackPressedCallBack: () -> Unit,
    onNavigateToInfo: (Int) -> Unit,
    onClickSearch: () -> Unit
) {
    val navigationByItems = remember { NavigationBarItems.values() }
    var selectedIndex by remember { mutableStateOf(0) }
    val colorBackgroundLight = MaterialTheme.colorScheme.background
    val systemUiController = rememberSystemUiController()
    var text by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val onSearch: (String) -> Unit
    val backStackDispatchers = LocalOnBackPressedDispatcherOwner.current

    backStackDispatchers?.onBackPressedDispatcher?.addCallback {
        onBackPressedCallBack()
    }

    Scaffold(
        bottomBar = {
            AnimatedNavigationBar(
                modifier = modifier
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 8.dp)
                    .height(44.dp),
                selectedIndex = selectedIndex,
                cornerRadius = shapeCornerRadius(cornerRadius = 34.dp),
                ballAnimation = Parabolic(tween(300)),
                indentAnimation = Height(tween(300)),
                barColor = MaterialTheme.colorScheme.primary,
                ballColor = MaterialTheme.colorScheme.primary
            ) {
                navigationByItems.forEach { items ->
                    Box(
                        modifier = modifier
                            .fillMaxSize()
                            .noRippleClickable { selectedIndex = items.ordinal },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = modifier.size(26.dp),
                            imageVector = items.icon,
                            contentDescription = null,
                            tint = if (selectedIndex == items.ordinal) MaterialTheme.colorScheme.onPrimary
                            else MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }
            }
        }
    ) { _ ->
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = modifier.fillMaxSize()
                ) {
                    Card(
                        modifier = modifier
                            .padding(horizontal = 8.dp)
                            .padding(top = 10.dp, bottom = 10.dp)
                            .fillMaxWidth()
                            .height(30.dp)
                            .clickable {  },
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Image(
                            modifier = modifier
                                .padding(
                                    end = 4.dp,
                                    top = 2.dp
                                )
                                .align(Alignment.End),
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    }
                    SwipeList(movieList = uiState.movieNowPlaying)
                    Text(
                        modifier = modifier.padding(top = 25.dp, start = 18.dp),
                        text = stringResource(R.string.upcoming_txt),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Black,
                        fontSize = 25.sp,
                    )
                    LazyBlock(
                        modifier = modifier.padding(start = 18.dp),
                        movieList = uiState.movieUpcoming,
                        onNavigateToInfo = onNavigateToInfo
                    )
                    Text(
                        modifier = modifier.padding(top = 10.dp, start = 18.dp),
                        text = stringResource(R.string.popuar_txt),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Black,
                        fontSize = 25.sp,
                    )
                    LazyBlock(
                        modifier = modifier.padding(start = 18.dp),
                        movieList = uiState.moviePopular,
                        onNavigateToInfo = onNavigateToInfo
                    )
                    Text(
                        modifier = modifier.padding(top = 10.dp, start = 18.dp),
                        text = stringResource(R.string.top_rated_txt),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Black,
                        fontSize = 25.sp,
                    )
                    LazyBlock(
                        modifier = modifier.padding(start = 18.dp, bottom = 50.dp),
                        movieList = uiState.movieTopRated,
                        onNavigateToInfo = onNavigateToInfo
                    )

                }
            }
        }
    }
    SideEffect {
        systemUiController.setStatusBarColor(color = colorBackgroundLight)
        systemUiController.setNavigationBarColor(colorBackgroundLight)
    }
}

enum class NavigationBarItems(val icon: ImageVector) {
    Home(icon = Icons.Default.Home),
    Search(icon = Icons.Default.Search),
    Favorite(icon = Icons.Default.Favorite)
}

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}