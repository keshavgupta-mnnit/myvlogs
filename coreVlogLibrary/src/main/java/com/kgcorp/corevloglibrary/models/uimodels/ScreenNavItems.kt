package com.kgcorp.corevloglibrary.models.uimodels

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class HomeScreenNavItems(
    val id: Int,
    val title: String,
    val iconId: ImageVector
) {
    object Dashboard : HomeScreenNavItems(id = 0, title = "Dashboard", iconId = Icons.Default.Home)
    object Profile : HomeScreenNavItems(id = 1, title = "Profile", iconId = Icons.Default.Person)
}
