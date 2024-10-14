package org.sopt.and.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import org.sopt.and.core.navigation.Route
import org.sopt.and.presentation.home.navigation.homeScreen
import org.sopt.and.presentation.main.component.MainBottomBar
import org.sopt.and.presentation.mypage.navigation.myPageScreen
import org.sopt.and.presentation.search.navigation.searchScreen

@Composable
fun MainScreen(
    mainNavigator: MainNavigator = rememberMainNavigator()
) {
    Scaffold(
        bottomBar = {
            MainBottomBar(
                isVisible = mainNavigator.showBottomBar(),
                tabs = MainTab.entries,
                currentTab = mainNavigator.currentTab,
                onTabSelected = mainNavigator::navigate
            )
        }
    ) { paddingValues ->
        MainNavHost(
            navController = mainNavigator.navController,
            startDestination = mainNavigator.startDestination,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
private fun MainNavHost(
    navController: NavHostController,
    startDestination: Route,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        homeScreen(modifier = modifier)
        searchScreen(modifier = modifier)
        myPageScreen(modifier = modifier)
    }
}