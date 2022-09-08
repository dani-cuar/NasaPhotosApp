package com.cubidevs.mobiedbapp2022.server.model


import com.google.gson.annotations.SerializedName

data class NasaList(
    @SerializedName("collection")
    val collection: Collection? = Collection()
)