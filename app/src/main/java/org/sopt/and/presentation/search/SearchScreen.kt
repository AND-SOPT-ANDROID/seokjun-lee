package org.sopt.and.presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.Grey500
import org.sopt.and.core.designsystem.theme.White
import org.sopt.and.presentation.search.component.CategoryButton
import org.sopt.and.presentation.search.component.SearchItem
import org.sopt.and.presentation.search.component.SearchTabRow
import org.sopt.and.presentation.search.component.SearchTextField

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier
) {
    SearchScreen(
        modifier = modifier
    )
}

@Composable
private fun SearchScreen(
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf("") }
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var itemList by remember { mutableStateOf(listOf<String>()) }

    LaunchedEffect(selectedTabIndex) {
        when (selectedTabIndex) {
            0 -> {
                itemList = listOf("궁금한 이야기 Y", "나는 SOLO", "무한도전", "1박2일", "지구오락실", "용감무쌍 용수정", "여왕벌 게임", "돌싱글스", "꼬리에 꼬리를 무는 그날 이야기")
            }

            1 -> {
                itemList = listOf("국가대표", "올드보이", "기생충", "명탐정 코난", "택시운전사", "추격자", "조커", "시간을 달리는 소녀", "센과 치히로의 행방불명", "스파이더맨: 노 웨이 홈")
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            SearchTextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = stringResource(R.string.search_text_field_hint)
            )

            HorizontalDivider()

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                CategoryButton(
                    titleRes = R.string.search_button_series,
                    iconRes = R.drawable.ic_live_24,
                    contentDescriptionRes = R.string.search_button_series,
                    modifier = Modifier.weight(1f)
                )

                CategoryButton(
                    titleRes = R.string.search_button_movies,
                    iconRes = R.drawable.ic_movie_24,
                    contentDescriptionRes = R.string.search_button_movies,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            SearchTabRow(
                selectedTabIndex = selectedTabIndex,
                onTabClick = { selectedTabIndex = it }
            )

            LazyColumn(
                contentPadding = PaddingValues(vertical = 10.dp, horizontal = 10.dp)
            ) {
                items(itemList) { item ->
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SearchItem(
                            text = item,
                            contentDescription = item,
                            modifier = Modifier.height(80.dp)
                        )
                        HorizontalDivider(thickness = 1.dp, color = Grey500, modifier = Modifier.padding(10.dp))
                    }
                }
            }

        }
    }
}
