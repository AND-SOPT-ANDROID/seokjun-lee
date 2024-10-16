package org.sopt.and.core.designsystem.component.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ProgramImage(
    @DrawableRes imgRes: Int,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Image(
        painterResource(imgRes),
        contentDescription = contentDescription,
        modifier = modifier
            .width(100.dp)
            .clip(RoundedCornerShape(10.dp))
    )
}