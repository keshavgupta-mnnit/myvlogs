package com.kgcorp.corevloglibrary.models.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VlogDetailsModel(
    val vId: String,
    val date: String,
    val title: String,
    var displayImageUrl: String,
    val author: String,
    val postItemList: List<PostItemModel>,
    var totalLikes: Int = 0,
    var totalViews: Int = 0
): Parcelable