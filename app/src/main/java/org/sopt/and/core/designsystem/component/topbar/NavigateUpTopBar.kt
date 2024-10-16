package org.sopt.and.core.designsystem.component.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.WavveBackground
import org.sopt.and.core.designsystem.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigateUpTopBar(
    modifier: Modifier = Modifier,
    containerColor: Color = WavveBackground,
    titleContentColor: Color = White,
    actionIconContentColor: Color = White,
) {
    CenterAlignedTopAppBar(
        modifier = modifier
            .fillMaxWidth(),
        title = {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.wavve_logo),
                contentDescription = stringResource(R.string.top_bar_logo)
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
private fun NavigateUpTopBarPreview() {
    NavigateUpTopBar(
    )
}