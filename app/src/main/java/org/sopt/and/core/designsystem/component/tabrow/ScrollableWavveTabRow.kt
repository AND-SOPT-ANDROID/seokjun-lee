package org.sopt.and.core.designsystem.component.tabrow

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.sopt.and.core.designsystem.theme.WavveBackground

@Composable
fun ScrollableWavveTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = WavveBackground,
    tabTitles: List<Int> = emptyList(),
    indicator: @Composable (List<TabPosition>) -> Unit = {},
    content: @Composable RowScope.(Int, Int) -> Unit = { _, _ -> }
) {
    val scrollState = rememberScrollState()
    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = containerColor,
        modifier = modifier,
        divider = {},
        indicator = indicator
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.horizontalScroll(scrollState).padding(horizontal = 20.dp)
        ){
            tabTitles.forEachIndexed { index, tab ->
                content(index, tab)
            }
        }

    }
}
