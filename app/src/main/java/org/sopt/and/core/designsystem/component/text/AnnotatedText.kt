package org.sopt.and.core.designsystem.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

@Composable
fun AnnotatedText(
    annotatedTexts: List<Pair<String, SpanStyle>>,
    modifier: Modifier = Modifier,
    commonStyle: TextStyle = TextStyle.Default
) {
    Text(
        modifier = modifier,
        style = commonStyle,
        text = buildAnnotatedString {
            annotatedTexts.forEach { (text, style) ->
                withStyle(style = style) {
                    append(text)
                }
            }
        }
    )
}