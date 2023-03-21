package com.kgcorp.corevloglibrary.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class PostItemModel : Parcelable

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