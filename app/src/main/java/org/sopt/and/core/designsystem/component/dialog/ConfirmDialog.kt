package org.sopt.and.core.designsystem.component.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.BasicPreview
import org.sopt.and.core.designsystem.theme.White

@Composable
fun ConfirmDialog(
    text: String,
    title: String,
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    onConfirm:() -> Unit = {}
) {
    BasicDialog(
        onDismissRequest = onDismissRequest,
        title = title,
        modifier = modifier.height(250.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text,
                color = White
            )

            Spacer(modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = onDismissRequest
                ) {
                    Text(
                        text = "취소",
                        color = White
                    )
                }

                Button(
                    modifier = Modifier.weight(1f),
                    onClick = onConfirm
                ) {
                    Text(
                        text = "확인",
                        color = White
                    )
                }
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