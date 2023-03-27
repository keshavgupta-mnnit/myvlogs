package com.kgcorp.corevloglibrary.components.homeComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kgcorp.corevloglibrary.Util
import com.kgcorp.corevloglibrary.components.destinations.CreateVlogScreenDestination
import com.kgcorp.corevloglibrary.models.uimodels.HomeScreenNavItems
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navigator.navigate(
                        CreateVlogScreenDestination()
                    )
                },
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.background,
                elevation = FloatingActionButtonDefaults.elevation(2.dp, 3.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = { HomeBottomNavItem() }
    ) { padding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(padding)
        ) {
            items(Util.dummyData) {
                CompleteVlogItem(model = it, navigator)
            }
        }
    }

}

@Composable
fun HomeBottomNavItem() {
    val currentSelectedNavItem = remember {
        mutableStateOf(0)
    }
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.surface,
        cutoutShape = CircleShape,
        contentPadding = PaddingValues(horizontal = 50.dp),
        elevation = 2.dp
    ) {
        HomeScreenNavItems.Dashboard.let {
            HomeNavItem(it, it.id == currentSelectedNavItem.value) {
                currentSelectedNavItem.value = it.id
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        HomeScreenNavItems.Profile.let {
            HomeNavItem(it, it.id == currentSelectedNavItem.value) {
                currentSelectedNavItem.value = it.id
            }
        }
    }
}

@Composable
fun HomeNavItem(item: HomeScreenNavItems, isSelected: Boolean, onClick: () -> Unit) {
    val iconAlpha = if (isSelected) 1f else 0.5f
    IconButton(onClick = { onClick() }) {
        Icon(
            imageVector = item.iconId,
            contentDescription = item.title,
            tint = MaterialTheme.colors.onBackground.copy(iconAlpha)
        )
    }
}
