package com.cubidevs.mobiedbapp2022.server.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("center")
    val center: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("keywords")
    val keywords: List<String?>? = null,
    @SerializedName("nasa_id")
    val nasaId: String? = null,
    @SerializedName("date_created")
    val dateCreated: String? = null,
    @SerializedName("media_type")
    val mediaType: String? = null,
    @SerializedName("album")
    val album: List<String?>? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("photographer")
    val photographer: String? = null

)