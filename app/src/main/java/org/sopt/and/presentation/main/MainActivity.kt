package org.sopt.and.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.core.preference.PreferenceUtil

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val pref = PreferenceUtil(this)
        val isAutoLogin = pref.id.isNotBlank() && pref.password.isNotBlank()
/*
        if (isAutoLogin) {
            setContent {
                MainScreen()
            }
        } else {
            val intent = Intent(this, SignInActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }*/

        setContent {
            ANDANDROIDTheme {
                CompositionLocalProvider(
                    PreferenceUtil.LocalPreference provides pref
                ) {
                    MainScreen()
                }
            }
        }
    }
}