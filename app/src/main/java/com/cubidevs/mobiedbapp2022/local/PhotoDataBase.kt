package com.cubidevs.mobiedbapp2022.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalPhoto::class], version = 1)
abstract class PhotoDataBase : RoomDatabase(){

    abstract fun PhotoDao(): PhotoDao
}