package org.sopt.and.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.and.core.designsystem.theme.WavveBackground

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize().background(WavveBackground)
    )
}