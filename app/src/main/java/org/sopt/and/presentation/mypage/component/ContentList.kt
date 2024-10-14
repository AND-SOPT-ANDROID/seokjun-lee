package org.sopt.and.presentation.mypage.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

@Composable
fun ContentList(
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier,
    list: List<String> = emptyList(),
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
            fontSize = 16.sp
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