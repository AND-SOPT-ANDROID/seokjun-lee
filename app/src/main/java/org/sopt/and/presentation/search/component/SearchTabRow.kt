package org.sopt.and.presentation.search.component

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.core.designsystem.component.tabrow.WavveTabRow
import org.sopt.and.core.designsystem.theme.Grey350
import org.sopt.and.core.designsystem.theme.White
import org.sopt.and.core.extension.noRippleClickable
import org.sopt.and.core.type.SearchTabType

@Composable
fun SearchTabRow(
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
    selectedColor: Color = White,
    unselectedColor: Color = Grey350,
    indicatorColor: Color = Color.Blue
) {
    WavveTabRow(
        tabTitles = SearchTabType.entries.map { it.titleRes },
        selectedTabIndex = selectedTabIndex,
        indicator = { tabPositions ->
            Log.d("tabRow", "selectedtab: $selectedTabIndex, tabPositions: ${tabPositions.size}")
            if(selectedTabIndex < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    color = indicatorColor,
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .padding(horizontal = 20.dp)
                )
            }
        }
    ) { index, tab ->
        Column(
            modifier = Modifier
                .noRippleClickable { onTabClick(index) },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(tab),
                textAlign = TextAlign.Center,
                color = if (selectedTabIndex == index) selectedColor
                else unselectedColor,
            )

            Spacer(modifier = Modifier.height(10.dp))

            /*
            if (selectedTabIndex == index) {
                HorizontalDivider(
                    thickness = 3.dp,
                    color = indicatorColor,
                    modifier = Modifier.width(70.dp)
                )
            }*/
        }


    }
}

@Preview(showBackground = true)
@Composable
private fun SearchTabRowPreview() {
    SearchTabRow(
        selectedTabIndex = 0,
        onTabClick = {}
    )
}
