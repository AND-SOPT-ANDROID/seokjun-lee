package org.sopt.and.core.designsystem.component.topbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.WavveBackground
import org.sopt.and.core.designsystem.theme.White
import org.sopt.and.core.extension.noRippleClickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CancelTopBar(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = WavveBackground,
    titleContentColor: Color = White,
    actionIconContentColor: Color = White,
) {
    CenterAlignedTopAppBar(
        modifier = modifier
            .fillMaxWidth(),
        title = {
            Text(
                text = title,
                fontSize = 16.sp
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Outlined.Close,
                contentDescription = stringResource(R.string.icon_close_description),
                modifier = Modifier
                    .size(32.dp)
                    .noRippleClickable { onBackClick() }
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = containerColor,
            titleContentColor = titleContentColor,
            actionIconContentColor = actionIconContentColor

        )
    )
}

@Preview(showBackground = true)
@Composable
private fun CancelTopBarPreview() {
    CancelTopBar(
        title = "회원가입",
        onBackClick = {}
    )
}