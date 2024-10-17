package org.sopt.and.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import org.sopt.and.core.designsystem.theme.WavveBackground
import org.sopt.and.core.navigation.Route
import org.sopt.and.core.preference.PreferenceUtil.Companion.LocalPreference
import org.sopt.and.presentation.home.navigation.Home
import org.sopt.and.presentation.home.navigation.homeScreen
import org.sopt.and.presentation.main.component.MainBottomBar
import org.sopt.and.presentation.mypage.navigation.myPageScreen
import org.sopt.and.presentation.search.navigation.searchScreen
import org.sopt.and.presentation.signin.navigation.SignIn
import org.sopt.and.presentation.signin.navigation.signInScreen
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
        val startDestination = getStartDestination()

        MainNavHost(
            navController = mainNavigator.navController,
            startDestination = startDestination,
            paddingValues = paddingValues
        )
    }
}

@Composable
private fun getStartDestination(): Route {
    val preference = LocalPreference.current
    return if (preference.id.isEmpty() || preference.password.isEmpty()) {
        SignIn
    } else {
        Home
    }
}

@Composable
private fun MainNavHost(
    navController: NavHostController,
    startDestination: Route,
    paddingValues: PaddingValues
) {
    val topBarModifier = Modifier
        .background(WavveBackground)
        .systemBarsPadding()

    val mainModifier = Modifier
        .background(WavveBackground)
        .statusBarsPadding()
        .padding(bottom = paddingValues.calculateBottomPadding())

    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            EnterTransition.None
        },
        exitTransition = {
            ExitTransition.None
        },
        popEnterTransition = {
            EnterTransition.None
        },
        popExitTransition = {
            ExitTransition.None
        },
    ) {
        signInScreen(
            navController = navController,
            modifier = topBarModifier
        )

        signUpScreen(
            navController = navController,
            modifier = topBarModifier
        )

        homeScreen(modifier = mainModifier)
        searchScreen(modifier = mainModifier)
        myPageScreen(
            navController = navController,
            modifier = mainModifier
        )
    }
}