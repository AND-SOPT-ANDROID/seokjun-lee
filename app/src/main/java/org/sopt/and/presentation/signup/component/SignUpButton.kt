package org.sopt.and.presentation.signup.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.BasicPreview
import org.sopt.and.core.designsystem.component.button.RoundedCornerButton

@Composable
fun SignUpButton(
    isButtonEnabled: Boolean,
    onSignUpButtonPress: () -> Unit,
    modifier: Modifier = Modifier
) {
    RoundedCornerButton(
        text = stringResource(R.string.signup_button_signup),
        onClick = onSignUpButtonPress,
        containerColor = if (isButtonEnabled) Color.Blue else Color.DarkGray,
        cornerRadius = 0.dp,
        contentPaddingValues = PaddingValues(vertical = 10.dp),
        modifier = modifier
            .fillMaxWidth()
    )
}

@BasicPreview
@Composable
private fun SignUpButtonPreview() {
    SignUpButton(
        isButtonEnabled = false,
        onSignUpButtonPress = {}
    )
}