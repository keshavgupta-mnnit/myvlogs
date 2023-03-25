package com.kgcorp.corevloglibrary.models.uimodels

import androidx.compose.runtime.MutableState


sealed class PostItemUiModel
data class ImagePostItemUiModel(
    val imageUrls: List<String>,
    val description: String
) : PostItemUiModel()

data class TextPostItemUiModel(
    val txt: MutableState<String>
) : PostItemUiModel()