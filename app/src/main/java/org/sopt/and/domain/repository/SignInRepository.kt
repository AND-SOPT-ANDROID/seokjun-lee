package org.sopt.and.domain.repository

interface SignInRepository {
    fun getIdFromPref(): String
    fun setIdInPreference(id: String)
    fun getPasswordFromPref(): String
    fun setPasswordInPreference(password: String)
}