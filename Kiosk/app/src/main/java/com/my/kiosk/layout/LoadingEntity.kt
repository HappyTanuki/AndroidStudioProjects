package com.my.kiosk.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.valentinilk.shimmer.shimmer

object LoadingEntity {
    @Composable
    operator fun invoke(
        isLoading: Boolean,
        entity: @Composable () -> Unit) {
        if (isLoading) {
            Box(
                modifier = Modifier
                    .background(Color.Gray)
                    .shimmer()
                    .fillMaxSize()
            )
        }
        else {
            entity()
        }
    }
}