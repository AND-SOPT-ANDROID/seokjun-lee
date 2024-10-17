package org.sopt.and.core.designsystem.component.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.R
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
                contentDescription = stringResource(id = R.string.icon_logo_description)
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
        modifier = modifier.padding(end = 20.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun LogoTopBarPreview() {
    LogoTopBar(
        actions = listOf()
    )
}