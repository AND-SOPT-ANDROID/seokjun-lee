package org.sopt.and.presentation.search.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.Grey350
import org.sopt.and.core.designsystem.theme.WavveBackground
import org.sopt.and.core.designsystem.theme.White

@Composable
fun CategoryButton(
    @StringRes titleRes: Int,
    @DrawableRes iconRes: Int,
    @StringRes contentDescriptionRes: Int,
    modifier: Modifier = Modifier,
    contentColor: Color = White,
    borderColor: Color = Grey350
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(30.dp)
            )
            .padding(vertical = 12.dp).padding(start=16.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = iconRes),
            contentDescription = stringResource(id = contentDescriptionRes),
            colorFilter = ColorFilter.tint(color = borderColor)
        )
        Spacer(modifier = Modifier.width(6.dp))

        Text(
            stringResource(id = titleRes),
            color = contentColor,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
            contentDescription = stringResource(id = R.string.icon_next_description),
            tint = borderColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryButtons() {
    Row(
        modifier = Modifier.fillMaxWidth().background(WavveBackground),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        CategoryButton(
            titleRes = R.string.home_tab_new_classic,
            iconRes = R.drawable.ic_live_24,
            contentDescriptionRes = R.string.icon_banner_description,
            modifier = Modifier.wrapContentHeight().weight(1f)
        )


        CategoryButton(
            titleRes = R.string.home_tab_movie,
            iconRes = R.drawable.ic_live_24,
            contentDescriptionRes = R.string.icon_banner_description,
                    modifier = Modifier.wrapContentHeight().weight(1f)
        )

    }
}