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
import androidx.compose.ui.res.stringResource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.topbar.NavigateUpTopBar
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.core.preference.PreferenceUtil
import org.sopt.and.presentation.signup.SignUpActivity

@AndroidEntryPoint
class SignInActivity : ComponentActivity() {

    private var id: String = EMPTY_STRING
    private var password: String = EMPTY_STRING
    private lateinit var preferenceUtil: PreferenceUtil

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == RESULT_OK) {
            id = result.data?.getStringExtra(ID_KEY).takeIf { it != null }.toString()
            password = result.data?.getStringExtra(PASSWORD_KEY).takeIf { it != null }.toString()
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
                            title = stringResource(R.string.signin_top_bar_title),
                            onBackClick = {}
                        )
                    },
                    snackbarHost = {
                        SnackbarHost(hostState = snackBarHost)
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    SignInRoute(
                        navigateToMyPage = { idTextField, pwTextField ->
                            if(isLoginPossible(idTextField, pwTextField)) {
                                saveIdAndPassword()
                            } else {
                                coroutine.launch {
                                    snackBarHost.showSnackbar(
                                        message = this@SignInActivity.getString(R.string.signin_snackbar_fail),
                                        actionLabel = this@SignInActivity.getString(R.string.signin_snackbar_cancel)
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

const val ID_KEY = "id"
const val PASSWORD_KEY = "password"
const val EMPTY_STRING = ""