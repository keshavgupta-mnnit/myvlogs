package com.kgcorp.corevloglibrary.components.vlogDetailsComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kgcorp.corevloglibrary.models.ImagePostItemModel

@Composable
fun SingleImageItem(imagePostItemModel: ImagePostItemModel) {
    Box(
        Modifier.background(Color.White)
    ) {
        Column {
            AsyncImage(
                contentScale = ContentScale.Crop,
                model =imagePostItemModel.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .padding(all = 4.dp)
                    .fillMaxWidth()
            )

            SingleTextPostItem(data = imagePostItemModel.description)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SingleImageItemPreview() {
    SingleImageItem(
        ImagePostItemModel(
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fgirl-on-beach&psig=AOvVaw3w3V8ctiEFkS_yxdao_PFv&ust=1679339936917000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCMiIz_Ta6P0CFQAAAAAdAAAAABAE",
            "This is just for description sample",
        )
    )
}