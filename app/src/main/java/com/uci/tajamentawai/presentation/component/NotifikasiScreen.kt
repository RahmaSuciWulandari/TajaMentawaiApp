package com.uci.tajamentawai.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.uci.tajamentawai.Data.database.AppDatabase
import com.uci.tajamentawai.R

@Composable
fun NotifikasiScreen(database: AppDatabase) {
    val reservationDao = database.reservationDao()
    val reservations by reservationDao.getAllReservations().collectAsState(initial = emptyList())

    Column(
        //modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                .background(color = Color(0xff084360))){
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Notifications",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

        }

        Spacer(modifier = Modifier.height(8.dp))


        if (reservations.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize()
            ){
                Column (
                    modifier = Modifier. align(Alignment.CenterHorizontally)
                        .padding(top = 150.dp),
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(id = R.drawable.notip),
                        contentDescription = "",
                        modifier = Modifier
                            .size(250.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = "Belum Ada Notifikasi",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xff084360),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = "Semua notifikasi yang kami kirim akan muncul di\nsini supaya anda dapat mengeceknya dengan\nmudah kapan pun",
                        style = LocalTextStyle.current.merge(
                            TextStyle(
                                lineHeight = 1.4.em,
                                lineHeightStyle = LineHeightStyle(
                                    alignment = LineHeightStyle.Alignment.Center,
                                    trim = LineHeightStyle.Trim.None
                                )
                            )
                        ),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        color = Color.LightGray,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }else{
            LazyColumn {
                items(reservations) { reservation ->
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "TRANSAKSI BERHASIL!!!",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Destinasi: ${reservation.key}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                            Text(text = "Tanggal: ${reservation.date}")
                            Text(text = "Metode Pembayaran: ${reservation.paymentMethod}")
                        }
                    }
                }
            }

//            reservations.forEach { reservation ->
//                Card(
//                    shape = RoundedCornerShape(8.dp),
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .fillMaxWidth()
//                ) {
//                    Column (
//                        modifier = Modifier
//                            .padding(8.dp)
//                            .fillMaxWidth()
//                    ){
//                            Text(
//                                text = "TRANSAKSI BERHASIL!!!",
//                                color = Color.Black,
//                                fontSize = 18.sp,
//                                fontWeight = FontWeight.Bold
//                            )
//
//                        Spacer(modifier = Modifier.height(8.dp))
//                        Text(text = "Destinasi: ${reservation.key}",
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 15.sp
//                        )
//                        Text(text = "Tanggal: ${reservation.date}")
//                        Text(text = "Metode Pembayaran: ${reservation.paymentMethod}")
//                    }
//                }
//            }
        }
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun NotifikasiScreen(){
//    val notificationMessage = remember { mutableStateOf("") }
//    val navController = rememberNavController()
//    navController.currentBackStackEntry?.savedStateHandle?.getLiveData<String>("notification")?.observeAsState()?.value?.let {
//        notificationMessage.value = it
//    }
//    Column(
//        modifier = Modifier.fillMaxSize()
//    ){
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(100.dp)
//            .clip(shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
//            .background(color = Color(0xff084360))){
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(
//                text = "Notifications",
//                color = Color.White,
//                fontWeight = FontWeight.Bold
//            )
//        }
//
//    }
//        Column (
//            modifier = Modifier. align(Alignment.CenterHorizontally)
//                .padding(top = 150.dp),
//            verticalArrangement = Arrangement.Center
//        ){
//            Image(
//                painter = painterResource(id = R.drawable.notip),
//                contentDescription = "",
//                modifier = Modifier
//                    .size(250.dp)
//                    .align(Alignment.CenterHorizontally)
//            )
//            Text(
//                text = "Belum Ada Notifikasi",
//                fontWeight = FontWeight.Bold,
//                color = Color(0xff084360),
//                modifier = Modifier.align(Alignment.CenterHorizontally)
//            )
//            Text(
//                text = "Semua notifikasi yang kami kirim akan muncul di\nsini supaya anda dapat mengeceknya dengan\nmudah kapan pun",
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
//                fontSize = 14.sp,
//                color = Color.LightGray,
//                modifier = Modifier.align(Alignment.CenterHorizontally)
//            )
//        }
//}
// }
//
//@Preview(showBackground = true)
//@Composable
//fun reePreview() {
//    TajaMentawaiTheme {
//        NotifikasiScreen()
//    }
//}