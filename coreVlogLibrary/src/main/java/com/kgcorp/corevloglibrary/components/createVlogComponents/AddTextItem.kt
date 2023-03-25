package com.kgcorp.corevloglibrary.components.createVlogComponents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun AddTextItem(txt: MutableState<TextFieldValue>, addNew: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = txt.value, onValueChange = {
                txt.value = it
            }, modifier = Modifier.weight(1f)
                .focusRequester(FocusRequester()),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true, keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                addNew()
            }),
            textStyle = TextStyle(
                color = Color.Black, fontSize = TextUnit.Unspecified,
                fontFamily = FontFamily.SansSerif
            ),

        )
        IconButton(onClick = {
            addNew()
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)

        }
    }
}

@Composable
fun AddedTextItem(txt: String, onDelete: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = txt, modifier = Modifier.weight(1f))
        IconButton(onClick = {
            onDelete()
        }) {
            Icon(imageVector = Icons.Default.Remove, contentDescription = null)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddTextItemPreview() {
//    val txt = remember {
//        mutableStateOf("hi")
//    }
//    AddTextItem(true, txt, {})
    funData()
}

@Composable
fun funData() {
// this variable use to handle list state
    val notesList = remember {
        mutableStateListOf<String>()
    }
// this variable use to handle edit text input value
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }

    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .height(Dp(60f))
        ) {

            TextField(
                value = inputvalue.value,
                onValueChange = {
                    inputvalue.value = it
                },
                modifier = Modifier.weight(0.8f),
                placeholder = { Text(text = "Enter your note") },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true, keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
                ),
                textStyle = TextStyle(
                    color = Color.Black, fontSize = TextUnit.Unspecified,
                    fontFamily = FontFamily.SansSerif
                ),
                maxLines = 1,
                singleLine = true
            )

            Button(
                onClick = {
                    notesList.add(inputvalue.value.text)
                },
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
            ) {
                Text(text = "ADD")
            }
        }

        Spacer(modifier = Modifier.height(Dp(1f)))

        Surface(modifier = Modifier.padding(all = Dp(5f))) {
            LazyColumn {

                itemsIndexed(notesList) { index, item ->

                    val annotatedText = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("Delete")
                        }
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(Dp(50f))
                    ) {

                        Text(text = item, Modifier.weight(0.85f))

                        ClickableText(
                            text = annotatedText, onClick = {

                                notesList.remove(item)

                            },
                            modifier = Modifier.weight(0.15f)
                        )
                    }
                }
            }
        }


    }


}