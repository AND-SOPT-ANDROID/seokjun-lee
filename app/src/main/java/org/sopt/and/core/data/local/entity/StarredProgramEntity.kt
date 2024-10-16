package org.sopt.and.core.data.local.entity

import androidx.annotation.NonNull
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="starred")
data class StarredProgramEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,
    @NonNull
    @ColumnInfo(name = "program_name")
    val programName: String,
    @NonNull
    @ColumnInfo(name = "program_image")
    val programImage: Int
)