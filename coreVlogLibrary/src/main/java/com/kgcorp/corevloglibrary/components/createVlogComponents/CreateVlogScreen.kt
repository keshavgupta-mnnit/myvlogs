package com.kgcorp.corevloglibrary.components.createVlogComponents

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import com.kgcorp.corevloglibrary.R
import com.kgcorp.corevloglibrary.components.vlogDetailsComponents.MultipleImageItem
import com.kgcorp.corevloglibrary.components.vlogDetailsComponents.SingleImageItem
import com.kgcorp.corevloglibrary.components.vlogDetailsComponents.TextPostItem
import com.kgcorp.corevloglibrary.models.datamodels.ImagePostItemModel
import com.kgcorp.corevloglibrary.models.datamodels.PostItemModel
import com.kgcorp.corevloglibrary.models.datamodels.TextPostItemModel
import com.kgcorp.corevloglibrary.models.uimodels.FabActionItemModel
import com.ramcosta.composedestinations.annotation.Destination


enum class CreateVlogDialogState {
    HIDDEN, SHOW_ADD_IMAGE, SHOW_ADD_TEXT
}

@Destination
@Composable
fun CreateVlogScreen() {
    val itemsList = remember {
        mutableStateListOf<PostItemModel>()
    }
    var isFabActive by remember {
        mutableStateOf(false)
    }
    val ctx = LocalContext.current

    var isDialogState by remember {
        mutableStateOf(CreateVlogDialogState.HIDDEN)
    }

    if(isDialogState == CreateVlogDialogState.SHOW_ADD_TEXT)
        CustomAddTextItemDialog(
            onAddClick = { i: Int, postItemModel: PostItemModel ->
                itemsList.add(postItemModel)
                isDialogState = CreateVlogDialogState.HIDDEN
            } ,
            onDismiss = { isDialogState = CreateVlogDialogState.HIDDEN },
            title = "Add Text"
        )

    if(isDialogState == CreateVlogDialogState.SHOW_ADD_IMAGE)
        CustomAddImageItemDialog(
            onAddClick = { i: Int, postItemModel: PostItemModel ->
                itemsList.add(postItemModel)
                isDialogState = CreateVlogDialogState.HIDDEN
            } ,
            onDismiss = { isDialogState = CreateVlogDialogState.HIDDEN },
            title = "Add Image"
        )

    val fabMenu = listOf(
        FabActionItemModel(
            ImageVector.vectorResource(id = R.drawable.ic_add_text),
            "Text Only"
        ) {
            isDialogState = CreateVlogDialogState.SHOW_ADD_TEXT
        },
        FabActionItemModel(
            ImageVector.vectorResource(id = R.drawable.ic_add_photo),
            "With Image"
        ) {
            isDialogState = CreateVlogDialogState.SHOW_ADD_IMAGE
        }
    )
    Scaffold(floatingActionButton = {
        CreateVlogFab(isFabActive, fabMenu) { isFabActive = it }
    }) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)){
            itemsList.forEach { vlogItem->
                when (vlogItem) {
                    is TextPostItemModel -> {
                        TextPostItem(textItem = vlogItem)
                    }
                    is ImagePostItemModel -> {
                        if (vlogItem.imageUrls.size == 1) {
                            item {
                                SingleImageItem(vlogItem.imageUrls[0], vlogItem.description)
                            }
                        } else if (vlogItem.imageUrls.size > 1){
                            item {
                                MultipleImageItem(vlogItem.imageUrls, vlogItem.description)
                            }
                        }
                    }
                }
            }
        }
    }
}