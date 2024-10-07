package org.sopt.and.presentation.signup

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.textfield.ShowActionTextField
import org.sopt.and.core.designsystem.component.textfield.WavveBasicTextField
import org.sopt.and.core.extension.noRippleClickable
import org.sopt.and.core.extension.toast
import org.sopt.and.core.type.AccountType
import org.sopt.and.presentation.signup.state.SignUpUiState
import kotlin.text.Typography.bullet

@Composable
fun SignUpRoute(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = viewModel(),
    navigateUp: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is SignUpSideEffect.Toast -> context.toast(sideEffect.message)
                    is SignUpSideEffect.NavigateUp -> navigateUp()
                }
            }
    }

    SignUpScreen(
        modifier = modifier,
        uiState = uiState,
        onIdChange = viewModel::updateId,
        onPasswordChange = viewModel::updatePassword,
        onSignUpButtonPress = {
            if (uiState.isButtonEnabled) viewModel.checkTextFields()
        }

    )
}

@Composable
private fun SignUpScreen(
    uiState: SignUpUiState,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSignUpButtonPress: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val commonModifier = Modifier.padding(horizontal = 5.dp)

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.signup_intro))
                addStyle(
                    style = SpanStyle(color = Color.White),
                    start = 0,
                    end = 9
                )
                addStyle(
                    style = SpanStyle(color = Color.Gray),
                    start = 9,
                    end = 12
                )
                addStyle(
                    style = SpanStyle(color = Color.White),
                    start = 13,
                    end = 24
                )
                addStyle(
                    style = SpanStyle(color = Color.Gray),
                    start = 25,
                    end = 29
                )
            },
            fontSize = 20.sp,
            modifier = commonModifier.padding(start = 10.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        WavveBasicTextField(
            hint = stringResource(R.string.signup_text_field_id_hint),
            onValueChange = onIdChange,
            value = uiState.id,
            cursorBrush = SolidColor(Color.Blue),
            modifier = commonModifier
        )

        Text(
            text = stringResource(R.string.signup_text_field_id_guide),
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = commonModifier
        )

        Spacer(modifier = Modifier.height(10.dp))

        ShowActionTextField(
            hint = stringResource(R.string.signup_text_field_pw_hint),
            value = uiState.password,
            onValueChange = onPasswordChange,
            modifier = commonModifier
        )
        Text(
            text = stringResource(R.string.signup_text_field_pw_guide),
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = commonModifier
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                modifier = Modifier
                    .height(0.5.dp)
                    .weight(1f)
                    .background(color = Color.Gray)
            )

            Text(
                text = stringResource(R.string.signup_divider),
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(
                modifier = Modifier
                    .height(0.5.dp)
                    .weight(1f)
                    .background(color = Color.Gray)
            )
        }

        Row(
            modifier = commonModifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 40.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
        ) {
            for (type in AccountType.entries) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(color = type.color)
                )
            }
        }

        Row {
            Text(text = buildAnnotatedString { append(bullet) })
            Text(text = "")
        }

        Text(
            text = buildAnnotatedString {
                append(bullet)
                append(
                    stringResource(R.string.signup_text_sns_guide)
                )
            },
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )



        Spacer(Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = if (uiState.isButtonEnabled) Color.Blue else Color.DarkGray
                )
                .noRippleClickable(onSignUpButtonPress)
                .padding(vertical = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.signup_button_signup),
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        uiState = SignUpUiState(),
        onIdChange = {},
        onPasswordChange = {},
        onSignUpButtonPress = {}
    )
}