package org.sopt.and.presentation.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.SocialAccountGroup
import org.sopt.and.core.designsystem.component.button.RoundedCornerButton
import org.sopt.and.core.designsystem.component.text.BulletAnnotedText
import org.sopt.and.core.designsystem.component.textfield.ShowActionTextField
import org.sopt.and.core.designsystem.component.textfield.WavveBasicTextField
import org.sopt.and.core.designsystem.component.topbar.CenterLogoTopBar
import org.sopt.and.core.designsystem.theme.WavveBackground
import org.sopt.and.core.extension.noRippleClickable
import org.sopt.and.core.extension.showWavveSnackBar
import org.sopt.and.core.extension.toast
import org.sopt.and.core.preference.PreferenceUtil.Companion.LocalPreference
import org.sopt.and.presentation.signin.component.SignInExtraServiceGroup
import org.sopt.and.presentation.signin.contract.SignInEvent
import org.sopt.and.presentation.signin.contract.SignInSideEffect
import org.sopt.and.presentation.signin.contract.SignInUiState

@Composable
fun SignInRoute(
    navigateToSignUp: () -> Unit,
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val keyboardController = LocalSoftwareKeyboardController.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val preference = LocalPreference.current
    val context = LocalContext.current
    val snackBarHost = remember { SnackbarHostState() }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is SignInSideEffect.ShowToast -> {
                        context.toast(sideEffect.message)
                    }

                    is SignInSideEffect.ShowSnackBar -> {
                        snackBarHost.showWavveSnackBar(
                            context = context,
                            message = sideEffect.message
                        )
                    }

                    is SignInSideEffect.NavigateToHome -> {
                        with(preference) {
                            token = sideEffect.token
                        }
                        navigateToHome()
                    }

                    SignInSideEffect.NavigateToSignUp -> {
                        keyboardController?.hide()
                        navigateToSignUp()
                    }
                }
            }
    }

    SignInScreen(
        uiState = uiState,
        snackBarHost = snackBarHost,
        onIdChange = { newValue ->
            viewModel.setEvent(SignInEvent.OnIdTextFieldChanged(newValue))
        },
        onPasswordChange = { newValue ->
            viewModel.setEvent(SignInEvent.OnPasswordTextFieldChanged(newValue))
        },
        onLoginClick = {
            viewModel.setEvent(SignInEvent.OnSignInButtonClicked)
        },
        onSignUpClick = {
            viewModel.setEvent(SignInEvent.OnSignUpButtonClicked)
        },
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

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = WavveBackground)
    ) {
        CenterLogoTopBar()

        WavveBasicTextField(
            hint = stringResource(R.string.signin_text_field_id_hint),
            value = uiState.id,
            onValueChange = onIdChange,
            modifier = Modifier.padding(top = 40.dp, start = 10.dp, end = 10.dp),
            cursorBrush = SolidColor(Color.Blue)
        )

        ShowActionTextField(
            hint = stringResource(R.string.signin_text_field_password_hint),
            value = uiState.password,
            onValueChange = onPasswordChange,
            modifier = Modifier.padding(top = 5.dp, start = 10.dp, end = 10.dp)
        )

        RoundedCornerButton(
            text = stringResource(R.string.signin_button_signin),
            onClick = onLoginClick,
            textStyle = TextStyle(
                fontSize = 15.sp,
                color = Color.White
            ),
            cornerRadius = 30.dp,
            modifier = Modifier
                .fillMaxWidth()
                .noRippleClickable(onLoginClick)
                .padding(top = 55.dp, start = 10.dp, end = 10.dp),
        )

        SignInExtraServiceGroup(
            onSignUpClick = onSignUpClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 10.dp, end = 10.dp)
        )


        SocialAccountGroup(modifier = Modifier.padding(top = 20.dp, start = 10.dp, end = 10.dp))

        BulletAnnotedText(
            text = stringResource(R.string.signin_text_sns_guide),
            style = TextStyle(fontSize = 11.sp, color = Color.Gray),
            modifier = Modifier.padding(top = 24.dp, start = 8.dp, end = 8.dp)
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