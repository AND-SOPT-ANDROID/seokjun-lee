package org.sopt.and.core.designsystem.component.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
    Image(
        painter = painterResource(imgRes),
        contentDescription = contentDescription,
        modifier = modifier
            .noRippleCombineClickable(
                onLongClick = onItemPress
            )
            .width(100.dp)
            .clip(RoundedCornerShape(10.dp))
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