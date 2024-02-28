package com.mokshith.gittest.roomDB

import androidx.room.PrimaryKey

sealed interface SignUpEvents {
    data class SaveSignUpData(
        val firstName: String,
        val lastName: String,
        val email: String,
        val password: String
    ) : SignUpEvents
}