package org.sopt.and.core.designsystem.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.core.designsystem.component.BasicPreview
import org.sopt.and.core.designsystem.theme.WavveMain
import org.sopt.and.core.designsystem.theme.White

@Composable
fun RoundedCornerButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default,
    contentColor: Color = White,
    containerColor: Color = WavveMain,
    disabledContentColor: Color = Color.Transparent,
    disabledContainerColor: Color = Color.Transparent,
    contentPaddingValues: PaddingValues = PaddingValues(0.dp)
) {
    Button(
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        colors = ButtonColors(
            contentColor = contentColor,
            containerColor = containerColor,
            disabledContentColor = disabledContentColor,
            disabledContainerColor = disabledContainerColor
        ),
        modifier = modifier
    ) {
        Text(
            text = text,
            style = textStyle,
            modifier = Modifier.padding(contentPaddingValues)
        )
    }
}

@BasicPreview
@Composable
private fun RoundedCornerButtonPreview() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        RoundedCornerButton(
            text = "테스트",
            textStyle = TextStyle.Default.copy(fontSize = 16.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .weight(1f)
                .padding(10.dp),
            onClick = {}
        )
        RoundedCornerButton(
            text = "테스트",
            textStyle = TextStyle.Default.copy(fontSize = 16.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .weight(1f)
                .padding(10.dp),
            onClick = {}
        )
    }
}