package org.sopt.and.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.and.presentation.home.component.HomeTabRow
import org.sopt.and.presentation.home.component.HomeTopBar
import org.sopt.and.presentation.home.component.HorizontalBannerPager
import org.sopt.and.presentation.home.component.ProgramRow
import org.sopt.and.presentation.home.component.RankedProgramRow
import org.sopt.and.presentation.home.state.HomeUiState

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        uiState = uiState,
        modifier = modifier,
        onTabClick = viewModel::updateSelectedTabIndex
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeScreen(
    uiState: HomeUiState,
    onTabClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(bottom = 20.dp)
    ) {
        item { HomeTopBar() }

        stickyHeader {
            HomeTabRow(
                selectedTabIndex = uiState.selectedTabIndex,
                onTabClick = onTabClick
            )
        }

        item {
            HorizontalBannerPager(
                imageList = uiState.bannerImgList,
                modifier = Modifier.wrapContentHeight()
            )

            RankedProgramRow(
                title = uiState.rankedSeries?.title.orEmpty(),
                programList = uiState.rankedSeries?.programList.orEmpty(),
                modifier = Modifier.padding(top = 20.dp)
            )
        }

        items(
            items = uiState.recommendations,
            key = { recommendation -> recommendation.title }
        ) { recommendation ->
            ProgramRow(
                title = recommendation.title,
                programList = recommendation.programList,
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(top = 20.dp)
            )
        }
    }
}



