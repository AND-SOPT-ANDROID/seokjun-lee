package org.sopt.and.presentation.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.R
import org.sopt.and.core.extension.noRippleClickable
import org.sopt.and.presentation.mypage.component.ContentList
import org.sopt.and.presentation.mypage.component.DoubleTextButton

@Composable
fun MyPageRoute(
    modifier: Modifier = Modifier,
    email: String = ""
) {
    MyPageScreen(
        email = email,
        modifier = modifier
    )
}

@Composable
private fun MyPageScreen(
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(vertical = 20.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(64.dp)

            )
            Spacer(Modifier.width(10.dp))

            Text(
                text = email,
                color = Color.White
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

        DoubleTextButton(
            title = stringResource(R.string.mypage_button_title_1),
            subTitle = stringResource(R.string.mypage_button_subtitle_1),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .noRippleClickable { }
                .padding(top = 10.dp, bottom = 15.dp, start = 10.dp)
        )

        HorizontalDivider(thickness = 1.dp, color = Color.Black)

        DoubleTextButton(
            title = stringResource(R.string.mypage_button_title_2),
            subTitle = stringResource(R.string.mypage_button_subtitle_2),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(top = 10.dp, bottom = 15.dp, start = 10.dp)
        )

        ContentList(
            title = stringResource(R.string.mypage_content_title1),
            subTitle = stringResource(R.string.mypage_content_empty1),
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        )

        ContentList(
            title = stringResource(R.string.mypage_content_title2),
            subTitle = stringResource(R.string.mypage_content_empty2),
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MyPageScreenPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        MyPageScreen(
            email = "이석준"
        )
    }
}