package org.sopt.and.core.data.mapper

import org.sopt.and.core.data.local.entity.StarredProgramEntity
import org.sopt.and.core.model.Program

fun Program.toStarredProgramEntity(): StarredProgramEntity = StarredProgramEntity(
    programName = this.title,
    programImage = this.imgFile
)