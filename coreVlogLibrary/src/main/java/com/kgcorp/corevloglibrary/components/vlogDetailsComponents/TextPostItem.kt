package com.kgcorp.corevloglibrary.components.vlogDetailsComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kgcorp.corevloglibrary.models.datamodels.TextPostItemModel


fun LazyListScope.TextPostItem(textItem: TextPostItemModel) {
    items(textItem.txt) { item ->
        SingleTextPostItem(item)
    }
}

@Composable
fun SingleTextPostItem(data: String) {
    Text(
        text = data,
        fontSize = 16.sp,
        fontFamily = FontFamily.SansSerif,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, start = 8.dp, end = 8.dp)
    )

}

@Preview(showBackground = true)
@Composable
fun TextPostItemPreview() {
    LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
        TextPostItem(
            TextPostItemModel(
                listOf("This is just for sample", "This is just for description sample")
            )
        )
    }
}