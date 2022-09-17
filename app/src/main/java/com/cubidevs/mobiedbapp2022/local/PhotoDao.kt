package com.cubidevs.mobiedbapp2022.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PhotoDao {

    @Insert
    suspend fun createPhoto(photo: LocalPhoto)

    @Query("SELECT * FROM table_photo")
    suspend fun getPhotos() : MutableList<LocalPhoto>

    @Delete
    suspend fun deletePhoto(localPhoto: LocalPhoto)

    @Query("SELECT * FROM table_photo WHERE id LIKE :nasaId")
    suspend fun searchPhoto(nasaId: String?): LocalPhoto
}