package org.sopt.and.core.designsystem.component.tabrow

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.sopt.and.core.designsystem.theme.WavveBackground

@Composable
fun WavveTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = WavveBackground,
    tabTitles: List<Int> = emptyList(),
    indicator: @Composable (List<TabPosition>) -> Unit = {},
    content: @Composable (Int, Int) -> Unit = { _, _ -> }
) {
    val scrollState = rememberScrollState()
    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = containerColor,
        modifier = modifier/*.horizontalScroll(scrollState)*/,
        divider = {},
        indicator = indicator
    ) {
        tabTitles.forEachIndexed { index, tab ->
            content(index, tab)
        }
    }
}
