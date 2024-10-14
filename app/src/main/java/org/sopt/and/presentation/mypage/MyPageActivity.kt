package org.sopt.and.presentation.mypage

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.core.preference.PreferenceUtil
import org.sopt.and.presentation.signin.SignInActivity

@AndroidEntryPoint
class MyPageActivity : ComponentActivity() {

    private val preferenceUtil by lazy { PreferenceUtil(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            ANDANDROIDTheme {
                val snackBarHost = remember { SnackbarHostState() }
                val context = LocalContext.current
                Scaffold(
                    snackbarHost = {
                        SnackbarHost(hostState = snackBarHost)
                    },
                ) { innerPadding ->

                    LaunchedEffect(true) {
                        snackBarHost.showSnackbar(
                            message = context.getString(R.string.mypage_snackbar_signin_success),
                            actionLabel = context.getString(R.string.mypage_snackbar_cancel),
                            duration = SnackbarDuration.Short
                        )
                    }

                    MyPageRoute(
                        email = preferenceUtil.id,
                        onLogout = {
                            initializeIdPwCache()
                            logout()
                        },
                        modifier = Modifier.background(color = Color.Black).padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun logout() {
        val intent = Intent(this, SignInActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
    }

    private fun initializeIdPwCache() {
        preferenceUtil.id = ""
        preferenceUtil.password = ""
    }
}