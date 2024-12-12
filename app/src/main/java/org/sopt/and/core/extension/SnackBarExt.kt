package org.sopt.and.core.extension

import android.content.Context
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import org.sopt.and.R

suspend fun SnackbarHostState.showWavveSnackBar(
    context: Context,
    message: String
) {
    showSnackbar(
        message = message,
        actionLabel = context.getString(R.string.mypage_snackbar_cancel),
        duration = SnackbarDuration.Short
    )
}