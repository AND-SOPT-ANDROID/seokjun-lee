package org.sopt.and.presentation.signin.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.and.core.navigation.Route
import org.sopt.and.presentation.signin.SignInRoute

fun NavController.navigateToSignIn(navOptions: NavOptions? = null) = navigate(SignIn, navOptions)

fun NavGraphBuilder.signInScreen(
    modifier: Modifier = Modifier,
    navigateToMyPage: () -> Unit = {}
) {
    composable<SignIn> {
        SignInRoute(
            navigateToSignUp = {},
            navigateToMyPage = navigateToMyPage,
            modifier = modifier)
    }
}

@Serializable
data object SignIn : Route