/*
 *
 */
package com.zjgsu.timerCompose.timer

import java.time.Duration

data class TimerModel(
    val timerDuration: Duration =/* Duration.ofSeconds(10),*/
    /*timerDuration=*/Duration.ofMinutes(5),
    val durationRemaining: Duration = timerDuration,
    val timerViewState: TimerViewState = TimerViewState.IDLE
) {

    fun getPercentageComplete(): Float {
        return (durationRemaining.toMillis().toFloat() / timerDuration.toMillis().toFloat())
    }
}

enum class TimerViewState {
    IDLE,
    RUNNING,
    FINISHED
}
