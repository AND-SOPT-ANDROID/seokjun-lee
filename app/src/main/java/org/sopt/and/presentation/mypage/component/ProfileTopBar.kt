package org.sopt.and.presentation.mypage.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.Grey500
import org.sopt.and.core.designsystem.theme.White

@Composable
fun ProfileTopBar(
    email: String,
    image: Painter,
    modifier: Modifier = Modifier,
    containerColor: Color = Grey500,
    titleContentColor: Color = White,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = containerColor)
            .padding(horizontal = 12.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(72.dp)

        )
        Spacer(Modifier.width(10.dp))

        Text(
            text = email,
            fontSize = 14.sp,
            color = titleContentColor
        )

        Spacer(Modifier.weight(1f))

        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = stringResource(R.string.mypage_description_notification),
            tint = Color.White
        )

        Spacer(Modifier.width(20.dp))

        Icon(
            imageVector = Icons.Outlined.Settings,
            contentDescription = stringResource(R.string.mypage_description_setting),
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileTopBarPreview() {
    ProfileTopBar(
        email = "abc1234@gmail.com",
        image = painterResource(R.drawable.ic_launcher_foreground),
    )
}
