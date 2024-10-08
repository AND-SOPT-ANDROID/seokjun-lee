package org.sopt.and.presentation.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.AccountItemRow
import org.sopt.and.core.designsystem.component.TextWithHorizontalLine
import org.sopt.and.core.designsystem.component.textfield.ShowActionTextField
import org.sopt.and.core.designsystem.component.textfield.WavveBasicTextField
import org.sopt.and.core.extension.noRippleClickable
import org.sopt.and.presentation.signin.state.SignInUiState
import kotlin.text.Typography.bullet

@Composable
fun SignInRoute(
    navigateToSignUp: () -> Unit,
    navigateToMyPage: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val snackBarHost = remember { SnackbarHostState() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is SignInSideEffect.Toast -> {/*TODO: 액티비티 삭제시 구현*/ }

                    is SignInSideEffect.SnackBar -> {/*snackBarHost.showSnackbar(
                        message = sideEffect.message,
                        actionLabel = "닫기",
                        duration = SnackbarDuration.Short
                    )*/ }

                    SignInSideEffect.NavigateToMyPage -> navigateToMyPage(
                        uiState.id,
                        uiState.password
                    )

                    SignInSideEffect.NavigateToSignUp -> navigateToSignUp()
                }
            }
    }

    SignInScreen(
        uiState = uiState,
        snackBarHost = snackBarHost,
        onIdChange = viewModel::updateId,
        onPasswordChange = viewModel::updatePassword,
        onLoginClick = {
            viewModel.onLoginButtonClick()
            keyboardController?.hide()
        },
        onSignUpClick = viewModel::onSignUpButtonClick,
        modifier = modifier
    )
}

@Composable
private fun SignInScreen(
    uiState: SignInUiState,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
    snackBarHost: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    val commonModifier = Modifier.padding(horizontal = 10.dp)

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {


        Spacer(
            modifier = Modifier.height(20.dp)
        )
        WavveBasicTextField(
            hint = stringResource(R.string.signin_text_field_id_hint),
            value = uiState.id,
            onValueChange = onIdChange,
            modifier = commonModifier,
            cursorBrush = SolidColor(Color.Blue)
        )

        Spacer(modifier = Modifier.height(5.dp))

        ShowActionTextField(
            hint = stringResource(R.string.signin_text_field_password_hint),
            value = uiState.password,
            onValueChange = onPasswordChange,
            modifier = commonModifier
        )

        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = commonModifier
                .fillMaxWidth()
                .noRippleClickable(onLoginClick)
                .background(color = Color.Blue, shape = RoundedCornerShape(30.dp))
                .padding(vertical = 15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.signin_button_signin),
                fontSize = 15.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = commonModifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.signin_button_find_id),
                fontSize = 11.sp,
                color = Color.Gray
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

        TextWithHorizontalLine(
            modifier = commonModifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
            text = stringResource(R.string.signin_divider)
        )

        AccountItemRow(modifier = commonModifier)

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = buildAnnotatedString {
                append(bullet)
                append(
                    stringResource(R.string.signin_text_sns_guide)
                )
            },
            color = Color.Gray,
            fontSize = 11.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        SnackbarHost(
            hostState = snackBarHost,
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        SignInScreen(
            uiState = SignInUiState(),
            onIdChange = {},
            onPasswordChange = {},
            onSignUpClick = {},
            onLoginClick = {},
            snackBarHost = SnackbarHostState()
        )
    }
}