package com.cubidevs.mobiedbapp2022.server

import com.cubidevs.mobiedbapp2022.server.model.NasaList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search?q=apollo%2011")
    suspend fun getPhotos(): NasaList

}