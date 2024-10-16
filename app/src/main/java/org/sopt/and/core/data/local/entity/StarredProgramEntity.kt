package org.sopt.and.core.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Starred")
data class StarredProgramEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @NonNull
    @ColumnInfo(name = "program_name")
    val programName: String,
    @NonNull
    @ColumnInfo(name = "program_image")
    val programImage: Int
)