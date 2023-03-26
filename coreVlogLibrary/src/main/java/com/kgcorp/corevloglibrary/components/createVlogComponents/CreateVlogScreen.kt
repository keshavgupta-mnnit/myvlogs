package com.kgcorp.corevloglibrary.components.createVlogComponents

import android.widget.Toast
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

    var isDialog by remember {
        mutableStateOf(false)
    }
    var isDialog2 by remember {
        mutableStateOf(false)
    }
    if(isDialog)
        CustomAddTextItemDialog(
            content = { /*TODO*/ },
            onAddClick = { i: Int, postItemModel: PostItemModel ->
                itemsList.add(postItemModel)
                isDialog = false
            } ,
            onDismiss = { isDialog = false },
            title = "Add Text",
            subtitle = "Likhdo bhai kuch panktiya"
        )

    if(isDialog2)
        CustomAddImageItemDialog(
            content = { /*TODO*/ },
            onAddClick = { i: Int, postItemModel: PostItemModel ->
                itemsList.add(postItemModel)
                isDialog2 = false
            } ,
            onDismiss = { isDialog2 = false },
            title = "Add Image",
            subtitle = "Kuch photu dedo"
        )

    val fabMenu = listOf(
        FabActionItemModel(
            ImageVector.vectorResource(id = R.drawable.ic_heart),
            "Text Only"
        ) {
            isDialog = true
        },
        FabActionItemModel(
            ImageVector.vectorResource(id = R.drawable.ic_view),
            "With Image"
        ) {
            isDialog2 = true
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