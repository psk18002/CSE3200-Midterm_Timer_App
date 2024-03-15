package com.example.cse3200_midtermtimerapp.screens

import android.text.format.DateUtils
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cse3200_midtermtimerapp.timers.CenterScreenViewModel

@Composable
private fun formatElapsedTime(elapsedTime: Long): String {

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

@Composable
fun CenterScreen(name : String, myViewModel : CenterScreenViewModel) {
    val elapsedTime by myViewModel.getElapsedTime()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center,
        modifier = Modifier.fillMaxHeight(0.75F).fillMaxWidth()
    ) {
        Text(formatElapsedTime(elapsedTime), fontSize = 60.sp)
        Spacer(modifier = Modifier.padding(15.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { myViewModel.startStopwatch()}) {
                Text("START")
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Button(onClick = { myViewModel.stopStopwatch()}) {
                Text("STOP")
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Button(onClick = { myViewModel.resetStopwatch()}) {
                Text("RESET")
            }
        }
    }
}