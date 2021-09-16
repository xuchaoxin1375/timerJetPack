/*
 *
 */
package com.zjgsu.timerCompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.zjgsu.timerCompose.R

val customFont = FontFamily(
    Font(R.font.ibm_plexmono_regular),
    Font(R.font.ibm_plexmono_bold, FontWeight.Bold),
    Font(R.font.ibm_plexmono_italic, style = FontStyle.Italic),
    Font(R.font.ibm_plexmono_medium, FontWeight.Medium),
    Font(R.font.ibm_plexmono_semibold, FontWeight.SemiBold),
    Font(R.font.ibm_plexmono_light, FontWeight.Light)
)

val typography = Typography(
    defaultFontFamily = customFont
)
