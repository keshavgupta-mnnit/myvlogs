package com.kgcorp.corevloglibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kgcorp.corevloglibrary.components.navigation.AppNavigation
import com.kgcorp.corevloglibrary.ui.theme.ComposeProjectTheme

class EntryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}