package com.kgcorp.corevloglibrary.components.createVlogComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.kgcorp.corevloglibrary.models.datamodels.PostItemModel
import com.kgcorp.corevloglibrary.models.datamodels.TextPostItemModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomAddTextItemDialog(
    onAddClick: (Int, PostItemModel) -> Unit,
    onDismiss: () -> Unit,
    title: String,
    position: Int = -1,
) {
    val inputList = remember {
        mutableStateListOf<String>()
    }
    val inputValue = remember { mutableStateOf(TextFieldValue()) }
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = title, style = TextStyle(
                            fontSize = 20.sp, fontWeight = FontWeight.SemiBold
                        ), modifier = Modifier.weight(1f)
                    )
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier
                            .clickable {
                                onDismiss()
                            })
                }
                LazyColumn {

                    item {
                        Spacer(modifier = Modifier.padding(8.dp))
                    }

                    itemsIndexed(inputList) { index, item ->
                        AddedTextItem(txt = item) {
                            inputList.remove(item)
                        }
                    }
                    item {

                        AddTextItem(txt = inputValue) {
                            if (!inputValue.value.text.isNullOrEmpty()) {
                                inputList.add(inputValue.value.text)
                                inputValue.value = TextFieldValue("")
                                inputValue.value
                            }
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    TextButton(
                        onClick = { onDismiss() }, colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent, contentColor = Color.Red
                        )
                    ) {
                        Text(
                            text = "Cancel"
                        )
                    }
                    TextButton(
                        onClick = {
                            if (!inputValue.value.text.isNullOrEmpty())
                                inputList.add(inputValue.value.text)
                            onAddClick(position, TextPostItemModel(inputList))
                        }, colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.DarkGray, contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Done"
                        )
                    }
                }
            }
        }
    }
}
