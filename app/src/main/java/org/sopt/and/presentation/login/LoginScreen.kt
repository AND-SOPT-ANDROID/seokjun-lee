package org.sopt.and.presentation.login

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.core.extension.noRippleClickable

@Composable
fun LoginScreen(
    navigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
    ) {
        val context = LocalContext.current
        var idText by remember { mutableStateOf("") }
        var pwText by remember { mutableStateOf("") }


        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Welcome To Sopt",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(100.dp)
        )
        Text(
            text = "ID",
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = idText,
            onValueChange = { idText = it },
            label = { Text("사용자 이름 입력") },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(
            text = "비밀번호",
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = pwText,
            onValueChange = { pwText = it },
            label = { Text("비밀번호 입력") },
            modifier = Modifier
                .fillMaxWidth()
        )


        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "회원가입하기",
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .noRippleClickable { navigateToSignUp() }
                .fillMaxWidth()

        )
        Button(
            onClick = {
                if (idText.length >= 6) {
                    Toast.makeText(context, "로그인 성공", Toast.LENGTH_SHORT).show()
                }
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("로그인하기")
        }
    }
}