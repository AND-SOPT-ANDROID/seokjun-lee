package org.sopt.and.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.sopt.and.core.data.local.entity.StarredProgramEntity

@Dao
interface StarredProgramDao {
    @Query("SELECT * FROM starred")
    suspend fun getAllStarredPrograms(): Flow<List<StarredProgramEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStarredProgram(program: StarredProgramEntity)

    @Query("DELETE FROM Starred WHERE program_name = :programName")
    suspend fun deleteStarredProgram(programName: String)
}