package org.sopt.and.presentation.home.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.core.designsystem.component.tabrow.ScrollableWavveTabRow
import org.sopt.and.core.designsystem.component.tabrow.WavveTabRow
import org.sopt.and.core.designsystem.theme.Grey350
import org.sopt.and.core.designsystem.theme.White
import org.sopt.and.core.extension.noRippleClickable
import org.sopt.and.core.type.HomeTabType

@Composable
fun HomeTabRow(
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    selectedColor: Color = White,
    unselectedColor: Color = Grey350,
) {
    ScrollableWavveTabRow(
        tabTitles = HomeTabType.entries.map { it.titleRes }.toList(),
        selectedTabIndex = selectedTabIndex,
        modifier = modifier
    ) { index, tab ->
        Text(
            text = stringResource(tab),
            color = if (selectedTabIndex == index) selectedColor
            else unselectedColor,
            modifier = Modifier
                .wrapContentWidth()
                .noRippleClickable { onTabClick(index) }
                .padding(vertical = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WavveTabRowPreview() {
    HomeTabRow(
        selectedTabIndex = 0,
        onTabClick = {},
        modifier = Modifier.wrapContentSize()
    )
}