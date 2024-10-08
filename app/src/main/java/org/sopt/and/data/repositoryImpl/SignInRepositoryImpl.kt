package org.sopt.and.data.repositoryImpl

import org.sopt.and.core.preference.PreferenceUtil
import org.sopt.and.domain.repository.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val preferenceUtil: PreferenceUtil
): SignInRepository {
    override fun getIdFromPref(): String = preferenceUtil.id

    override fun setIdInPreference(id: String) { preferenceUtil.id = id }

    override fun getPasswordFromPref(): String = preferenceUtil.password

    override fun setPasswordInPreference(password: String) { preferenceUtil.password = password }
}