package org.sopt.and.core.designsystem.component.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.Grey500
import org.sopt.and.core.designsystem.theme.WavveBackground
import org.sopt.and.core.designsystem.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogoTopBar(
    actions: List<@Composable () -> Unit>,
    modifier: Modifier = Modifier,
    backgroundColor: Color = WavveBackground,
    contentColor: Color = White
) {
    TopAppBar(
        title = {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.wavve_logo),
                contentDescription = "logo"
            )
        },
        actions = { actions.forEach { it() } },
        colors = TopAppBarColors(
            containerColor = backgroundColor,
            actionIconContentColor = contentColor,
            scrolledContainerColor = contentColor,
            navigationIconContentColor = contentColor,
            titleContentColor = contentColor,
        ),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun LogoTopBarPreview() {
    LogoTopBar(
        actions = listOf()
    )
}