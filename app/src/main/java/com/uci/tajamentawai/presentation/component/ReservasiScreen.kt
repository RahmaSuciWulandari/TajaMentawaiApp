package com.uci.tajamentawai.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.Data.entity.Reservation
import com.uci.tajamentawai.R
import androidx.hilt.navigation.compose.hiltViewModel
import com.uci.tajamentawai.Data.database.AppDatabase
import com.uci.tajamentawai.navigation.Screen

@Composable
fun ReservasiScreen(navController: NavController, database: AppDatabase) {
    val reservationDao = database.reservationDao()
    val reservations by reservationDao.getAllReservations().collectAsState(initial = emptyList())

    Scaffold(
        topBar = { ReservationTopBar() },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.Top
            ) {
                if (reservations.isNotEmpty()) {
//                    reservations.forEach { reservation ->
//                        ReservationCard(navController = navController, reservation = reservation)
//                    }

                    LazyColumn {
                        items(reservations) { reservation ->
                            ReservationCard(navController = navController, reservation = reservation)
                        }
                    }

                } else {
                    Text(
                        text = "No reservation data available.",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    )
}



//@Composable
//fun ReservasiScreen(sharedViewModel: SharedViewModel) {
//    val reservationData by sharedViewModel.reservationData.observeAsState()
//
//    Scaffold(
//        topBar = { ReservationTopBar() }, content = { padding ->
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(padding)
//                    .padding(horizontal = 16.dp, vertical = 8.dp)
//            ) {
//                if(reservationData != null){
//                    val destinasi = reservationData!!["destinasi"] ?: "N/A"
//                    val tanggal = reservationData!!["tanggal"] ?: "N/A"
//                    val metodePembayaran = reservationData!!["metodePembayaran"] ?: "N/A"
//                    val harga = reservationData!!["harga"] ?: "N/A"
//                    Card(
//                        shape = RoundedCornerShape(12.dp),//        elevation = 4.dp,
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(16.dp)
//                        ) {
//                            Row(
//                                modifier = Modifier.fillMaxWidth(),
//                                verticalAlignment = Alignment.CenterVertically
//                            ) {
//                                Image(
//                                    painter = painterResource(id = R.drawable.sipora),
//                                    contentDescription = "Waterfall Image", modifier = Modifier
//                                        .size(100.dp)
//                                        .clip(RoundedCornerShape(8.dp))
//                                )
//                                Spacer(modifier = Modifier.width(12.dp))
//                                Column {
//                                    Text(destinasi, fontWeight = FontWeight.Bold, fontSize = 16.sp)
//                                    Spacer(modifier = Modifier.height(4.dp))
//                                    Row (verticalAlignment = Alignment.CenterVertically) {
//                                        Icon(
//                                            painter = painterResource(id = R.drawable.star), // Replace with your star icon
//                                            contentDescription = "Rating", tint = Color(0xFFFFD700),
//                                            modifier = Modifier.size(16.dp)
//                                        )
//                                        Spacer(modifier = Modifier.width(4.dp))
//                                        Text (metodePembayaran, color = Color.Gray)
//                                        Spacer(modifier = Modifier.width(8.dp))
//                                        Text (formatRupiah(harga.toDouble()), color = Color.Gray, fontSize = 14.sp)
//                                        Spacer(modifier = Modifier.width(8.dp))
//                                        Text (tanggal, color = Color.Gray, fontSize = 14.sp)
//                                    }
//                                    Spacer(modifier = Modifier.height(8.dp))
//                                    Text(
//                                        "Total tiket: ${formatRupiah(harga.toDouble())}",
//                                        fontSize = 14.sp,
//                                        fontWeight = FontWeight.Bold
//                                    )
//                                }
//                            }
//                            Spacer(modifier = Modifier.height(12.dp))
//// "Check Ticket" button
//                            Button(
//                                onClick =
//                                { /* Handle check ticket action */ },
//                                modifier = Modifier.align(Alignment.CenterHorizontally),
//                                colors = ButtonDefaults.buttonColors(Color(0xFF006064))
//                            ) {
//                                Text("Cek Tiket", color = Color.White)
//                            }
//                        }
//                    }
//                }else{
//                    Text(text = "Data reservasi tidak ditemukan.", fontSize = 16.sp, color = Color.Gray)
//                }
//
//            }
//        })
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservationTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Reservations",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    )
}


@Composable
fun ReservationCard(reservation: Reservation, navController: NavController) {
    val imageResId = reservation.images.toIntOrNull() ?: R.drawable.logo_ijo // ID resource fallback

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Destinasi",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(16.dp))
                )

                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(reservation.key, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Date: ${reservation.date}", color = Color.Gray, fontSize = 14.sp)
                    Text("Payment: ${reservation.paymentMethod}", color = Color.Gray, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Total: ${reservation.value}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    navController.navigate(Screen.Notification.route)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(Color(0xFF006064))
            ) {
                Text("Cek Tiket", color = Color.White)
            }
        }
    }
}