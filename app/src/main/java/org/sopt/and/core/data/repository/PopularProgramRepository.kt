package org.sopt.and.core.data.repository

import org.sopt.and.core.model.Program

interface PopularProgramRepository {
    fun getPopularSeries(): List<Program>
    fun getPopularMovies(): List<Program>
}