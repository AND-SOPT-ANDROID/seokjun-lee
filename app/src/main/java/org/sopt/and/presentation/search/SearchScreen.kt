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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.Grey500
import org.sopt.and.presentation.search.component.CategoryButton
import org.sopt.and.presentation.search.component.SearchItem
import org.sopt.and.presentation.search.component.SearchTabRow
import org.sopt.and.core.designsystem.component.textfield.SearchTextField
import org.sopt.and.core.model.Program
import org.sopt.and.presentation.search.state.SearchUiState

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SearchScreen(
        uiState = uiState,
        onTabClick = viewModel::onTabClick,
        programList = viewModel.getTabList(),
        onTextFieldValueChange = viewModel::onSearchValueChange,
        modifier = modifier
    )
}

@Composable
private fun SearchScreen(
    uiState: SearchUiState,
    onTabClick: (Int) -> Unit,
    onTextFieldValueChange: (String) -> Unit,
    programList: List<Program>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            SearchTextField(
                value = uiState.searchText,
                onValueChange = onTextFieldValueChange,
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
                selectedTabIndex = uiState.selectedTabIndex,
                onTabClick = onTabClick
            )

            LazyColumn(
                contentPadding = PaddingValues(vertical = 10.dp, horizontal = 10.dp)
            ) {
                items(programList) { program ->
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SearchItem(
                            text = program.title,
                            contentDescription = program.title,
                            imageFile = program.imgFile,
                            modifier = Modifier.height(80.dp)
                        )
                        HorizontalDivider(thickness = 1.dp, color = Grey500, modifier = Modifier.padding(10.dp))
                    }
                }
            }

        }
    }
}
