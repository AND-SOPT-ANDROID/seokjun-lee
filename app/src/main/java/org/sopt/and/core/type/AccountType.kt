package org.sopt.and.core.type

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color


//TODO: iconRes 추가
enum class AccountType(
    val typeName: String,
    @DrawableRes
    val iconRes: Int,
    val color: Color
) {
    KAKAO(
        typeName = "kakao",
        iconRes = 0,
        color = Color.Yellow
    ),
    TWORLD(
        typeName = "tworld",
        iconRes = 0,
        color = Color.Blue
    ),
    NAVER(
        typeName = "naver",
        iconRes = 0,
        color = Color.Green
    ),
    FACEBOOK(
        typeName = "facebook",
        iconRes = 0,
        color = Color.Cyan
    ),
    APPLE(
        typeName = "apple",
        iconRes = 0,
        color = Color.White
    )

}