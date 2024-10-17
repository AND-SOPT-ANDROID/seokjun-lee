package org.sopt.and.core.designsystem.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.Grey300
import org.sopt.and.core.designsystem.theme.WavveBackground
import org.sopt.and.core.designsystem.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    containerColor: Color = WavveBackground,
    textColor: Color = White,
    cursorColor: Color = White,
    placeholderColor: Color = Grey300
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.Search,
            contentDescription = stringResource(R.string.maintab_search),
            tint = placeholderColor
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .background(color = containerColor)
                .padding(vertical = 10.dp, horizontal = 15.dp),
            textStyle = TextStyle.Default.copy(
                color = textColor
            ),
            cursorBrush = SolidColor(cursorColor),
            singleLine = true
        ) { innerTextField ->
            if (value.isBlank()) {
                Text(
                    text = placeholder,
                    color = placeholderColor
                )
            }
            innerTextField()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchTextFieldPreview() {
    Box(
        modifier = Modifier.background(color = WavveBackground)
    ) {
        SearchTextField(
            value = "Value Entered",
            onValueChange = {},
            placeholder = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchTextFieldPlaceholderPreview() {
    Box(
        modifier = Modifier.background(color = WavveBackground)
    ) {
        SearchTextField(
            value = "",
            onValueChange = {},
            placeholder = "Value Not Entered"
        )
    }
}