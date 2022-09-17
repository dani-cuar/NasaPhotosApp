package com.cubidevs.mobiedbapp2022.local

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "table_photo")
data class LocalPhoto(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "urlPicture") val urlPicture: String?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "summary") val summary: String?
)