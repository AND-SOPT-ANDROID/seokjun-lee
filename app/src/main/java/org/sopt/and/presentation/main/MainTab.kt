package org.sopt.and.presentation.main

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import org.sopt.and.R
import org.sopt.and.core.navigation.MainTabRoute
import org.sopt.and.core.navigation.Route
import org.sopt.and.presentation.home.navigation.Home
import org.sopt.and.presentation.mypage.navigation.MyPage
import org.sopt.and.presentation.search.navigation.Search

enum class MainTab(
    @StringRes val titleRes: Int,
    val icon: ImageVector,
    val route: MainTabRoute
) {
    HOME(
        titleRes = R.string.maintab_home,
        icon = Icons.Outlined.Home,
        route = Home
    ),
    SEARCH(
        titleRes = R.string.maintab_search,
        icon = Icons.Outlined.Search,
        route = Search
    ),
    MYPAGE(
        titleRes = R.string.maintab_mypage,
        icon = Icons.Outlined.Person,
        route = MyPage
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}