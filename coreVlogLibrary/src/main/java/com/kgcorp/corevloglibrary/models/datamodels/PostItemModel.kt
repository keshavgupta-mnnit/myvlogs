package com.kgcorp.corevloglibrary.models.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class PostItemModel : Parcelable

data class ImagePostItemModel(
    val imageUrls: List<String>,
    val description: String
) : PostItemModel()

data class TextPostItemModel(
    val txt: List<String>
) : PostItemModel()