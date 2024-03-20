package com.mokshith.gittest.roomDB

//import androidx.room.Entity
//import androidx.room.PrimaryKey

//@Entity(tableName = "userData")
data class UserData(
    val firstName: String,
    val lastName: String,
    //@PrimaryKey val email: String,
    val password: String
)
