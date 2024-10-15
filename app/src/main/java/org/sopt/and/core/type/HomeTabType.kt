package org.sopt.and.core.type

import androidx.annotation.StringRes
import org.sopt.and.R

enum class HomeTabType(
    @StringRes val titleRes: Int,
) {
    NEW_CLASSIC(R.string.home_tab_new_classic),
    DRAMA(R.string.home_tab_drama),
    ENTERTAINMENT(R.string.home_tab_entertainment),
    MOVIE(R.string.home_tab_movie),
    ANIMATION(R.string.home_tab_animation),
    OVERSEA(R.string.home_tab_oversea),
    DOCUMENTARY(R.string.home_tab_documentary),
    KIDS(R.string.home_tab_kids),
    MOVIE_PLUS(R.string.home_tab_movie_plus)
}