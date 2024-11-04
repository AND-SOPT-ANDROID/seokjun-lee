package org.sopt.and.presentation.mypage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.BasicPreview
import org.sopt.and.core.designsystem.theme.Grey500

@Composable
fun ProfilePurchaseGroup(
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Grey500)
            .padding(top = 10.dp, bottom = 15.dp, start = 10.dp)
    ) {
        Text(
            text = title,
            color = Color.LightGray
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = subTitle,
                color = Color.White
            )
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = stringResource(R.string.icon_next_description),
                tint = Color.White
            )
        }
    }
}

@BasicPreview
@Composable
private fun ProfilePurchaseGroupPreview() {
    ProfilePurchaseGroup(
        title = stringResource(R.string.mypage_button_title_1),
        subTitle = stringResource(R.string.mypage_button_subtitle_1)
    )
}