package com.kgcorp.corevloglibrary.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun RemovableContentHolder(
    modifier: Modifier = Modifier,
    onRemoveClick: () -> Unit, content: @Composable () -> Unit
) {
    ConstraintSet {
        val closeIcon = createRefFor("closeIcon")
        constrain(closeIcon) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
        }
    }
    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .border(width = 4.dp, color = Color.Black)
    ) {
        content()
        Icon(imageVector = Icons.Default.Close,
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier
                .size(32.dp)
                .padding(2.dp)
                .clickable {
                    onRemoveClick()
                }
                .layoutId("closeIcon")
                .background(color = Color.Black, CircleShape))

    }

}