package com.cubidevs.mobiedbapp2022.server.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Item(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("data")
    val `data`: List<Data?>? = null,
    @SerializedName("links")
    val links: List<Link?>? = null
): Serializable