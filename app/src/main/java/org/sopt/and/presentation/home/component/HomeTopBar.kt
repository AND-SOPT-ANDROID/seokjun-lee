package org.sopt.and.presentation.home.component

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.topbar.LogoActionTopBar
import org.sopt.and.core.extension.noRippleClickable

@Composable
internal fun HomeTopBar(
    modifier: Modifier = Modifier
) {
    LogoActionTopBar(
        actions = listOf<@Composable () -> Unit> {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_live_24),
                contentDescription = null,
                modifier = modifier.noRippleClickable { }
            )
        }
    )
}