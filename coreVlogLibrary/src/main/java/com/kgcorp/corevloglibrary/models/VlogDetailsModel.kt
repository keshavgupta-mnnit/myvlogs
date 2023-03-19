package com.kgcorp.corevloglibrary.models

data class VlogDetailsModel(
    val vId : String,
    val date: String,
    val title: String,
    val author:String,
    val postItemList: List<PostItemModel>
)