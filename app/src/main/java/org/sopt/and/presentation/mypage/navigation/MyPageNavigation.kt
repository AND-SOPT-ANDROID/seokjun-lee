package org.sopt.and.presentation.mypage.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.and.core.navigation.MainTabRoute
import org.sopt.and.presentation.mypage.MyPageRoute

fun NavController.navigateToMyPage(navOptions: NavOptions? = null) = navigate(MyPage, navOptions)

fun NavGraphBuilder.myPageScreen(
    navigateToSignIn:() -> Unit,
    modifier: Modifier = Modifier
) {
    composable<MyPage> {
        MyPageRoute(
            onLogout = navigateToSignIn,
            modifier = modifier)
    }
}

@Serializable
data object MyPage : MainTabRoute