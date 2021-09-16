/*
 *
 */
package com.zjgsu.timerCompose.timer.ui

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.lerp
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import com.zjgsu.timerCompose.ui.theme.lightPurple
import com.zjgsu.timerCompose.ui.theme.orange
import com.zjgsu.timerCompose.ui.theme.peach
import com.zjgsu.timerCompose.ui.util.lerp

@Composable
fun BackgroundGradient(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val animationSpec: InfiniteRepeatableSpec<Color> = infiniteRepeatable(
        animation = tween(3000, easing = FastOutSlowInEasing),
        repeatMode = RepeatMode.Reverse
    )
    val colorFirst by infiniteTransition.animateColor(
        initialValue = orange,
        targetValue = peach,
        animationSpec = animationSpec
    )
    val colorSecond by infiniteTransition.animateColor(
        initialValue = peach,
        targetValue = lightPurple,
        animationSpec = animationSpec
    )
    val colorThird by infiniteTransition.animateColor(
        initialValue = lightPurple,
        targetValue = orange,
        animationSpec = animationSpec
    )
    val animatedProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(20 * 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val numberBubbles = 23
    val bubbleInfo = remember {
        val bubbleInfos = mutableListOf<BubbleInfo>()
        for (i in 0..numberBubbles) {
            val offset = Offset(Math.random().toFloat(), Math.random().toFloat())
            val offsetEnd = Offset(Math.random().toFloat(), Math.random().toFloat())
            val radius = Math.random().toFloat() * 50
            val radiusEnd = Math.random().toFloat() * 50

            val bubblePoint = BubbleInfo(
                offset,
                offsetEnd,
                Math.random().toFloat(),
                radius,
                radiusEnd
            )
            bubbleInfos.add(bubblePoint)
        }
        bubbleInfos
    }

    Canvas(modifier = modifier.fillMaxSize()) {
        val brushBackground = Brush.verticalGradient(
            listOf(colorFirst, colorSecond, colorThird),
            0f,
            size.height.toDp().toPx(),
            TileMode.Mirror
        )
        drawRect(brushBackground)

        for (bubble in bubbleInfo) {
            val offsetAnimated = lerp(bubble.point, bubble.pointEnd, animatedProgress)
            val radiusAnimated = lerp(bubble.radius, bubble.radiusEnd, animatedProgress)
            val sizeScaled =
                size * 1.4f // increase by a bigger scale to allow for bubbles to go off the screen
            drawCircle(
                orange,
                radiusAnimated * density,
                Offset(offsetAnimated.x * sizeScaled.width, offsetAnimated.y * sizeScaled.height),
                alpha = bubble.alpha
            )
        }
    }
}

data class BubbleInfo(
    val point: Offset,
    val pointEnd: Offset,
    val alpha: Float,
    val radius: Float,
    val radiusEnd: Float
)
