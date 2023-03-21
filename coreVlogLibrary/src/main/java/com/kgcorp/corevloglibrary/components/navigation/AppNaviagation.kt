package com.kgcorp.corevloglibrary.components.navigation

import androidx.compose.runtime.Composable
import com.kgcorp.corevloglibrary.components.NavGraphs
import com.kgcorp.corevloglibrary.ui.theme.ComposeProjectTheme
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun AppNavigation(){
    ComposeProjectTheme(false) {
        DestinationsNavHost(navGraph = NavGraphs.root)
    }

}