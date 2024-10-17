package org.sopt.and.presentation.signup.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.and.core.extension.saveIdAndPassword
import org.sopt.and.core.navigation.Route
import org.sopt.and.presentation.signup.SignUpRoute

fun NavController.navigateToSignUp(navOptions: NavOptions? = null) = navigate(SignUp, navOptions)

fun NavGraphBuilder.signUpScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    composable<SignUp> {
        SignUpRoute(
            navigateUp = { id, password ->
                with(navController) {
                    saveIdAndPassword(id, password)
                    navigateUp()
                }
            },
            modifier = modifier
        )
    }
}

@Serializable
data object SignUp : Route