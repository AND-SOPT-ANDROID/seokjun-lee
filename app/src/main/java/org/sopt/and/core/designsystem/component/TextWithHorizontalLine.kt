package org.sopt.and.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.core.designsystem.theme.Grey300

@Composable
fun TextWithHorizontalLine(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Grey300
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            thickness = 0.5.dp,
            modifier = Modifier
                .weight(1f)
                .background(color = color)
        )

        Text(
            text = text,
            color = color,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        HorizontalDivider(
            thickness = 0.5.dp,
            modifier = Modifier
                .weight(1f)
                .background(color = color)
        )
    }
}

@Preview(showBackground = false)
@Composable
private fun TextWithHorizontalLinePreview() {
    TextWithHorizontalLine(text = "구분선")
}