package com.cubidevs.mobiedbapp2022.server.nasarepository

import com.cubidevs.mobiedbapp2022.server.NasaDB

class NasaRepository {

    //private val apiKey = "VBNh3C3075mBWZ2rRVr6sMCjLQfCFQLwkOQoX5pY"

    suspend  fun getPhotos() = NasaDB.retrofit.getPhotos()

}