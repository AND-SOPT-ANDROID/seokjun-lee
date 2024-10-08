package org.sopt.and.core.designsystem.component.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.and.R
import org.sopt.and.core.extension.noRippleClickable

@Composable
fun ShowActionTextField(
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isPasswordShown by remember { mutableStateOf(false) }
    val visualTransformation = VisualTransformation {
        TransformedText(
            AnnotatedString("*".repeat(it.text.length)), OffsetMapping.Identity
        )
    }

    WavveBasicTextField(
        modifier = modifier,
        hint = hint,
        onValueChange = onValueChange,
        value = value,
        cursorBrush = SolidColor(Color.Blue),
        visualTransformation = if (isPasswordShown) VisualTransformation.None else visualTransformation,
        actionButton = {
            Text(
                text =
                if (isPasswordShown) stringResource(R.string.component_text_field_hide)
                else stringResource(R.string.component_text_field_show),
                color = Color.White,
                modifier = Modifier.noRippleClickable { isPasswordShown = !isPasswordShown })
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun ShowActionTextFieldPreview() {
    WavveBasicTextField(
        hint = "label",
        onValueChange = {},
        value = "",
        cursorBrush = SolidColor(Color.White),
        actionButton = {
            Text(text = "show", color = Color.White)
        }
    )
}