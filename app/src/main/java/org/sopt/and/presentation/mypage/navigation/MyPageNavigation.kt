package org.sopt.and.presentation.mypage.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import kotlinx.serialization.Serializable
import org.sopt.and.core.navigation.MainTabRoute
import org.sopt.and.presentation.mypage.MyPageRoute
import org.sopt.and.presentation.signin.navigation.navigateToSignIn

fun NavController.navigateToMyPage(navOptions: NavOptions? = null) = navigate(MyPage, navOptions)

fun NavGraphBuilder.myPageScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    composable<MyPage> {
        MyPageRoute(
            onLogout = {
                navController.navigateToSignIn(
                    navOptions = navOptions {
                        popUpTo(0) { inclusive = true }
                    }
                )
            },
            modifier = modifier)
    }
}

@Serializable
data object MyPage : MainTabRoute