package org.sopt.and.presentation.home.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.core.designsystem.theme.Grey350
import org.sopt.and.core.designsystem.theme.Grey500
import org.sopt.and.core.designsystem.theme.White
import org.sopt.and.core.extension.noRippleClickable
import org.sopt.and.core.type.HomeTabType

@Composable
internal fun HomeTabBar(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    onTabClick: (Int) -> Unit = {},
    containerColor: Color = Grey500,
    selectedColor: Color = White,
    unselectedColor: Color = Grey350,
    homeTabs: List<HomeTabType> = emptyList(),
) {
    val scrollState = rememberScrollState()
    TabRow(
        selectedTabIndex = 0,
        containerColor = containerColor,
        modifier = modifier,
        divider = {},
        indicator = {}
    ) {
        Row(
            modifier = Modifier.horizontalScroll(scrollState)
        ) {
            homeTabs.forEachIndexed { index, tab ->
                Text(
                    text = stringResource(tab.titleRes),
                    color = if (selectedTabIndex == index) selectedColor
                    else unselectedColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentWidth()
                        .noRippleClickable { onTabClick(index) }
                        .padding(10.dp)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun HomeTabBarPreview() {
    HomeTabBar(
        homeTabs = HomeTabType.entries,
        selectedTabIndex = 0
    )
}