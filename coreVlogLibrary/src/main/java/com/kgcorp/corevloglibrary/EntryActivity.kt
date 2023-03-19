package com.kgcorp.corevloglibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kgcorp.corevloglibrary.components.MultipleImageItem
import com.kgcorp.corevloglibrary.components.SingleImageItem
import com.kgcorp.corevloglibrary.components.VlogDetails
import com.kgcorp.corevloglibrary.models.*
import com.kgcorp.corevloglibrary.ui.theme.ComposeProjectTheme

class EntryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme(false) {
                VlogDetails(
                    VlogDetailsModel(
                        vId = "01",
                        date = "20th March 2023",
                        title = "Travelling is fun",
                        author = "Keshav Gupta",
                        postItemList = listOf(
                            TextPostItemModel(
                                listOf(
                                    "This is just for sample",
                                    "This is just for description sample"
                                )
                            ),
                            ImagePostItemModel(
                                "https://media.istockphoto.com/id/531444381/photo/glacier-bay-in-mountains-alaska-united-states.webp?s=1024x1024&w=is&k=20&c=z6PA2NF144Y3xubzQYJquvMH1K2LLYVAJKYjeycWLX4=",
                                "Journey towards end",
                            ),
                            MultipleImagePostItemModel(
                                listOf(
                                    "https://cdn.pixabay.com/photo/2023/01/01/21/33/mountain-7690893_1280.jpg",
                                    "https://media.istockphoto.com/id/531444381/photo/glacier-bay-in-mountains-alaska-united-states.webp?s=1024x1024&w=is&k=20&c=z6PA2NF144Y3xubzQYJquvMH1K2LLYVAJKYjeycWLX4=",
                                    "https://media.istockphoto.com/id/119889938/photo/waterfall-in-deep-forest.webp?s=1024x1024&w=is&k=20&c=nm4bomRW_IG4juvYI1vtSTw0xplCuMOyEMK8zBvvrCM="
                                ),
                                "Picture Gallery",
                            ),
                            TextPostItemModel(
                                listOf(
                                    "This is just for sample 2",
                                    "This is just for description sample 2"
                                )
                            )
                        )
                    )

                )
            }
        }
    }
}