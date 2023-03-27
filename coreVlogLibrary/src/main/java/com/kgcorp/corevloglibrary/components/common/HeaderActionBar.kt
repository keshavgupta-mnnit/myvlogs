package com.kgcorp.corevloglibrary.components.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FlipToBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun HeaderActionBar(
    pageTitle: String, onBackPress: () -> Unit, onSavePress: () -> Unit
) {
    TopAppBar(title = {
        Text(text = pageTitle)
    }, modifier = Modifier.fillMaxWidth(), navigationIcon = {
        IconButton(onClick = {onBackPress() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
        }
    }, actions = {
        IconButton(onClick = {onSavePress() }) {
            Icon(imageVector = Icons.Default.Save, contentDescription = null)
        }
    })

}