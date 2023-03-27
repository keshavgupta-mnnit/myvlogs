package com.kgcorp.corevloglibrary

import com.kgcorp.corevloglibrary.models.datamodels.ImagePostItemModel
import com.kgcorp.corevloglibrary.models.datamodels.TextPostItemModel
import com.kgcorp.corevloglibrary.models.datamodels.VlogDetailsModel

object Util {
    val dummyData: MutableList<VlogDetailsModel> = mutableListOf(
        VlogDetailsModel(
            vId = "01",
            date = "20th March 2023",
            title = "You can use the verticalArrangement parameter to add a spacing between each item using ",
            displayImageUrl = "https://media.istockphoto.com/id/531444381/photo/glacier-bay-in-mountains-alaska-united-states.webp?s=1024x1024&w=is&k=20&c=z6PA2NF144Y3xubzQYJquvMH1K2LLYVAJKYjeycWLX4=",
            author = "Keshav Gupta",
            postItemList = listOf(
                TextPostItemModel(
                    listOf(
                        "This is just for sample",
                        "This is just for description sample"
                    )
                ),
                ImagePostItemModel(
                    listOf("https://media.istockphoto.com/id/531444381/photo/glacier-bay-in-mountains-alaska-united-states.webp?s=1024x1024&w=is&k=20&c=z6PA2NF144Y3xubzQYJquvMH1K2LLYVAJKYjeycWLX4="),
                    "Journey towards end",
                ),
                ImagePostItemModel(
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
            ),
            totalLikes = 204,
            totalViews = 309
        ),
        VlogDetailsModel(
            vId = "01",
            date = "20th March 2023",
            title = "Travelling is fun",
            displayImageUrl = "https://cdn.pixabay.com/photo/2023/01/01/21/33/mountain-7690893_1280.jpg",
            author = "Keshav Gupta",
            postItemList = listOf(
                TextPostItemModel(
                    listOf(
                        "This is just for sample",
                        "This is just for description sample"
                    )
                ),
                ImagePostItemModel(
                    listOf("https://media.istockphoto.com/id/531444381/photo/glacier-bay-in-mountains-alaska-united-states.webp?s=1024x1024&w=is&k=20&c=z6PA2NF144Y3xubzQYJquvMH1K2LLYVAJKYjeycWLX4="),
                    "Journey towards end",
                ),
                ImagePostItemModel(
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
            ),
            totalLikes = 405,
            totalViews = 3409
        ),
        VlogDetailsModel(
            vId = "01",
            date = "20th March 2023",
            title = "Travelling is fun",
            displayImageUrl = "https://media.istockphoto.com/id/531444381/photo/glacier-bay-in-mountains-alaska-united-states.webp?s=1024x1024&w=is&k=20&c=z6PA2NF144Y3xubzQYJquvMH1K2LLYVAJKYjeycWLX4=",
            author = "Keshav Gupta",
            postItemList = listOf(
                TextPostItemModel(
                    listOf(
                        "This is just for sample",
                        "This is just for description sample"
                    )
                ),
                ImagePostItemModel(
                    listOf("https://media.istockphoto.com/id/531444381/photo/glacier-bay-in-mountains-alaska-united-states.webp?s=1024x1024&w=is&k=20&c=z6PA2NF144Y3xubzQYJquvMH1K2LLYVAJKYjeycWLX4="),
                    "Journey towards end",
                ),
                ImagePostItemModel(
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
            ),
            totalLikes = 204,
            totalViews = 309
        ),
        VlogDetailsModel(
            vId = "01",
            date = "20th March 2023",
            title = "Travelling is fun",
            displayImageUrl = "https://cdn.pixabay.com/photo/2023/01/01/21/33/mountain-7690893_1280.jpg",
            author = "Keshav Gupta",
            postItemList = listOf(
                TextPostItemModel(
                    listOf(
                        "This is just for sample",
                        "This is just for description sample"
                    )
                ),
                ImagePostItemModel(
                    listOf("https://media.istockphoto.com/id/531444381/photo/glacier-bay-in-mountains-alaska-united-states.webp?s=1024x1024&w=is&k=20&c=z6PA2NF144Y3xubzQYJquvMH1K2LLYVAJKYjeycWLX4="),
                    "Journey towards end",
                ),
                ImagePostItemModel(
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
            ),
            totalLikes = 405,
            totalViews = 3409
        )
    )
}