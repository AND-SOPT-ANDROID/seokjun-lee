package org.sopt.and.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.Black
import org.sopt.and.core.designsystem.theme.White

@Composable
internal fun HorizontalBannerPager(
    @DrawableRes imageList: List<Int>,
    modifier: Modifier = Modifier
) {
    val coroutine = rememberCoroutineScope()

    val pagerState = rememberPagerState(
        initialPage = 400,
        pageCount = { 800 }
    )

    LaunchedEffect(true) {
        while (true) {
            kotlinx.coroutines.delay(3000)
            coroutine.launch {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            }
        }
    }

    HorizontalPager(
        state = pagerState,
        beyondViewportPageCount = 1,
        modifier = modifier.height(450.dp),
        contentPadding = PaddingValues(horizontal = 24.dp), // 내부 페이지 패딩 설정
        pageSpacing = 12.dp // 페이지 사이의 간격
    ) { page ->
        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                painterResource(imageList[page % imageList.size]),
                contentDescription = stringResource(R.string.icon_banner_description),
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.BottomCenter
            )

            Text(
                text = stringResource(
                    id = R.string.home_banner_indicator,
                    formatArgs = arrayOf((page % imageList.size + 1), imageList.size)
                ),
                color = White,
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(12.dp)
                    .background(
                        color = Black.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(horizontal = 5.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HorizontalBannerPagerPreview() {
    HorizontalBannerPager(
        imageList = listOf(
            R.drawable.img_banner1,
            R.drawable.img_banner2,
            R.drawable.img_banner3,
            R.drawable.img_banner4,
        )
    )
}

