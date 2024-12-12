package org.sopt.and.domain.repository

import org.sopt.and.domain.entity.Program

interface PopularProgramRepository {
    fun getPopularSeries(): List<Program>
    fun getPopularMovies(): List<Program>
}