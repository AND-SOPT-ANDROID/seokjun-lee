package org.sopt.and.domain.repository

import kotlinx.coroutines.flow.Flow
import org.sopt.and.domain.entity.Program
import org.sopt.and.data.local.entity.StarredProgramEntity

interface StarredProgramRepository {
    fun getStarredPrograms(): Flow<List<StarredProgramEntity>>
    suspend fun postStarredProgram(program: Program)
    suspend fun deletedStarredProgram(program: Program)
}