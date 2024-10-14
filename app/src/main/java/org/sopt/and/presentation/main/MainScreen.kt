package org.sopt.and.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import org.sopt.and.core.designsystem.theme.Grey500
import org.sopt.and.core.navigation.Route
import org.sopt.and.presentation.home.navigation.homeScreen
import org.sopt.and.presentation.main.component.MainBottomBar
import org.sopt.and.presentation.mypage.navigation.myPageScreen
import org.sopt.and.presentation.mypage.navigation.navigateToMyPage
import org.sopt.and.presentation.search.navigation.searchScreen
import org.sopt.and.presentation.signin.navigation.signInScreen
import org.sopt.and.presentation.signup.navigation.navigateToSignUp
import org.sopt.and.presentation.signup.navigation.signUpScreen

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
            paddingValues = paddingValues
        )
    }
}

@Composable
private fun MainNavHost(
    navController: NavHostController,
    startDestination: Route,
    paddingValues: PaddingValues
) {
    val topBarModifier = Modifier
        .background(Grey500)
        .systemBarsPadding()

    val mainModifier = topBarModifier
        .padding(bottom = paddingValues.calculateBottomPadding())

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        signInScreen(
            navigateToSignUp = navController::navigateToSignUp,
            navigateToMyPage = navController::navigateToMyPage,
            modifier = topBarModifier
        )

        signUpScreen(
            navigateUp = { id, password ->
                navController.navigateUp()
            },
            modifier = topBarModifier
        )

        homeScreen(modifier = mainModifier)
        searchScreen(modifier = mainModifier)
        myPageScreen(modifier = mainModifier)
    }
}