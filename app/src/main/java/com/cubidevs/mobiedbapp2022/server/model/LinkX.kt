package com.cubidevs.mobiedbapp2022.server.model


import com.google.gson.annotations.SerializedName

data class LinkX(
    @SerializedName("rel")
    val rel: String? = null,
    @SerializedName("prompt")
    val prompt: String? = null,
    @SerializedName("href")
    val href: String? = null
)