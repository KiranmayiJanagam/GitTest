package com.mokshith.gittest.roomDB.dbInterface

import androidx.lifecycle.LiveData

import com.mokshith.gittest.roomDB.UserData

//@Dao
interface DeoClass {

//    //I used Upsert instead of Insert because it is max of updating and inserting
//    @Upsert
//    suspend fun upsertSignUpData(users: UserData): String
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertSignUpData(users: UserData): Boolean
//
//    @Update(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun updateSignUpData(users: UserData)
//
//    // userData is the table name of the UserData Class
//    @Query("SELECT * FROM userData WHERE email =:email")
//    suspend fun getUserData(email: String): LiveData<UserData>
//
//    @Delete
//    suspend fun deleteSignUpData(userData: UserData): String
}