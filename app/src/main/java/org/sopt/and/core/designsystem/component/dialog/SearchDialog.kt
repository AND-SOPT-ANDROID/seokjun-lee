package org.sopt.and.core.designsystem.component.dialog

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.and.R
import org.sopt.and.core.data.repositoryimpl.DummyPopularProgramRepositoryImpl
import org.sopt.and.core.designsystem.component.BasicPreview
import org.sopt.and.core.designsystem.theme.Grey500
import org.sopt.and.core.extension.noRippleClickable
import org.sopt.and.core.model.Program
import org.sopt.and.presentation.search.component.SearchItem

@Composable
fun SearchDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    onItemSelect: (Program) -> Unit = {},
    programList: List<Program> = DummyPopularProgramRepositoryImpl.dummyPopularSeries
) {
    BasicDialog(
        onDismissRequest = onDismissRequest,
        title = stringResource(R.string.dialog_search_title),
        modifier = modifier.height(400.dp)
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 10.dp)
        ) {
            itemsIndexed(programList) { index, program ->
                SearchItem(
                    text = program.title,
                    contentDescription = program.title,
                    imageFile = program.imgFile,
                    modifier = Modifier
                        .height(50.dp)
                        .noRippleClickable {
                            onItemSelect(program)
                            onDismissRequest()
                        }
                )

                if (index < programList.size - 1)
                    HorizontalDivider(modifier = Modifier.padding(vertical = 6.dp), color = Grey500)
            }
        }

    }
}

@BasicPreview
@Composable
private fun SearchDialogPreview() {
    SearchDialog(
        programList = DummyPopularProgramRepositoryImpl.dummyPopularMovies
    )
}