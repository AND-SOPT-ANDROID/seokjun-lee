package org.sopt.and.core.data.mapper

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.and.core.data.local.entity.StarredProgramEntity
import org.sopt.and.core.model.Program

fun Program.toStarredProgramEntity(): StarredProgramEntity = StarredProgramEntity(
    programName = this.title,
    programImage = this.imgFile
)