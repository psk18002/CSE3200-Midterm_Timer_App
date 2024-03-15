package com.example.cse3200_midtermtimerapp

import com.example.cse3200_midtermtimerapp.timers.RightScreenViewModel
import org.junit.Test

import kotlin.test.assertEquals

fun formatElapsedTime(elapsedTime: Long): String {

    // Break the elapsed seconds into hours, minutes, and seconds.
    var elapsedSeconds = elapsedTime
    var hours: Long = 0
    var minutes: Long = 0
    var seconds: Long = 0
    if (elapsedSeconds >= 3600) {
        hours = elapsedSeconds / 3600
        elapsedSeconds -= hours * 3600
    }
    if (elapsedSeconds >= 60) {
        minutes = elapsedSeconds / 60
        elapsedSeconds -= minutes * 60
    }
    seconds = elapsedSeconds
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

class Test {

    @Test
    fun formatElapsedTime_FormatsCorrectly() {
        assertEquals("00:00:00", formatElapsedTime(0))
        assertEquals("00:00:59", formatElapsedTime(59))
        assertEquals("00:01:00", formatElapsedTime(60))
        assertEquals("00:59:59", formatElapsedTime(3599))
        assertEquals("01:00:00", formatElapsedTime(3600))
        assertEquals("01:01:00", formatElapsedTime(3660))
        assertEquals("01:01:01", formatElapsedTime(3661))
        assertEquals("24:00:00", formatElapsedTime(86400))
    }
}
