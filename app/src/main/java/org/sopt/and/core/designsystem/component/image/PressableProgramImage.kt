package org.sopt.and.core.designsystem.component.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.BasicPreview

@Composable
fun PressableProgramImage(
    @DrawableRes imgRes: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    onItemPress: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    var pressStartTime by remember { mutableStateOf<Long?>(null) }
    var isPressing by remember { mutableStateOf(false) }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> {
                    pressStartTime = System.currentTimeMillis()
                    isPressing = true
                }

                is PressInteraction.Release, is PressInteraction.Cancel -> {
                    isPressing = false
                    pressStartTime = null
                }
            }
        }
    }

    LaunchedEffect(isPressing) {
        while (isPressing) {
            pressStartTime?.let { startTime ->
                val pressDuration = System.currentTimeMillis() - startTime
                if (pressDuration > 500L) {
                    onItemPress()
                    isPressing = false
                    pressStartTime = null
                }
            }
            delay(100L)
        }
    }

    ProgramImage(
        imgRes = imgRes,
        contentDescription = contentDescription,
        modifier = modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = {}
        )
    )
}

@BasicPreview
@Composable
private fun PressableProgramImagePreview() {
    PressableProgramImage(
        imgRes = R.drawable.img_banner2,
        contentDescription = ""
    )
}