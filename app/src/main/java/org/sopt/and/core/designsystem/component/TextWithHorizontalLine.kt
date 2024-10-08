package org.sopt.and.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextWithHorizontalLine(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .height(0.5.dp)
                .weight(1f)
                .background(color = Color.Gray)
        )

        Text(
            text = text,
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(
            modifier = Modifier
                .height(0.5.dp)
                .weight(1f)
                .background(color = Color.Gray)
        )
    }
}

@Preview(showBackground = false)
@Composable
private fun TextWithHorizontalLinePreview() {
    TextWithHorizontalLine(text = "구분선")
}