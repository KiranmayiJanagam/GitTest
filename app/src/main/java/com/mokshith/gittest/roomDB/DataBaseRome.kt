package com.mokshith.gittest.roomDB

import com.mokshith.gittest.roomDB.dbInterface.DeoClass

//@Database(
//    entities = [UserData::class],
//    version = 1
//)
abstract class DataBaseRome  {

    //Property must be initialized or be abstract
    abstract fun userDeo(): DeoClass
}