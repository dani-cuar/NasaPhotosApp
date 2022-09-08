package com.cubidevs.mobiedbapp2022.server.model


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("href") //link de imagen
    val href: String? = null,
    @SerializedName("rel")  //"preview"
    val rel: String? = null,
    @SerializedName("render")  //"image"
    val render: String? = null
)