package org.sopt.and.presentation.signin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.sopt.and.core.designsystem.component.topbar.NavigateUpTopBar
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.core.preference.PreferenceUtil
import org.sopt.and.presentation.mypage.MyPageActivity
import org.sopt.and.presentation.signup.SignUpActivity

@AndroidEntryPoint
class SignInActivity : ComponentActivity() {

    private var id: String = ""
    private var password: String = ""
    private lateinit var preferenceUtil: PreferenceUtil

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == RESULT_OK) {
            id = result.data?.getStringExtra(ID_KEY) ?: ""
            password = result.data?.getStringExtra(PASSWORD_KEY) ?: ""
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceUtil = PreferenceUtil(this)

        enableEdgeToEdge()
        setContent {
            val snackBarHost = remember { SnackbarHostState() }
            val coroutine = rememberCoroutineScope()
            ANDANDROIDTheme {
                Scaffold(
                    topBar = {
                        NavigateUpTopBar(
                            title = "WAVVE",
                            onBackClick = {}
                        )
                    },
                    snackbarHost = {
                        SnackbarHost(
                            hostState = snackBarHost)
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    SignInRoute(
                        navigateToMyPage = { idTextField, pwTextField ->
                            if(isLoginPossible(idTextField, pwTextField)) {
                                saveIdAndPassword()
                                val intent = Intent(this, MyPageActivity::class.java)
                                startActivity(intent)
                            } else {
                                coroutine.launch {
                                    snackBarHost.showSnackbar(
                                        message = "아이디 또는 비밀번호가 일치하지 않습니다.",
                                        actionLabel = "닫기"
                                    )
                                }
                            }
                        },
                        navigateToSignUp = {
                            val intent = Intent(this, SignUpActivity::class.java)
                            resultLauncher.launch(intent)
                        },
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(color = Color.Black)
                    )
                }
            }
        }
    }

    private fun isLoginPossible(idTextField: String, pwTextField: String): Boolean {
        val isIdCorrect = id.isNotBlank() && (idTextField == id)
        val isPasswordCorrect = password.isNotBlank() && (pwTextField == password)

        return isIdCorrect && isPasswordCorrect
    }

    private fun saveIdAndPassword() {
        preferenceUtil.id = id
        preferenceUtil.password = password
    }
}

private const val ID_KEY = "id"
private const val PASSWORD_KEY = "password"