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

    var token: String
        get() = preference.getString(TOKEN, DEFAULT_STRING).toString()
        set(value) = preference.edit().putString(TOKEN, value).apply()

    fun clearToken() {
        token = ""
    }

    companion object {
        private const val PREF_NAME = "wavve_prefs"
        private const val TOKEN = "TOKEN"
        private const val DEFAULT_STRING = ""


        val LocalPreference = staticCompositionLocalOf<PreferenceUtil> {
            error("PreferenceUtil is not initialized")
        }
    }
}