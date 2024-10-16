package org.sopt.and.core.model

import org.sopt.and.R

data class Program(
    val title: String,

    /**추후 과제에사 수정될 것 같아서 @DrawableRes를 추가하지 않음*/
    val imgFile: Int = R.drawable.img_banner2
)
