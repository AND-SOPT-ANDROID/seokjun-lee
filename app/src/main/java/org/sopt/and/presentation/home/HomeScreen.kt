package org.sopt.and.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.topbar.LogoTopBar
import org.sopt.and.core.extension.noRippleClickable
import org.sopt.and.core.type.HomeTabType
import org.sopt.and.presentation.home.component.HomeTabRow
import org.sopt.and.presentation.home.component.HorizontalBannerPager
import org.sopt.and.presentation.home.component.ProgramRow
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
        item {
            LogoTopBar(
                actions = listOf<@Composable () -> Unit> {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_live_24),
                        contentDescription = null,
                        modifier = Modifier.noRippleClickable { }
                    )
                }
            )
        }

        stickyHeader {
            HomeTabRow(
                homeTabs = HomeTabType.entries,
                selectedTabIndex = uiState.selectedTabIndex,
                onTabClick = onTabClick
            )
        }

        item {
            HorizontalBannerPager(
                imageList = uiState.bannerImgList,
                modifier = Modifier.wrapContentHeight()
            )
        }

        items(
            items = uiState.recommendations,
            key = { recommendation -> recommendation.title }) { recommendation ->
            Spacer(modifier = Modifier.height(20.dp))

            ProgramRow(
                title = recommendation.title,
                imageList = recommendation.imageList,
                modifier = Modifier.wrapContentHeight()
            )
        }
    }
}

