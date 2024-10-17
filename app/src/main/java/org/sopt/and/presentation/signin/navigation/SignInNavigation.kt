package org.sopt.and.presentation.signin.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.and.core.extension.getId
import org.sopt.and.core.extension.getPassword
import org.sopt.and.core.navigation.Route
import org.sopt.and.presentation.mypage.navigation.navigateToMyPage
import org.sopt.and.presentation.signin.SignInRoute
import org.sopt.and.presentation.signup.navigation.navigateToSignUp

fun NavController.navigateToSignIn(navOptions: NavOptions? = null) =
    navigate(SignIn, navOptions)

fun NavGraphBuilder.signInScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    composable<SignIn> {
        SignInRoute(
            navigateToSignUp = navController::navigateToSignUp,
            navigateToMyPage = navController::navigateToMyPage,
            signUpId = navController.getId(),
            signUpPassword = navController.getPassword(),
            modifier = modifier
        )
    }
}

@Serializable
data object SignIn : Route