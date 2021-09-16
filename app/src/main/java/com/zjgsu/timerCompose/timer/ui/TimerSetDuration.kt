/*
 *
 */
package com.zjgsu.timerCompose.timer.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zjgsu.timerCompose.R
import com.zjgsu.timerCompose.timer.ext.formatDuration
import java.time.Duration

@Composable
fun TimerSetDuration(
    timerDuration: Duration,
    onAddTime: (Duration) -> Unit,
    onRemoveTime: (Duration) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Icon(
                Icons.Outlined.Add, contentDescription = stringResource(id = R.string.add_minute),
                modifier = Modifier
                    .size(56.dp)
                    .clickable {
                        onAddTime(Duration.ofMinutes(1))
                    }
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(96.dp))
            Icon(
                Icons.Outlined.Add, contentDescription = stringResource(id = R.string.add_second),
                modifier = Modifier
                    .size(56.dp)
                    .clickable {
                        onAddTime(Duration.ofSeconds(1))
                    }
                    .padding(8.dp)
            )
        }
        TimerText(timerText = timerDuration.formatDuration())
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Icon(
                Icons.Outlined.Remove, contentDescription = stringResource(id = R.string.remove_minute),
                modifier = Modifier
                    .size(56.dp)
                    .clickable {
                        onRemoveTime(Duration.ofMinutes(1))
                    }
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(96.dp))
            Icon(
                Icons.Outlined.Remove, contentDescription = stringResource(id = R.string.remove_second),
                modifier = Modifier
                    .size(56.dp)
                    .clickable {
                        onRemoveTime(Duration.ofSeconds(1))
                    }
                    .padding(8.dp)
            )
        }
    }
}
