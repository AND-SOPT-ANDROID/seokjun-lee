package org.sopt.and.core.type

import androidx.annotation.StringRes
import org.sopt.and.R

enum class SearchTabType(
    @StringRes
    val titleRes: Int,
) {
    SERIES(R.string.search_tab_popular_series),
    MOVIES(R.string.search_tab_popular_movies),
}