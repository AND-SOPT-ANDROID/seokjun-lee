package org.sopt.and.presentation.signup.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.and.core.navigation.Route
import org.sopt.and.presentation.signin.navigation.SignIn
import org.sopt.and.presentation.signup.SignUpRoute

fun NavController.navigateToSignUp(navOptions: NavOptions? = null) = navigate(SignUp, navOptions)

fun NavGraphBuilder.signUpScreen(
    modifier: Modifier = Modifier,
    navigateUp: (String, String) -> Unit = {_, _ ->}
) {
    composable<SignUp> {
        SignUpRoute(
            navigateUp = navigateUp,
            modifier = modifier)
    }
}

@Serializable
data object SignUp : Route