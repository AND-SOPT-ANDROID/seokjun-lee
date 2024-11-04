package org.sopt.and.domain.mapper

import org.sopt.and.core.model.Program
import org.sopt.and.data.local.entity.StarredProgramEntity

fun Program.toStarredProgramEntity(): StarredProgramEntity = StarredProgramEntity(
    programName = this.title,
    programImage = this.imgFile
)