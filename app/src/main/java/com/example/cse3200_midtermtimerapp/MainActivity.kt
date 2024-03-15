package com.example.cse3200_midtermtimerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cse3200_midtermtimerapp.timers.CenterScreenViewModel
import com.example.cse3200_midtermtimerapp.timers.LeftScreenViewModel
import com.example.cse3200_midtermtimerapp.timers.RightScreenViewModel
import com.example.cse3200_midtermtimerapp.ui.theme.CSE3200MidtermTimerAppTheme

class MainActivity : ComponentActivity() {

    private val leftViewModel : LeftScreenViewModel by viewModels<LeftScreenViewModel>()
    private val rightViewModel : RightScreenViewModel by viewModels<RightScreenViewModel>()
    private val centerViewModel : CenterScreenViewModel by viewModels<CenterScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Navigation(leftViewModel, centerViewModel, rightViewModel)
            }
        }
    }
}