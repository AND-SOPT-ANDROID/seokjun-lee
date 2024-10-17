package org.sopt.and.presentation.home.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.and.core.navigation.MainTabRoute
import org.sopt.and.presentation.home.HomeRoute

fun NavController.navigateToHome(navOptions: NavOptions? = null) = navigate(Home, navOptions)

fun NavGraphBuilder.homeScreen(
    modifier: Modifier = Modifier
) {
    composable<Home> {
        HomeRoute(
            modifier = modifier
        )
    }
}

@Serializable
data object Home : MainTabRoute