package org.sopt.and.core.preference

import android.content.Context
import androidx.compose.runtime.staticCompositionLocalOf
import dagger.hilt.android.qualifiers.ApplicationContext

class PreferenceUtil(
    @ApplicationContext private val context: Context
) {
    private val preference = context.getSharedPreferences(
        PREF_NAME, Context.MODE_PRIVATE
    )

    var id: String
        get() = preference.getString(ID, DEFAULT_STRING).toString()
        set(value) = preference.edit().putString(ID, value).apply()

    var password: String
        get() = preference.getString(PASSWORD, DEFAULT_STRING).toString()
        set(value) = preference.edit().putString(PASSWORD, value).apply()

    companion object {
        private const val PREF_NAME = "wavve_prefs"
        private const val ID = "ID"
        private const val PASSWORD = "PASSWORD"
        private const val DEFAULT_STRING = ""

        val LocalPreference = staticCompositionLocalOf<PreferenceUtil> {
            error("PreferenceUtil is not initialized")
        }
    }
}