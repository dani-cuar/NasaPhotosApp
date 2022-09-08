package com.cubidevs.mobiedbapp2022.server.model


import com.google.gson.annotations.SerializedName

data class Collection(
    @SerializedName("version")
    val version: String? = "",
    @SerializedName("href")
    val href: String? = "",
    @SerializedName("items")
    val items: List<Item>? = listOf(),
    @SerializedName("metadata")
    val metadata: Metadata? = Metadata(),
    @SerializedName("links")
    val links: List<LinkX>? = listOf()


)