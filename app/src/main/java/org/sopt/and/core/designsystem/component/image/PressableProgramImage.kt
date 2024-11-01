package org.sopt.and.core.designsystem.component.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.BasicPreview
import org.sopt.and.core.extension.noRippleCombineClickable

@Composable
fun PressableProgramImage(
    @DrawableRes imgRes: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    onItemPress: () -> Unit = {},
) {
    ProgramImage(
        imgRes = imgRes,
        contentDescription = contentDescription,
        modifier = modifier
            .noRippleCombineClickable(
                onLongClick = onItemPress
            )
    )
}

@BasicPreview
@Composable
private fun PressableProgramImagePreview() {
    PressableProgramImage(
        imgRes = R.drawable.img_banner2,
        contentDescription = ""
    )
}