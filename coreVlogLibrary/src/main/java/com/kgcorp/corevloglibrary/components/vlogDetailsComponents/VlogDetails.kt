package com.kgcorp.corevloglibrary.components.vlogDetailsComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kgcorp.corevloglibrary.models.datamodels.ImagePostItemModel
import com.kgcorp.corevloglibrary.models.datamodels.TextPostItemModel
import com.kgcorp.corevloglibrary.models.datamodels.VlogDetailsModel

@Composable
fun VlogDetails(model: VlogDetailsModel) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 16.dp)
    ) {
        item { SingleTextPostItem(data = model.title) }
        item { SingleTextPostItem(data = "Created by ${model.author}") }
        item { SingleTextPostItem(data = "On : ${model.date}") }
        model.postItemList.forEach { vlogItem ->
            when (vlogItem) {
                is TextPostItemModel -> {
                    TextPostItem(textItem = vlogItem)
                }
                is ImagePostItemModel -> {
                    if (vlogItem.imageUrls.size == 1) {
                        item {
                            SingleImageItem(vlogItem.imageUrls[0], vlogItem.description)
                        }
                    } else {
                        item {
                            MultipleImageItem(vlogItem.imageUrls, vlogItem.description)
                        }
                    }

                }
            }
        }

    }
}