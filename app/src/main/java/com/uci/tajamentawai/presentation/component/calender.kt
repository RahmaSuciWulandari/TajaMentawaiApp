package com.uci.tajamentawai.presentation.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.time.LocalDate

//@RequiresApi(Build.VERSION_CODES.O)
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CalendarScreen(destinasiId: Int?, navController: NavController) {
//    val selectedDate = remember { mutableStateOf<LocalDate?>(null) }
//    val currentMonth = remember { mutableStateOf(LocalDate.now()) }
//    val detaildestinasi = destinasi.filter { destinasi ->
//        destinasi.id == destinasiId
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//    ) {
//        // Top AppBar
//        CenterAlignedTopAppBar(
//            title = {
//                Text("Tanggal Reservasi", style = typography.labelLarge) },
//            navigationIcon = {
//                IconButton(onClick = { navController.navigateUp() }) {
//                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
//                }
//            },
////            backgroundColor = Color.White,
////            elevation = 0.dp
//        )
//
//        // Image and Title Section
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//            Column {
//                Image(
//                    painter = painterResource(id = detaildestinasi[0].imageRes), // Replace with your drawable
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clip(RoundedCornerShape(8.dp))
//                        .height(150.dp),
//                    contentScale = ContentScale.Crop
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(detaildestinasi[0].title, style = typography.labelLarge)
//                Text(detaildestinasi[0].place, style = typography.bodyMedium, color = Color.Gray)
//            }
//        }
//
//        // Calendar Section
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp)
//        ) {
//            // Month and Navigation
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                IconButton(onClick = {
//                    currentMonth.value = currentMonth.value.minusMonths(1)
//                }) {
//                    Icon(Icons.Default.ArrowBack, contentDescription = "Previous Month")
//                }
//                Text(
//                    text = "${currentMonth.value.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${currentMonth.value.year}",
//                    style = typography.labelLarge,
//                    modifier = Modifier.padding(horizontal = 8.dp)
//                )
//                IconButton(onClick = {
//                    currentMonth.value = currentMonth.value.plusMonths(1)
//                }) {
//                    Icon(Icons.Default.ArrowForward, contentDescription = "Next Month")
//                }
//            }
//
//            // Calendar Grid
//            CalendarGrid(
//                currentMonth = currentMonth.value,
//                selectedDate = selectedDate
//            )
//        }
//
//        // Confirm Button
//        Button(
//            onClick = {
//                selectedDate.value?.let { date ->
//                    navController.previousBackStackEntry?.savedStateHandle?.set("reservationDate", date.toString())
//                    navController.navigateUp()
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            colors = ButtonDefaults.buttonColors(Color(0xFF00897B))
//        ) {
//            Text("Konfirmasi", color = Color.White)
//        }
//    }
//}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(destinasiId: Int?, navController: NavController, sharedViewModel: SharedViewModel) {
    val selectedDate = remember { mutableStateOf<LocalDate?>(null) }
    val currentMonth = remember { mutableStateOf(LocalDate.now()) }
    val detaildestinasi = destinasi.filter { destinasi ->
        destinasi.id == destinasiId
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top AppBar
        CenterAlignedTopAppBar(
            title = { Text("Tanggal Reservasi", style = typography.labelLarge) },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                }
            }
        )

        // Bagian Gambar dan Judul
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(id = detaildestinasi[0].imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .height(150.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(detaildestinasi[0].title, style = typography.labelLarge)
                Text(detaildestinasi[0].place, style = typography.bodyMedium, color = Color.Gray)
            }
        }

        // Bagian Kalender
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            // Navigasi Bulan
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    currentMonth.value = currentMonth.value.minusMonths(1)
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Bulan Sebelumnya")
                }
                Text(
                    text = "${currentMonth.value.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${currentMonth.value.year}",
                    style = typography.labelLarge,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                IconButton(onClick = {
                    currentMonth.value = currentMonth.value.plusMonths(1)
                }) {
                    Icon(Icons.Default.ArrowForward, contentDescription = "Bulan Berikutnya")
                }
            }

            // Grid Kalender
            CalendarGrid(
                currentMonth = currentMonth.value,
                selectedDate = selectedDate
            )
        }

        // Tombol Konfirmasi
        Button(
            onClick = {
                selectedDate.value?.let { date ->
                    // Simpan tanggal reservasi di ViewModel
                    sharedViewModel.setReservationDate(date.toString())
                    // Navigasi kembali ke layar sebelumnya
                    navController.navigateUp()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF00897B))
        ) {
            Text("Konfirmasi", color = Color.White)
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarGrid(
    currentMonth: LocalDate,
    selectedDate: MutableState<LocalDate?>
) {
    val daysInMonth = currentMonth.lengthOfMonth()
    val firstDayOfWeek = currentMonth.withDayOfMonth(1).dayOfWeek.value % 7 // Adjust for Sunday = 0
    val totalCells = daysInMonth + firstDayOfWeek
    val today = LocalDate.now()

    Column {
        // Weekday Labels
        Row(modifier = Modifier.fillMaxWidth()) {
            listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").forEach {
                Text(
                    text = it,
                    style = typography.bodyMedium,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Days Grid
        val rows = (totalCells + 6) / 7
        for (row in 0 until rows) {
            Row(modifier = Modifier.fillMaxWidth()) {
                for (col in 0..6) {
                    val dayIndex = row * 7 + col
                    val dayNumber = dayIndex - firstDayOfWeek + 1
                    val isDayValid = dayNumber in 1..daysInMonth

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(4.dp)
                            .clip(CircleShape)
                            .background(
                                when {
                                    isDayValid && selectedDate.value?.dayOfMonth == dayNumber &&
                                            selectedDate.value?.month == currentMonth.month -> Color(0xFF00897B)
                                    else -> Color.Transparent
                                }
                            )
                            .clickable(enabled = isDayValid) {
                                selectedDate.value = currentMonth.withDayOfMonth(dayNumber)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        if (isDayValid) {
                            Text(
                                text = dayNumber.toString(),
                                style = typography.bodyLarge,
                                color = if (today == currentMonth.withDayOfMonth(dayNumber))
                                    Color.Red else Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}


