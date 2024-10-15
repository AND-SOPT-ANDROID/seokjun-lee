package org.sopt.and.presentation.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.Grey200
import org.sopt.and.core.designsystem.theme.Grey500
import org.sopt.and.core.designsystem.theme.WavveBackground
import org.sopt.and.core.extension.noRippleClickable
import org.sopt.and.core.extension.showWavveSnackBar
import org.sopt.and.core.preference.PreferenceUtil.Companion.LocalPreference
import org.sopt.and.presentation.mypage.component.ContentList
import org.sopt.and.presentation.mypage.component.DoubleTextButton
import org.sopt.and.presentation.mypage.component.ProfileTopBar

@Composable
fun MyPageRoute(
    modifier: Modifier = Modifier,
    onLogout: () -> Unit = {},
    viewModel: MyPageViewModel = hiltViewModel()
) {
    val snackBarHost = remember { SnackbarHostState() }
    val lifecycleOwner = LocalLifecycleOwner.current
    val preference = LocalPreference.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is MyPageSideEffect.OnLogout -> {
                        preference.clearIdPassword()
                        onLogout()
                    }
                }
            }
    }

    Box {
        MyPageScreen(
            email = preference.id,
            onLogoutButtonClick = viewModel::onLogoutButtonClick,
            modifier = modifier
        )
        SnackbarHost(
            hostState = snackBarHost,
            modifier = modifier.align(alignment = Alignment.BottomCenter)
        )
    }
}

@Composable
private fun MyPageScreen(
    email: String,
    onLogoutButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(WavveBackground)
            .verticalScroll(scrollState)
    ) {
        ProfileTopBar(
            email = email,
            image = painterResource(R.drawable.ic_launcher_foreground),
        )

        DoubleTextButton(
            title = stringResource(R.string.mypage_button_title_1),
            subTitle = stringResource(R.string.mypage_button_subtitle_1),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Grey500)
                .padding(top = 10.dp, bottom = 15.dp, start = 10.dp)
        )

        HorizontalDivider(thickness = 1.dp, color = Color.Black)

        DoubleTextButton(
            title = stringResource(R.string.mypage_button_title_2),
            subTitle = stringResource(R.string.mypage_button_subtitle_2),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Grey500)
                .padding(top = 10.dp, bottom = 15.dp, start = 10.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            ContentList(
                title = stringResource(R.string.mypage_content_title1),
                subTitle = stringResource(R.string.mypage_content_empty1),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            )

            ContentList(
                title = stringResource(R.string.mypage_content_title2),
                subTitle = stringResource(R.string.mypage_content_empty2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            )
        }

        Text(
            text = stringResource(R.string.mypage_button_logout),
            color = Grey200,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .fillMaxWidth()
                .noRippleClickable(onLogoutButtonClick)
                .padding(vertical = 20.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun MyPageScreenPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        MyPageScreen(
            email = "이석준",
            onLogoutButtonClick = {}
        )
    }
}