/*
 *
 */
package com.zjgsu.timerCompose.timer.ext

import java.time.Duration
import kotlin.math.abs

fun Duration.formatDuration(): String {
    val seconds: Long = this.seconds
    val absSeconds = abs(seconds)
    val positive = String.format(
        "%02d:%02d",
        absSeconds % 3600 / 60,
        absSeconds % 60
    )
    return if (seconds < 0) "-$positive" else positive
}
