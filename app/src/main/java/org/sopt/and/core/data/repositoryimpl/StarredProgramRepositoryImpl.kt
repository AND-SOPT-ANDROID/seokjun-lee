package org.sopt.and.core.data.repositoryimpl

import kotlinx.coroutines.flow.Flow
import org.sopt.and.core.data.local.database.StarredProgramDatabase
import org.sopt.and.core.data.local.entity.StarredProgramEntity
import org.sopt.and.core.data.mapper.toStarredProgramEntity
import org.sopt.and.core.data.repository.StarredProgramRepository
import org.sopt.and.core.model.Program
import javax.inject.Inject

class StarredProgramRepositoryImpl @Inject constructor(
    private val starredProgramDatabase: StarredProgramDatabase
): StarredProgramRepository {
    override fun getStarredPrograms(): Flow<List<StarredProgramEntity>> = starredProgramDatabase.starredProgramDao().getAllStarredPrograms()

    override suspend fun postStarredProgram(program: Program) {
        starredProgramDatabase.starredProgramDao().insertStarredProgram(program.toStarredProgramEntity())
    }

    override suspend fun deletedStarredProgram(program: Program) {
        starredProgramDatabase.starredProgramDao().deleteStarredProgram(program.title)
    }

}