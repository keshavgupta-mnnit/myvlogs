package com.kgcorp.corevloglibrary.components.homeComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kgcorp.corevloglibrary.Util
import com.kgcorp.corevloglibrary.models.datamodels.ImagePostItemModel
import com.kgcorp.corevloglibrary.models.datamodels.TextPostItemModel
import com.kgcorp.corevloglibrary.models.datamodels.VlogDetailsModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun HomeScreen(
    destinationsNavigator: DestinationsNavigator
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(top = 24.dp)
    ) {
        items(Util.dummyData) {
            CompleteVlogItem(model = it, destinationsNavigator)
        }
    }
}
