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
    navigateToMyPage: () -> Unit,
    navigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    composable<SignIn> {
        SignInRoute(
            navigateToSignUp = navigateToSignUp,
            navigateToMyPage = navigateToMyPage,
            modifier = modifier)
    }
}

@Serializable
data object SignIn : Route