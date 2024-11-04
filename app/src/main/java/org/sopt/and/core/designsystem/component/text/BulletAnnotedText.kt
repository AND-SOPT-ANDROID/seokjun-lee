package org.sopt.and.core.designsystem.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.BasicPreview
import kotlin.text.Typography.bullet

@Composable
fun BulletAnnotedText(
    text: String,
    style: TextStyle = TextStyle.Default,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            append(bullet)
            append(text)
        },
        style = style
    )
}

@BasicPreview
@Composable
private fun BulletAnnotedTextPreview() {
    BulletAnnotedText(
        text = stringResource(R.string.signin_text_sns_guide),
        style = TextStyle(fontSize = 11.sp, color = Color.Gray)
    )
}