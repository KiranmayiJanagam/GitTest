package com.mokshith.gittest.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mokshith.gittest.roomDB.dbInterface.DeoClass

@Database(
    entities = [UserData::class],
    version = 1
)
abstract class DataBaseRome : RoomDatabase() {

    //Property must be initialized or be abstract
    abstract fun userDeo(): DeoClass
}