package com.kgcorp.corevloglibrary.components.createVlogComponents

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun AddSingleImageItem(imageSrc: MutableState<String>) {
    val photoClickLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia(),
            onResult = { uri ->
                imageSrc.value = uri.toString()
            })
    if (imageSrc.value.isNotEmpty()) {
        AsyncImage(
            contentScale = ContentScale.Crop,
            model = imageSrc.value,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .padding(all = 4.dp)
                .fillMaxWidth()
        )
    } else {
        AddImageCard {
            photoClickLauncher.launch(
                PickVisualMediaRequest(
                    ActivityResultContracts.PickVisualMedia.ImageOnly
                )
            )
        }
    }
}