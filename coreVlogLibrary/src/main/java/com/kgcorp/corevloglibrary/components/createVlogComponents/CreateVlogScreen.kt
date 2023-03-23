package com.kgcorp.corevloglibrary.components.createVlogComponents

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import com.kgcorp.corevloglibrary.R
import com.kgcorp.corevloglibrary.models.datamodels.PostItemModel
import com.kgcorp.corevloglibrary.models.datamodels.TextPostItemModel
import com.kgcorp.corevloglibrary.models.uimodels.FabActionItemModel
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun CreateVlogScreen() {
    var isFabActive by remember {
        mutableStateOf(false)
    }
    val ctx = LocalContext.current

    var isDialog by remember {
        mutableStateOf(false)
    }
    if(isDialog)
        CustomAddItemDialog(
            content = { /*TODO*/ },
            onAddClick = { i: Int, postItemModel: PostItemModel ->
                Toast.makeText(ctx, "i: $i postItemModel: ${(postItemModel as TextPostItemModel).txt[0]}", Toast.LENGTH_LONG).show()
                isDialog = false
            } ,
            onDismiss = { isDialog = false },
            title = "Add Text",
            subtitle = "Likhdo bhai kuch panktiya"
        )

    val fabMenu = listOf(
        FabActionItemModel(
            ImageVector.vectorResource(id = R.drawable.ic_heart),
            "Text Only"
        ) {
//            Toast.makeText(ctx, "Text Only", Toast.LENGTH_LONG).show()
            isDialog = true
        },
        FabActionItemModel(
            ImageVector.vectorResource(id = R.drawable.ic_view),
            "With Image"
        ) {
            Toast.makeText(ctx, "With Image", Toast.LENGTH_LONG).show()
        }
    )
    Scaffold(floatingActionButton = {
        CreateVlogFab(isFabActive, fabMenu) { isFabActive = it }
    }) { padding ->
        Text(modifier = Modifier.padding(padding), text = "Hi")
    }

}