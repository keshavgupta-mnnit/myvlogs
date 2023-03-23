package com.kgcorp.corevloglibrary.components.vlogDetailsComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MultipleImageItem(imageUrls: List<String>, description: String) {
    Box(
        Modifier.background(Color.White)
    ) {
        Column {
            val pager = rememberPagerState(
                pageCount = imageUrls.size,
            )
            SingleTextPostItem(data = description)
            HorizontalPager(
                state = pager,
                itemSpacing = 8.dp
            ) { item ->
                AsyncImage(
                    contentScale = ContentScale.FillBounds,
                    model = imageUrls[item],
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                        .padding(all = 4.dp)
                )
            }
            HorizontalPagerIndicator(
                pagerState = pager,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(20.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MultipleImageItemPreview() {
    MultipleImageItem(
        listOf(
            "https://cdn.pixabay.com/photo/2023/01/01/21/33/mountain-7690893_1280.jpg",
            "https://media.istockphoto.com/id/531444381/photo/glacier-bay-in-mountains-alaska-united-states.webp?s=1024x1024&w=is&k=20&c=z6PA2NF144Y3xubzQYJquvMH1K2LLYVAJKYjeycWLX4=",
            "https://media.istockphoto.com/id/119889938/photo/waterfall-in-deep-forest.webp?s=1024x1024&w=is&k=20&c=nm4bomRW_IG4juvYI1vtSTw0xplCuMOyEMK8zBvvrCM="
        ),
        "This is just for description sample",
    )
}