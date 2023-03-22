package com.kgcorp.corevloglibrary.components.createVlogComponents

import android.widget.Toast
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.kgcorp.corevloglibrary.R
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun CreateVlogScreen() {
    var isFabActive by remember {
        mutableStateOf(false)
    }
    val ctx = LocalContext.current
    val fabMenu = listOf(
        FabActionItemModel(
            ImageVector.vectorResource(id = R.drawable.ic_heart),
            "Text Only"
        ) {
            Toast.makeText(ctx, "Text Only", Toast.LENGTH_LONG).show()
        },
        FabActionItemModel(
            ImageVector.vectorResource(id = R.drawable.ic_view),
            "Single Image") {
            Toast.makeText(ctx, "Single Image", Toast.LENGTH_LONG).show()
        },
        FabActionItemModel(
            ImageVector.vectorResource(id = R.drawable.ic_search),
            "Multiple Images") {
            Toast.makeText(ctx, "Multiple Images", Toast.LENGTH_LONG).show()
        }
    )
    Scaffold(floatingActionButton = {
        CreateVlogFab(isFabActive, fabMenu) { isFabActive = it }
    }) { padding ->
        Text(modifier = Modifier.padding(padding), text = "Hi")
    }

}

@Composable
fun CreateVlogFab(
    isFabActive: Boolean,
    fabMenu: List<FabActionItemModel>,
    onFabClicked: (Boolean) -> Unit
) {
    val transition = updateTransition(targetState = isFabActive, "transition")
    val rotate by transition.animateFloat(label = "rotate") {
        if (it) 45f else 1f
    }
    Column(horizontalAlignment = Alignment.End) {
        if (transition.currentState) {
            fabMenu.forEach {
                FabActionItem(it)
                Spacer(modifier = Modifier.size(16.dp))
            }
        }

        FloatingActionButton(onClick = { onFabClicked(!isFabActive) }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                modifier = Modifier.rotate(rotate)
            )
        }
    }
}

data class FabActionItemModel(
    val icon: ImageVector,
    val title: String,
    val onClick: () -> Unit
)

@Composable
fun FabActionItem(model: FabActionItemModel) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = model.title)
        Spacer(modifier = Modifier.size(8.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.secondary, CircleShape)
                .clickable(
                    indication = rememberRipple(bounded = true),
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = { model.onClick() }
                )
        ) {
            Icon(imageVector = model.icon, contentDescription = "", modifier = Modifier.fillMaxSize(.75f))
        }
    }
}