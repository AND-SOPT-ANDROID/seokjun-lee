package org.sopt.and.presentation.mypage.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.core.designsystem.component.image.PressableProgramImage
import org.sopt.and.core.model.Program

@Composable
fun ContentList(
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier,
    list: List<Program> = emptyList(),
    onItemPress: (Program) -> Unit = {},
    titleColor: Color = Color.White,
    subTitleColor: Color = Color.Gray
) {

    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            color = titleColor,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 20.dp)
        )

        if (list.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "info",
                    tint = subTitleColor,
                    modifier = Modifier.size(60.dp)
                )

                Spacer(modifier = Modifier.size(10.dp))

                Text(
                    text = subTitle,
                    color = subTitleColor
                )
            }
        } else {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                contentPadding = PaddingValues(horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                itemsIndexed(
                    items = list,
                    key = { index, _ -> index }
                ) { _, program ->
                    PressableProgramImage(
                        contentDescription = program.title,
                        imgRes = program.imgFile,
                        onItemPress = { onItemPress(program) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun ContentListPreview() {
    ContentList(
        title = "전체 시청내역",
        subTitle = "시청내역이 없어요."
    )
}