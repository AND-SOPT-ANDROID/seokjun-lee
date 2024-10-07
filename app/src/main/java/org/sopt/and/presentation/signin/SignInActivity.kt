package org.sopt.and.presentation.signin

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
import org.sopt.and.core.designsystem.component.topbar.NavigateUpTopBar
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.presentation.signup.SignUpActivity

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ANDANDROIDTheme {
                Scaffold(
                    topBar = {
                        NavigateUpTopBar(
                            title = "WAVVE",
                            onBackClick = {}
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    val intent = Intent(this, SignUpActivity::class.java)

                    SignInScreen(
                        navigateToSignUp = { startActivity(intent) },
                        modifier = Modifier.padding(innerPadding).background(color = Color.Black)
                    )
                }
            }
        }
    }
}