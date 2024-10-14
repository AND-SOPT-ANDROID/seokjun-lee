package org.sopt.and.presentation.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.topbar.CancelTopBar
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ANDANDROIDTheme {
                Scaffold(
                    topBar = {
                        CancelTopBar(
                            title = stringResource(R.string.signup_top_bar_title),
                            onBackClick = { this.finish() }
                        )
                    }
                ) { innerPadding ->
                    SignUpRoute(
                        navigateUp = { id, password ->
                            /*intent.putExtra(ID_KEY, id)
                            intent.putExtra(PASSWORD_KEY, password)
                            setResult(RESULT_OK, intent)
                            finish()*/
                        },
                        modifier = Modifier
                            .background(color = Color.Black)
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}