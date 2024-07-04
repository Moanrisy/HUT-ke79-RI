package top.terlampau.hutke_79ri

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import top.terlampau.hutke_79ri.theme.HUTKe79RITheme
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.LocalDateTime.of
import java.time.ZoneId
import java.time.Duration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HUTKe79RITheme {
                CountdownApp()
            }
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun CountdownApp() {
    var dayLeft by remember { mutableStateOf("") }
    var timeLeft by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        val targetDate = of(2024, 8, 17, 0, 0)
        val zoneId = ZoneId.systemDefault()

        while (true) {
            val now = LocalDateTime.now(zoneId)
            val duration = Duration.between(now, targetDate)
            val days = duration.toDays()
            val hours = duration.toHours() % 24
            val minutes = duration.toMinutes() % 60
            val seconds = duration.seconds % 60

            dayLeft = String.format("%dd", days)
            timeLeft = String.format("%02dh %02dm %02ds", hours, minutes, seconds)
            delay(1000)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFCDD2)), // Light Red Background
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Countdown to\nIndonesia's 79th Birthday",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFB71C1C) // Dark Red Text,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = dayLeft,
                fontSize = 72.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // White Text
            )
            Text(
                text = timeLeft,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // White Text
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HUTKe79RITheme {
    }
}