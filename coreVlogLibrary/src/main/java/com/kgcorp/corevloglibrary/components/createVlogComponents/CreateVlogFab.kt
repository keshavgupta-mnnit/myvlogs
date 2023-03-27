package com.kgcorp.corevloglibrary.components.createVlogComponents

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.kgcorp.corevloglibrary.models.uimodels.FabActionItemModel

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

@Composable
fun FabActionItem(model: FabActionItemModel) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = model.title)
        Spacer(modifier = Modifier.size(8.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.secondary, CircleShape)
                .clickable(
                    indication = rememberRipple(bounded = true),
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = { model.onClick() }
                )
        ) {
            Icon(
                imageVector = model.icon,
                contentDescription = "",
                modifier = Modifier.fillMaxSize(.5f)
            )
        }
    }
}