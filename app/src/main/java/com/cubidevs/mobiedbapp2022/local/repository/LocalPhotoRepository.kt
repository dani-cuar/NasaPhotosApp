package com.cubidevs.mobiedbapp2022.local.repository

import com.cubidevs.mobiedbapp2022.NasaPhotosApp
import com.cubidevs.mobiedbapp2022.local.LocalPhoto
import com.cubidevs.mobiedbapp2022.local.PhotoDao

class LocalPhotoRepository {

    suspend fun savePhoto(localPhoto: LocalPhoto) {

        val photoDao : PhotoDao = NasaPhotosApp.dataBase.PhotoDao()
        photoDao.createPhoto(localPhoto)
    }

    suspend fun getPhotos() = NasaPhotosApp.dataBase.PhotoDao().getPhotos()

    suspend fun deleteMovie(localPhoto: LocalPhoto) {
        val photoDao : PhotoDao = NasaPhotosApp.dataBase.PhotoDao()
        photoDao.deletePhoto(localPhoto)
    }

    suspend fun searchPhoto(nasaId: String?) = NasaPhotosApp.dataBase.PhotoDao().searchPhoto(nasaId)


}