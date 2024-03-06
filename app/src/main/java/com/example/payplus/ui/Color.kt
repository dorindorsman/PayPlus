package com.example.payplus.ui

import android.provider.CalendarContract
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val primaryColor = Color(0xFF4FF46B)
val primaryLightColor = Color(0xFF8CFF9C)
val primaryDarkColor = Color(0xFF006D21)
val primaryTextColor = Color(0xFF000000)
val secondaryColor = Color(0xFF8E24AA)
val secondaryLightColor = Color(0xFFC158DC)
val secondaryDarkColor = Color(0xFF5C007A)
val secondaryTextColor = Color(0xFFFFFFFF)

val GreenColor = Color(0xFF34AA53)
val TerminalColor = Color(0xFF34AA53)
val ManualColor = Color(0xFF4F5860)
val PosColor = Color(0xFF80B918)
val LightGrayColor = Color(0xFF4F5860)
val DarkGrayColor = Color(0xFF141414)


//val LightGray = Color(0xFFFCFCFC)
//val MediumGray = Color(0xFF9C9C9C)
//val DarkGray = Color(0xFF141414)

val CalendarContract.Colors.TerminalColor: Color
    @Composable
    get() = TerminalColor

val CalendarContract.Colors.ManualColor: Color
    @Composable
    get() = ManualColor

val CalendarContract.Colors.PosColor: Color
    @Composable
    get() = PosColor
val CalendarContract.Colors.LightGrayColor: Color
    @Composable
    get() = LightGrayColor

val CalendarContract.Colors.DarkGrayColor: Color
    @Composable
    get() = DarkGrayColor

//Colors:
//Green: #34AA53
//Source terminal: Green
//
//Source pos: #80B918
//Source manual: #4F5860
//Light gray: #4F5860
//Dark gray: #E3E6E9
