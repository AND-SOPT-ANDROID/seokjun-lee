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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.row.AccountItemRow
import org.sopt.and.core.designsystem.component.row.TextWithHorizontalLine
import org.sopt.and.core.designsystem.component.textfield.ShowActionTextField
import org.sopt.and.core.designsystem.component.textfield.WavveBasicTextField
import org.sopt.and.core.extension.noRippleClickable
import kotlin.text.Typography.bullet

@Composable
fun SignInScreen(
    navigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val commonModifier = Modifier.padding(horizontal = 10.dp)

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        var idText by remember { mutableStateOf("") }
        var pwText by remember { mutableStateOf("") }


        Spacer(
            modifier = Modifier.height(20.dp)
        )
        WavveBasicTextField(
            hint = "이메일 주소 또는 아이디",
            value = idText,
            onValueChange = { idText = it },
            modifier = commonModifier,
            cursorBrush = SolidColor(Color.Blue)
        )

        Spacer(modifier = Modifier.height(5.dp))

        ShowActionTextField(
            hint = "비밀번호",
            value = pwText,
            onValueChange = { pwText = it },
            modifier = commonModifier
        )

        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = commonModifier
                .fillMaxWidth()
                .background(color = Color.Blue, shape = RoundedCornerShape(30.dp))
                .padding(vertical = 15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "로그인",
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
                text = "아이디 찾기",
                fontSize = 11.sp,
                color = Color.Gray
            )

            Text(
                text = "|",
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(
                text = "비밀번호 재설정",
                fontSize = 11.sp,
                color = Color.Gray,
            )

            Text(
                text = "|",
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(
                text = "회원가입",
                fontSize = 11.sp,
                color = Color.Gray,
                modifier = Modifier.noRippleClickable (
                    navigateToSignUp
                )
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

    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        SignInScreen(navigateToSignUp = {})
    }
}