package org.sopt.and.core.data.repository

import kotlinx.coroutines.flow.Flow
import org.sopt.and.core.data.local.entity.StarredProgramEntity
import org.sopt.and.core.model.Program

interface StarredProgramRepository {
    fun getStarredPrograms(): Flow<List<StarredProgramEntity>>
    suspend fun postStarredProgram(program: Program)
    suspend fun deletedStarredProgram(program: Program)
}