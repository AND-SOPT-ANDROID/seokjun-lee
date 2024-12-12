package org.sopt.and.data.mapper

import org.sopt.and.domain.entity.Program
import org.sopt.and.data.local.entity.StarredProgramEntity

fun Program.toStarredProgramEntity(): StarredProgramEntity = StarredProgramEntity(
    programName = this.title,
    programImage = this.imgFile
)