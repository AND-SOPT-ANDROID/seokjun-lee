package org.sopt.and.core.designsystem.component.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.BasicPreview
import org.sopt.and.core.designsystem.component.button.RoundedCornerButton
import org.sopt.and.core.designsystem.theme.Grey400
import org.sopt.and.core.designsystem.theme.White

@Composable
fun ConfirmDialog(
    text: String,
    title: String,
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    onConfirm: () -> Unit = {}
) {
    BasicDialog(
        onDismissRequest = onDismissRequest,
        title = title,
        modifier = modifier.height(200.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = White,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )

            Spacer(modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                val buttonModifier = Modifier
                    .wrapContentHeight()
                    .weight(1f)

                val buttonTextStyle = TextStyle.Default.copy(
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )

                RoundedCornerButton(
                    text = stringResource(R.string.dialog_delete_cancel),
                    onClick = onConfirm,
                    textStyle = buttonTextStyle,
                    modifier = buttonModifier,
                    containerColor = Grey400
                )

                RoundedCornerButton(
                    text = stringResource(R.string.dialog_delete_confirm),
                    onClick = onConfirm,
                    textStyle = buttonTextStyle,
                    modifier = buttonModifier
                )
            }
        }
    }
}

@BasicPreview
@Composable
private fun TwoButtonDialogPreview() {
    ConfirmDialog(
        text = "리스트에서 삭제하시겠습니까?",
        title = stringResource(R.string.dialog_delete_title)
    )
}