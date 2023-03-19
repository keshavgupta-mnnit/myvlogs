package com.kgcorp.corevloglibrary.models

sealed class PostItemModel

data class ImagePostItemModel(
    val imageUrl: String,
    val description: String
) : PostItemModel()

data class MultipleImagePostItemModel(
    val imageUrls: List<String>,
    val description: String
) : PostItemModel()

data class TextPostItemModel(
    val txt: List<String>
) : PostItemModel()