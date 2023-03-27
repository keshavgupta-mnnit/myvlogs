package com.kgcorp.corevloglibrary.models.uimodels

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.ui.graphics.vector.ImageVector

sealed class HomeScreenNavItems(
    val id: Int,
    val title: String,
    val iconId: ImageVector
) {
    object Dashboard : HomeScreenNavItems(id = 0, title = "Dashboard", iconId = Icons.Default.Dashboard)
    object Profile : HomeScreenNavItems(id = 1, title = "Profile", iconId = Icons.Default.VerifiedUser)
}
