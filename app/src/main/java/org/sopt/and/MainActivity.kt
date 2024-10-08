package org.sopt.and

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.and.core.preference.PreferenceUtil
import org.sopt.and.presentation.mypage.MyPageActivity
import org.sopt.and.presentation.signin.SignInActivity

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val pref = PreferenceUtil(this)
        val isAutoLogin = pref.id.isNotBlank() && pref.password.isNotBlank()

        if (isAutoLogin) {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
        finish()
    }
}