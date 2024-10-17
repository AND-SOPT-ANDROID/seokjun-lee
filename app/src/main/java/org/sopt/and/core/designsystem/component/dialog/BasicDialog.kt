package org.sopt.and.core.designsystem.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.sopt.and.core.designsystem.component.BasicPreview
import org.sopt.and.core.designsystem.theme.WavveBackground
import org.sopt.and.core.designsystem.theme.White
import org.sopt.and.core.extension.noRippleClickable

@Composable
fun BasicDialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    properties: DialogProperties = DialogProperties(),
    contentColor: Color = White,
    containerColor: Color = WavveBackground,
    title: String = "",
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = containerColor, shape = RoundedCornerShape(10.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = title,
                    modifier = Modifier.align(Alignment.Center),
                    color = contentColor
                )

                Icon(
                    imageVector = Icons.Outlined.Close,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .noRippleClickable(
                            onDismissRequest
                        ),
                    tint = contentColor,
                )
            }
            content()
        }

    }
}

@BasicPreview
@Composable
private fun BasicDialogPreview() {
    BasicDialog(
        onDismissRequest = { },
        content = { },
        title = "테스트"
    )
}