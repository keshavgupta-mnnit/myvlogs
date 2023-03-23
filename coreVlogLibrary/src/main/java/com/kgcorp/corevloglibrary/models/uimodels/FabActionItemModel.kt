package com.kgcorp.corevloglibrary.models.uimodels

import androidx.compose.ui.graphics.vector.ImageVector

data class FabActionItemModel(
    val icon: ImageVector,
    val title: String,
    val onClick: () -> Unit
)