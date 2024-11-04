package org.sopt.and.presentation.signup.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.BasicPreview
import org.sopt.and.core.designsystem.component.text.AnnotatedText

@Composable
internal fun SignUpTitle(
    modifier: Modifier = Modifier,
) {
    val annotatedTexts =
        listOf(
            Pair(stringResource(R.string.signup_intro1), SpanStyle(color = Color.White)),
            Pair(stringResource(R.string.signup_intro2), SpanStyle(color = Color.Gray)),
            Pair(stringResource(R.string.signup_intro3), SpanStyle(color = Color.White)),
            Pair(stringResource(R.string.signup_intro4), SpanStyle(color = Color.Gray))
        )


    AnnotatedText(
        modifier = modifier,
        annotatedTexts = annotatedTexts,
        commonStyle = TextStyle(fontSize = 20.sp)
    )
}

@BasicPreview
@Composable
private fun SignUpTitlePreview() {
    SignUpTitle()
}