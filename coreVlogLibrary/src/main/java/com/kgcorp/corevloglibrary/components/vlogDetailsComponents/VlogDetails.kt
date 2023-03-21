package com.kgcorp.corevloglibrary.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.kgcorp.corevloglibrary.models.ImagePostItemModel
import com.kgcorp.corevloglibrary.models.MultipleImagePostItemModel
import com.kgcorp.corevloglibrary.models.TextPostItemModel
import com.kgcorp.corevloglibrary.models.VlogDetailsModel

@Composable
fun VlogDetails(model: VlogDetailsModel) {
    LazyColumn(modifier = Modifier.fillMaxWidth().background(Color.White)) {
        item { SingleTextPostItem(data = model.title) }
        item { SingleTextPostItem(data = "Created by ${model.author}") }
        item { SingleTextPostItem(data = "On : ${model.date}") }
        items(model.postItemList) { vlogItem ->
            when (vlogItem) {
                is TextPostItemModel -> {
//                    TextPostItem(textItem = vlogItem)
                    vlogItem.txt.forEach{
                        SingleTextPostItem(data = it)
                    }
                }
                is ImagePostItemModel -> {
                    SingleImageItem(imagePostItemModel = vlogItem)
                }
                is MultipleImagePostItemModel -> {
                    MultipleImageItem(model = vlogItem)
                }
            }
        }

    }
}