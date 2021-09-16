/*
 *
 */
package com.zjgsu.timerCompose.timer

sealed class TimerViewEffect {

    object TimerFinished : TimerViewEffect()

    object TimerReset : TimerViewEffect()
}
