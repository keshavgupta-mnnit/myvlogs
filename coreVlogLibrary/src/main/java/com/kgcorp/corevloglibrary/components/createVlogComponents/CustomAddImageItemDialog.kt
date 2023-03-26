package com.kgcorp.corevloglibrary.components.createVlogComponents

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.kgcorp.corevloglibrary.components.vlogDetailsComponents.MultipleImageItem
import com.kgcorp.corevloglibrary.components.vlogDetailsComponents.SingleImageItem
import com.kgcorp.corevloglibrary.models.datamodels.ImagePostItemModel
import com.kgcorp.corevloglibrary.models.datamodels.PostItemModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomAddImageItemDialog(
    content: @Composable () -> Unit,
    onAddClick: (Int, PostItemModel) -> Unit,
    onDismiss: () -> Unit,
    title: String,
    subtitle: String,
    position: Int = -1,
) {
    val imagesList = remember {
        mutableStateOf<List<String>>(emptyList())
    }
    val description = remember {
        mutableStateOf(TextFieldValue())
    }

    val photoClickLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.PickMultipleVisualMedia(),
            onResult = { uris ->
                imagesList.value = uris.map { it.toString() }
            })
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            elevation = 8.dp, shape = RoundedCornerShape(20.dp)
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
                        modifier = Modifier.clickable {
                            onDismiss()
                        })
                }

                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                LazyColumn {

                    item {
                        Spacer(modifier = Modifier.padding(8.dp))
                    }

                    if (imagesList.value.size == 1) {
                        item {
                            SingleImageItem(imagesList.value[0], description.value.text)
                        }
                    } else if (imagesList.value.size > 1) {
                        item {
                            MultipleImageItem(imagesList.value, description.value.text)
                        }
                    }
                    item {
                        AddTextItem(txt = description) {
                            photoClickLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
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
                            onAddClick(
                                position,
                                ImagePostItemModel(imagesList.value, description.value.text)
                            )

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