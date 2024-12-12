package org.sopt.and.data.repositoryimpl

import org.sopt.and.data.datasource.UserDataSource
import org.sopt.and.domain.entity.Hobby
import org.sopt.and.domain.repository.MyHobbyRepository
import javax.inject.Inject

class MyHobbyRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : MyHobbyRepository {

    override suspend fun getMyHobby(token: String): Result<Hobby> = runCatching {
        val response = userDataSource.getMyHobby(token)
        Hobby(response.result.hobby)
    }
}