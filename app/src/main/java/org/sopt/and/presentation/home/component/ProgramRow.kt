package org.sopt.and.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.core.data.repositoryimpl.DummyPopularProgramRepositoryImpl
import org.sopt.and.core.designsystem.component.image.ProgramImage
import org.sopt.and.core.designsystem.theme.WavveBackground
import org.sopt.and.core.designsystem.theme.White
import org.sopt.and.core.extension.noRippleClickable
import org.sopt.and.core.model.Program

@Composable
fun ProgramRow(
    title: String,
    modifier: Modifier = Modifier,
    programList: List<Program> = emptyList(),
    contentColor: Color = White,
    onMoreClick: () -> Unit = {},
    onItemClick: (Int) -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = stringResource(R.string.icon_next_description),
                tint = contentColor,
                modifier = Modifier.noRippleClickable(onMoreClick)
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(programList) { index, program ->
                ProgramImage(
                    contentDescription = program.title,
                    imgRes = program.imgFile,
                    modifier = Modifier.noRippleClickable { onItemClick(index) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProgramRowPreview() {
    ProgramRow(
        title = "남의 삶을 훔쳐보는 공인중개사",
        programList = DummyPopularProgramRepositoryImpl.dummyPopularSeries,
        modifier = Modifier
            .background(WavveBackground)
            .wrapContentHeight()
    )
}