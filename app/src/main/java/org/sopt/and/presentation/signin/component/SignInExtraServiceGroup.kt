package org.sopt.and.presentation.signin.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.core.extension.noRippleClickable

@Composable
internal fun SignInExtraServiceGroup(
    modifier: Modifier = Modifier,
    onFindIdClick: () -> Unit = {},
    onResetPasswordClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
    ) {
        Text(
            text = stringResource(R.string.signin_button_find_id),
            fontSize = 11.sp,
            color = Color.Gray,
            modifier = Modifier.noRippleClickable(onFindIdClick)
        )

        Text(
            text = stringResource(R.string.signin_button_divider),
            fontSize = 12.sp,
            color = Color.Gray
        )
        Text(
            text = stringResource(R.string.signin_button_password_reset),
            fontSize = 11.sp,
            color = Color.Gray,
            modifier = Modifier.noRippleClickable(onResetPasswordClick)
        )

        Text(
            text = stringResource(R.string.signin_button_divider),
            fontSize = 12.sp,
            color = Color.Gray
        )

        Text(
            text = stringResource(R.string.signin_button_signup),
            fontSize = 11.sp,
            color = Color.Gray,
            modifier = Modifier.noRippleClickable(onSignUpClick)
        )
    }
}