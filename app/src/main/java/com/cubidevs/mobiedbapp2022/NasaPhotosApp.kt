package com.cubidevs.mobiedbapp2022

import android.app.Application
import androidx.room.Room
import com.cubidevs.mobiedbapp2022.local.PhotoDataBase

class NasaPhotosApp : Application(){

    companion object{
        lateinit var dataBase: PhotoDataBase
    }

    override fun onCreate() {
        super.onCreate()
        dataBase = Room.databaseBuilder(
            this,
            PhotoDataBase::class.java,
            "photo_db"
        ).build()
    }
}