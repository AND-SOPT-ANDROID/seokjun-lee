package org.sopt.and.presentation.mypage

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.and.core.designsystem.component.topbar.NavigateUpTopBar
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.core.preference.PreferenceUtil
import org.sopt.and.presentation.signup.SignUpActivity

@AndroidEntryPoint
class MyPageActivity : ComponentActivity() {

    private val preferenceUtil by lazy { PreferenceUtil(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            ANDANDROIDTheme {
                Scaffold { innerPadding ->
                    MyPageRoute(
                        email = preferenceUtil.id,
                        modifier = Modifier.background(color = Color.Black).padding(innerPadding)
                    )
                }
            }
        }
    }
}