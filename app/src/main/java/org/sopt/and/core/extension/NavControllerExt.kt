package org.sopt.and.core.extension

import androidx.navigation.NavHostController

fun NavHostController.saveIdAndPassword(id: String, password: String) {
    this.previousBackStackEntry?.savedStateHandle?.run {
        set(ID_KEY, id)
        set(PASSWORD_KEY, password)
    }
}

fun NavHostController.getId(): String =
    this.currentBackStackEntry?.savedStateHandle?.get<String>(ID_KEY) ?: DEFAULT_VALUE

fun NavHostController.getPassword(): String =
    this.currentBackStackEntry?.savedStateHandle?.get<String>(PASSWORD_KEY) ?: DEFAULT_VALUE

private const val ID_KEY = "id"
private const val PASSWORD_KEY = "password"
private const val DEFAULT_VALUE = ""