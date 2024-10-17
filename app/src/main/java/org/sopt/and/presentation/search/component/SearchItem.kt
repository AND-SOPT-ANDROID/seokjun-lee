package org.sopt.and.presentation.search.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.BasicPreview
import org.sopt.and.core.designsystem.theme.White

@Composable
fun SearchItem(
    text: String,
    contentDescription: String,
    imageFile: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(imageFile),
            contentDescription = contentDescription,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = text,
            color = White,
            fontSize = 14.sp,
            maxLines = 2,
            modifier = Modifier.weight(2f)
        )
    }
}

@BasicPreview
@Composable
private fun SearchItemPreview() {
    Box {
        SearchItem(
            text = "국가대표",
            contentDescription = "국가대표",
            imageFile = R.drawable.img_banner2,
            modifier = Modifier.height(100.dp)
        )
    }
}


