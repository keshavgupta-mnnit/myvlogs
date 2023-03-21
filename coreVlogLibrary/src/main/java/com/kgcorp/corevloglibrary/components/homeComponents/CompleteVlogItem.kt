package com.kgcorp.corevloglibrary.components.homeComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kgcorp.corevloglibrary.R
import com.kgcorp.corevloglibrary.components.destinations.VlogDetailScreenDestination
import com.kgcorp.corevloglibrary.models.VlogDetailsModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CompleteVlogItem(
    model: VlogDetailsModel,
    navigator: DestinationsNavigator
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White),
        onClick = {
            navigator.navigate(
                VlogDetailScreenDestination(model)
            )
        }
    ) {
        Column {
            AsyncImage(
                contentScale = ContentScale.Crop,
                model = model.displayImageUrl,
                contentDescription = "By ${model.author}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            )
            Text(
                text = model.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                IconWithInfo(
                    icon = painterResource(id = R.drawable.ic_view),
                    info = "${model.totalViews} Views",
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
                IconWithInfo(
                    icon = painterResource(id = R.drawable.ic_heart),
                    info = "${model.totalLikes} Likes",
                    modifier = Modifier
                        .padding(end = 8.dp)
                )
            }


        }
    }
}

@Composable
fun IconWithInfo(icon: Painter, info: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(end = 8.dp)
        )
        Text(text = info, fontSize = 12.sp)
    }

}

@Preview(showBackground = true)
@Composable
fun CompleteVlogItemPreview() {
//    CompleteVlogItem(
//        VlogDetailsModel(
//            vId = "01",
//            date = "20th March 2023",
//            title = "Travelling is fun",
//            displayImageUrl = "https://media.istockphoto.com/id/531444381/photo/glacier-bay-in-mountains-alaska-united-states.webp?s=1024x1024&w=is&k=20&c=z6PA2NF144Y3xubzQYJquvMH1K2LLYVAJKYjeycWLX4=",
//            author = "Keshav Gupta",
//            postItemList = listOf(
//                TextPostItemModel(
//                    listOf(
//                        "This is just for sample",
//                        "This is just for description sample"
//                    )
//                ),
//                ImagePostItemModel(
//                    "https://media.istockphoto.com/id/531444381/photo/glacier-bay-in-mountains-alaska-united-states.webp?s=1024x1024&w=is&k=20&c=z6PA2NF144Y3xubzQYJquvMH1K2LLYVAJKYjeycWLX4=",
//                    "Journey towards end",
//                ),
//                MultipleImagePostItemModel(
//                    listOf(
//                        "https://cdn.pixabay.com/photo/2023/01/01/21/33/mountain-7690893_1280.jpg",
//                        "https://media.istockphoto.com/id/531444381/photo/glacier-bay-in-mountains-alaska-united-states.webp?s=1024x1024&w=is&k=20&c=z6PA2NF144Y3xubzQYJquvMH1K2LLYVAJKYjeycWLX4=",
//                        "https://media.istockphoto.com/id/119889938/photo/waterfall-in-deep-forest.webp?s=1024x1024&w=is&k=20&c=nm4bomRW_IG4juvYI1vtSTw0xplCuMOyEMK8zBvvrCM="
//                    ),
//                    "Picture Gallery",
//                ),
//                TextPostItemModel(
//                    listOf(
//                        "This is just for sample 2",
//                        "This is just for description sample 2"
//                    )
//                )
//            ),
//            totalLikes = 200,
//            totalViews = 300
//        )
//    )
}