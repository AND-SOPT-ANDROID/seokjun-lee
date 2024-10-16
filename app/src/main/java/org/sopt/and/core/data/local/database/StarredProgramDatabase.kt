package org.sopt.and.core.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.sopt.and.core.data.local.dao.StarredProgramDao
import org.sopt.and.core.data.local.entity.StarredProgramEntity

@Database(entities = [StarredProgramEntity::class], version = 2, exportSchema = false)
abstract class StarredProgramDatabase : RoomDatabase() {
    abstract fun starredProgramDao(): StarredProgramDao

    companion object{
        @Volatile
        private var Instance: StarredProgramDatabase? = null

        fun getDatabase(context: Context): StarredProgramDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, StarredProgramDatabase::class.java, "starred_program")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}