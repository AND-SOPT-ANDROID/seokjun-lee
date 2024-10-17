package org.sopt.and.core.extension

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import org.sopt.and.R

suspend fun SnackbarHostState.showWavveSnackBar(
    context: Context,
    @StringRes messageId: Int
) {
    showSnackbar(
        message = context.getString(messageId),
        actionLabel = context.getString(R.string.mypage_snackbar_cancel),
        duration = SnackbarDuration.Short
    )
}