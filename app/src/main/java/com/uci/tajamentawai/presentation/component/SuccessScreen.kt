package com.uci.tajamentawai.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.R
import com.uci.tajamentawai.navigation.Screen

//@Composable
//fun SuccessScreen(navController: NavController, sharedViewModel: SharedViewModel) {
//    val notification by sharedViewModel.notification.observeAsState()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = notification ?: "Transaksi Berhasil!",
//            color = Color.Green,
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(
//            onClick = {
//                navController.navigate("notifikasi") {
//                    popUpTo("sukses") { inclusive = true }
//                }
//            }
//        ) {
//            Text(text = "Lihat Notifikasi")
//        }
//    }
//}

//@Composable
//fun SuccessScreen(navController: NavController, sharedViewModel: SharedViewModel){
//    //val detaildestinasi = destinasi.filter { destinasi ->
//    //    destinasi.id == destinasiId}
//    val notification by sharedViewModel.notification.observeAsState()
//    Column(
//        modifier = Modifier.fillMaxSize()
//    ) {
////        CenterAlignedTopAppBar(
////            title = {
////                Text("Status Transaksi", style = typography.labelLarge) },
////            navigationIcon = {
////                IconButton(onClick = {navController.navigateUp()}) {
////                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
////                }
////            },
////        )
//        Column(
//            verticalArrangement = Arrangement.Top
//        ) {
//        Image(
//            painter = painterResource(id = R.drawable.berhasil),
//            contentDescription = " ",
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(400.dp)
//                .align(Alignment.CenterHorizontally)
//        )
//            Text(
//                text = "Order Success",
//                style = TextStyle(
//                    fontSize = 35.sp,
//                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight(700),
//                    color = Color(0xFF000000)
//                ), modifier = Modifier.align(Alignment.CenterHorizontally)
//            )
//            Text(
//                text = "Your Tickets are now\navailable, thanks for order!",
//                style = LocalTextStyle.current.merge(
//                    TextStyle(
//                        lineHeight = 1.4.em,
//                        lineHeightStyle = LineHeightStyle(
//                            alignment = LineHeightStyle.Alignment.Center,
//                            trim = LineHeightStyle.Trim.None
//                        )
//                    )
//                ),
//                textAlign = TextAlign.Center,
//                fontSize = 16.sp,
//                color = Color.LightGray,
//                modifier = Modifier.align(Alignment.CenterHorizontally)
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(
//                onClick = {navController.navigate(Screen.Reservation.route)},
//                colors = ButtonDefaults.buttonColors(Color(0xFF007B7F)),
//                modifier = Modifier.align(Alignment.CenterHorizontally)
//                    .width(200.dp)
//            ) {
//                Text(text = "Cek Tiket", color = Color.White)
//            }
//        }
//    }
//}

@Composable
fun SuccessScreen(navController: NavController, sharedViewModel: SharedViewModel) {
    val reservationData by sharedViewModel.reservationData.observeAsState()
    val notification by sharedViewModel.notification.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.berhasil),
            contentDescription = "Success Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Order Success",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF007B7F)
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Your tickets are now available, thanks for your order!",
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))

//        // Display reservation data
//        reservationData?.let {
//            Text(
//                text = "Destination: ${it["destinasi"]}",
//                fontWeight = FontWeight.Bold,
//                fontSize = 16.sp,
//                color = Color.Black
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = "Date: ${it["tanggal"]}",
//                fontSize = 14.sp,
//                color = Color.Gray
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = "Payment: ${it["metodePembayaran"]}",
//                fontSize = 14.sp,
//                color = Color.Gray
//            )
//        } ?: Text(
//            text = "Reservation data is missing.",
//            fontSize = 14.sp,
//            color = Color.Red
//        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate(Screen.Reservation.route) },
            colors = ButtonDefaults.buttonColors(Color(0xFF007B7F)),
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Check Ticket", color = Color.White)
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun rePreview() {
//    TajaMentawaiTheme {
//        SuccessScreen()
//    }
//}