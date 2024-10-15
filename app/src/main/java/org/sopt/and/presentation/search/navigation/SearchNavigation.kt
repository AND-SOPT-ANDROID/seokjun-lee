package org.sopt.and.presentation.search.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.and.core.navigation.MainTabRoute
import org.sopt.and.presentation.search.SearchRoute

fun NavController.navigateToSearch(navOptions: NavOptions? = null) = navigate(Search, navOptions)

fun NavGraphBuilder.searchScreen(
    modifier: Modifier = Modifier
) {
    composable<Search> {
        SearchRoute(
            modifier = modifier
        )
    }
}

@Serializable
data object Search: MainTabRoute