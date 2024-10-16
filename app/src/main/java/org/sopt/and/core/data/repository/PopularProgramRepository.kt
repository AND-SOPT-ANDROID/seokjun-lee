package org.sopt.and.core.data.repository

interface PopularProgramRepository {
    fun getPopularSeries(): List<String>
    fun getPopularMovies(): List<String>
}