package org.sopt.and.presentation.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import org.sopt.and.core.designsystem.component.text.BulletAnnotedText
import org.sopt.and.core.designsystem.component.textfield.ShowActionTextField
import org.sopt.and.core.designsystem.component.textfield.WavveBasicTextField
import org.sopt.and.core.designsystem.component.topbar.CancelTopBar
import org.sopt.and.core.extension.toast
import org.sopt.and.presentation.signup.component.SignUpButton
import org.sopt.and.presentation.signup.component.SignUpTitle
import org.sopt.and.presentation.signup.state.SignUpUiState

@Composable
fun SignUpRoute(
    navigateUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is SignUpSideEffect.Toast -> context.toast(sideEffect.message)
                    is SignUpSideEffect.NavigateUp -> navigateUp(uiState.id, uiState.password)
                }
            }
    }

    SignUpScreen(
        modifier = modifier,
        uiState = uiState,
        onIdChange = viewModel::updateId,
        onPasswordChange = viewModel::updatePassword,
        onHobbyChange = viewModel::updateHobby,
        onSignUpButtonPress = viewModel::registerUser,
        onCloseClick = {}
    )
}

@Composable
private fun SignUpScreen(
    uiState: SignUpUiState,
    onCloseClick: () -> Unit,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onHobbyChange: (String) -> Unit,
    onSignUpButtonPress: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        CancelTopBar(
            title = stringResource(R.string.signup_top_bar_title),
            onBackClick = onCloseClick
        )

        SignUpTitle(
            modifier = Modifier.padding(top = 20.dp, start = 15.dp, end = 5.dp)
        )

        WavveBasicTextField(
            hint = stringResource(R.string.signup_text_field_id_hint),
            onValueChange = onIdChange,
            value = uiState.id,
            modifier = Modifier.padding(top = 20.dp, start = 5.dp, end = 5.dp)
        )
        Text(
            text = stringResource(R.string.signup_text_field_id_guide),
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 5.dp, end = 5.dp)
        )

        ShowActionTextField(
            hint = stringResource(R.string.signup_text_field_pw_hint),
            value = uiState.password,
            onValueChange = onPasswordChange,
            modifier = Modifier.padding(top = 15.dp, start = 5.dp, end = 5.dp)
        )
        Text(
            text = stringResource(R.string.signup_text_field_pw_guide),
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 5.dp, end = 5.dp)
        )

        WavveBasicTextField(
            hint = stringResource(R.string.signup_text_field_hobby_hint),
            value = uiState.hobby,
            onValueChange = onHobbyChange,
            modifier = Modifier.padding(top = 15.dp, start = 5.dp, end = 5.dp)
        )
        Text(
            text = stringResource(R.string.signup_text_field_hobby_guide),
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 5.dp, end = 5.dp)
        )

        SocialAccountGroup(modifier = modifier.padding(top = 40.dp))

        BulletAnnotedText(
            text = stringResource(R.string.signup_text_sns_guide),
            style = TextStyle(fontSize = 12.sp, color = Color.Gray),
            modifier = Modifier.padding(top = 30.dp, start = 8.dp, end = 8.dp)
        )

        Spacer(Modifier.weight(1f))
        SignUpButton(
            isButtonEnabled = uiState.isButtonEnabled,
            onSignUpButtonPress = onSignUpButtonPress
        )
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        uiState = SignUpUiState(),
        onCloseClick = {},
        onIdChange = {},
        onPasswordChange = {},
        onHobbyChange = {},
        onSignUpButtonPress = {}
    )
}