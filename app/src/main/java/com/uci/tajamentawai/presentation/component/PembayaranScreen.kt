package com.example.tajamentawaiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.uci.tajamentawai.Data.database.AppDatabase
import com.uci.tajamentawai.Data.entity.Reservation
import com.uci.tajamentawai.R
import com.uci.tajamentawai.navigation.Screen
import com.uci.tajamentawai.presentation.component.SharedViewModel
import com.uci.tajamentawai.presentation.component.destinasi
import com.uci.tajamentawai.presentation.component.formatRupiah
import kotlinx.coroutines.launch

@Composable
fun PembayaranScreen(destinasiId: Int?, navController: NavController, database: AppDatabase, sharedViewModel: SharedViewModel) {
    val reservationDao = database.reservationDao()
    val coroutineScope = rememberCoroutineScope()

    val detailDestinasi = destinasi.find { it.id == destinasiId } ?: return
    val paymentMethod by sharedViewModel.paymentMethod.observeAsState()
    val reservationDate by sharedViewModel.reservationDate.observeAsState()
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Bagian Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().offset(x = 3.dp, y = 20.dp)
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Payment",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Detail Destinasi
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = detailDestinasi.imageRes),
                        contentDescription = "Destination Image",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.Gray)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = detailDestinasi.title,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = detailDestinasi.place,
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "08:00 - 18:00 WIB",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Section Rincian Pembayaran
        Text(
            text = "Rincian Pembayaran",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF007BFF)
        )

        Spacer(modifier = Modifier.height(8.dp))

        PaymentDetailRow(label = "Subtotal Tiket", amount = formatRupiah(detailDestinasi.price))
        Spacer(modifier = Modifier.height(4.dp))
        PaymentDetailRow(label = "Total Pembayaran", amount = formatRupiah(detailDestinasi.price), isTotal = true)

        Spacer(modifier = Modifier.height(16.dp))
// Payment Method Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate(Screen.PaymentMethod.route + "/${destinasiId}") }
                .zIndex(1f)
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.wallet_light), // replace with actual icon
                contentDescription = "Metode Pembayaran",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Metode Pembayaran",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = paymentMethod ?: "Belum dipilih",
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        // Date com.uci.tajamentawai.Data.entity.Reservation Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate(Screen.Calender.route + "/${destinasiId}") }
                .zIndex(1f)
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.CalendarMonth,
                contentDescription = "Metode Pembayaran",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Tanggal Reservasi",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = reservationDate ?: "Belum dipilih",
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Bar with Total and Buy Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 16.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Total\nPembayaran : ",
                fontSize = 16.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "\n" + formatRupiah(detailDestinasi.price),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF007BFF),
                modifier = Modifier.offset(x = -20.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    if (paymentMethod.isNullOrEmpty() || reservationDate.isNullOrEmpty()) {
                        showDialog = true
                    } else {
                        val newReservation = Reservation(
                            date = reservationDate.orEmpty(),
                            paymentMethod = paymentMethod.orEmpty(),
                            notification = "Pembelian berhasil!",
                            key = detailDestinasi.title,
                            value = formatRupiah(detailDestinasi.price),
                            images = detailDestinasi.imageRes.toString()
                        )
                        coroutineScope.launch {
                            reservationDao.insertReservation(newReservation)
                            if(paymentMethod == "TajaWallet"){
                                navController.navigate(Screen.Konfir.route)
                            }else{
                                navController.navigate(Screen.Sukses.route){
                                    popUpTo("pembayaran/${destinasiId}") { inclusive = true }
                                }}
                        }

                        navController.previousBackStackEntry?.savedStateHandle?.set("notification", "TRANSAKSI BERHASIL!!!")
                    }
                },
                modifier = Modifier.height(48.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF007BFF))
            ) {
                Text(
                    text = "Beli Tiket",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }

        if (showDialog) {
            MinimalDialog(
                onDismissRequest = { showDialog = false },
                message = when {
                    paymentMethod.isNullOrEmpty() && reservationDate.isNullOrEmpty() -> "Silahkan pilih metode pembayaran dan tanggal reservasi terlebih dahulu."
                    paymentMethod.isNullOrEmpty() -> "Silahkan pilih metode pembayaran terlebih dahulu."
                    reservationDate.isNullOrEmpty() -> "Silahkan pilih tanggal reservasi terlebih dahulu."
                    else -> ""
                }
            )
        }
    }
}


//@Composable
//fun PembayaranScreen(destinasiId: Int?, navController: NavController, sharedViewModel: SharedViewModel) {
//    val detaildestinasi = destinasi.filter { destinasi ->
//        destinasi.id == destinasiId
//    }
//
//    val paymentMethod by sharedViewModel.paymentMethod.observeAsState()
//    val reservationDate by sharedViewModel.reservationDate.observeAsState()
//
//    var showDialog by remember { mutableStateOf(false) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(16.dp)
//    ) {
//        // Header Section
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.fillMaxWidth().offset(x = 3.dp, y = 20.dp)
//        ) {
//            IconButton(onClick = { navController.navigateUp() }) {
//                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
//            }
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(
//                text = "Payment",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.weight(1f),
//                textAlign = TextAlign.Center
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Destination Detail Card
//        Card(
//            shape = RoundedCornerShape(8.dp),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Column(modifier = Modifier.padding(16.dp)) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Image(
//                        painter = painterResource(id = detaildestinasi[0].imageRes),
//                        contentDescription = "Kulukubuk Waterfall",
//                        modifier = Modifier
//                            .size(64.dp)
//                            .clip(RoundedCornerShape(8.dp))
//                            .background(Color.Gray)
//                    )
//
//                    Spacer(modifier = Modifier.width(16.dp))
//
//                    Column {
//                        Text(
//                            text = detaildestinasi[0].title,
//                            fontWeight = FontWeight.SemiBold,
//                            fontSize = 16.sp
//                        )
//                        Text(
//                            text = detaildestinasi[0].place,
//                            color = Color.Gray,
//                            fontSize = 14.sp
//                        )
//                        Spacer(modifier = Modifier.height(4.dp))
//                        Text(
//                            text = "08:00 - 18:00 WIB",
//                            color = Color.Gray,
//                            fontSize = 14.sp
//                        )
//                    }
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Payment Details Section
//        Text(
//            text = "Rincian Pembayaran",
//            fontSize = 16.sp,
//            fontWeight = FontWeight.SemiBold,
//            color = Color(0xFF007BFF)
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        PaymentDetailRow(label = "Subtotal Tiket", amount = formatRupiah(detaildestinasi[0].price))
//        Spacer(modifier = Modifier.height(4.dp))
//        PaymentDetailRow(label = "Total Pembayaran", amount = formatRupiah(detaildestinasi[0].price), isTotal = true)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Payment Method Section
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable { navController.navigate(Screen.PaymentMethod.route + "/${destinasiId}") }
//                .zIndex(1f)
//                .padding(vertical = 12.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.wallet_light), // replace with actual icon
//                contentDescription = "Metode Pembayaran",
//                modifier = Modifier.size(24.dp)
//            )
//            Spacer(modifier = Modifier.width(12.dp))
//            Text(
//                text = "Metode Pembayaran",
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Medium
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Text(
//                text = paymentMethod ?: "Belum dipilih",
//                fontSize = 16.sp,
//                color = Color.Gray
//            )
//        }
//
//        // Date com.uci.tajamentawai.Data.entity.Reservation Section
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable { navController.navigate(Screen.Calender.route + "/${destinasiId}") }
//                .zIndex(1f)
//                .padding(vertical = 12.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                imageVector = Icons.Default.CalendarMonth,
//                contentDescription = "Metode Pembayaran",
//                modifier = Modifier.size(24.dp)
//            )
//            Spacer(modifier = Modifier.width(12.dp))
//            Text(
//                text = "Tanggal Reservasi",
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Medium
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Text(
//                text = reservationDate ?: "Belum dipilih",
//                fontSize = 16.sp,
//                color = Color.Gray
//            )
//        }
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        // Bottom Bar with Total and Buy Button
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White)
//                .padding(vertical = 16.dp, horizontal = 8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "Total\nPembayaran : ",
//                fontSize = 16.sp,
//                color = Color.Gray
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Text(
//                text = "\n" + formatRupiah(detaildestinasi[0].price),
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color(0xFF007BFF),
//                modifier = Modifier.offset(x = -20.dp)
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Button(
//                onClick = {
//                    if (paymentMethod.isNullOrEmpty() || reservationDate.isNullOrEmpty()) {
//                        showDialog = true
//                    } else {
//                        sharedViewModel.setNotification("Pembelian berhasil!")
//                        sharedViewModel.setReservationData(
//                            mapOf(
//                                "destinasi" to detaildestinasi[0].title,
//                                "tanggal" to reservationDate.orEmpty(),
//                                "metodePembayaran" to paymentMethod.orEmpty(),
//                                "harga" to detaildestinasi[0].price.toString()
//                            )
//                        )
//                        if(paymentMethod == "TajaWallet"){
//                            navController.navigate(Screen.Konfir.route)
//                        }else{
//                            navController.navigate(Screen.Sukses.route){
//                                popUpTo("pembayaran/${destinasiId}") { inclusive = true }
//                            }}
//                        navController.previousBackStackEntry?.savedStateHandle?.set("notification", "Pembelian berhasil!")
//                    }
//                },
//                modifier = Modifier.height(48.dp),
//                colors = ButtonDefaults.buttonColors(Color(0xFF007BFF))
//            ) {
//                Text(
//                    text = "Beli Tiket",
//                    color = Color.White,
//                    fontSize = 16.sp
//                )
//            }
//        }
//
//        if (showDialog) {
//            MinimalDialog(
//                onDismissRequest = { showDialog = false },
//                message = when {
//                    paymentMethod.isNullOrEmpty() && reservationDate.isNullOrEmpty() -> "Silahkan pilih metode pembayaran dan tanggal reservasi terlebih dahulu."
//                    paymentMethod.isNullOrEmpty() -> "Silahkan pilih metode pembayaran terlebih dahulu."
//                    reservationDate.isNullOrEmpty() -> "Silahkan pilih tanggal reservasi terlebih dahulu."
//                    else -> ""
//                }
//            )
//        }
//    }
//}


@Composable
fun MinimalDialog(onDismissRequest: () -> Unit, message: String) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = message,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
            )
        }
    }
}


//@Composable
//fun MinimalDialog(onDismissRequest: () -> Unit) {
//    Dialog(onDismissRequest = { onDismissRequest() }) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .padding(16.dp),
//            shape = RoundedCornerShape(16.dp),
//        ) {
//            Text(
//                text = "Silahkan pilih metode pembayaran dan tanggal reservasi terlebih dahulu",
//                modifier = Modifier
//                    .fillMaxSize()
//                    .wrapContentSize(Alignment.Center),
//                textAlign = TextAlign.Center,
//            )
//        }
//    }
//}



@Composable
fun PaymentDetailRow(label: String, amount: String, isTotal: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontSize = if (isTotal) 16.sp else 14.sp,
            fontWeight = if (isTotal) FontWeight.SemiBold else FontWeight.Normal,
            color = if (isTotal) Color.Black else Color.Gray
        )
        Text(
            text = amount,
            fontSize = if (isTotal) 16.sp else 14.sp,
            fontWeight = if (isTotal) FontWeight.SemiBold else FontWeight.Normal,
            color = if (isTotal) Color(0xFF007BFF) else Color.Black
        )
    }
}
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Card
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.window.Dialog
//import androidx.navigation.NavController
//import com.uci.tajamentawai.R
//import com.uci.tajamentawai.navigation.Screen
//import com.uci.tajamentawai.presentation.component.destinasi
//import com.uci.tajamentawai.presentation.component.formatRupiah
//
//
//@Composable
//fun PembayaranScreen(destinasiId: Int?, navController: NavController) {
//    val detaildestinasi = destinasi.filter { destinasi ->
//        destinasi.id == destinasiId}
//    val paymentMethod = navController.currentBackStackEntry?.savedStateHandle?.get<String>("paymentMethod")
//    val reservationDate = navController.currentBackStackEntry?.savedStateHandle?.get<String>("reservationDate")
//    var showDialog by remember { mutableStateOf(false) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(16.dp)
//    ) {
//        // Header
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.fillMaxWidth()
//                .offset(x = 3.dp,
//                    y = 20.dp)
//        ) {
//            IconButton(onClick = { navController.navigateUp()}) {
//                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
//            }
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(
//                text = "Payment",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.weight(1f),
//                textAlign = TextAlign.Center
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Destination Detail Card
//        Card(
//            shape = RoundedCornerShape(8.dp),
//            modifier = Modifier.fillMaxWidth(),
////            elevation = 4.dp
//        ) {
//            Column(modifier = Modifier.padding(16.dp)) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Image(
//                        painter = painterResource(id = detaildestinasi[0].imageRes),
//                        contentDescription = "Kulukubuk Waterfall",
//                        modifier = Modifier
//                            .size(64.dp)
//                            .clip(RoundedCornerShape(8.dp))
//                            .background(Color.Gray)
//                    )
//
//                    Spacer(modifier = Modifier.width(16.dp))
//
//                    // Destination Info
//                    Column {
//                        Text(
//                            text = detaildestinasi[0].title,
//                            fontWeight = FontWeight.SemiBold,
//                            fontSize = 16.sp
//                        )
//                        Text(
//                            text = detaildestinasi[0].place,
//                            color = Color.Gray,
//                            fontSize = 14.sp
//                        )
//                        Spacer(modifier = Modifier.height(4.dp))
//                        Text(
//                            text = "08:00 - 18:00 WIB",
//                            color = Color.Gray,
//                            fontSize = 14.sp
//                        )
//                    }
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Payment Details
//        Text(
//            text = "Rincian Pembayaran",
//            fontSize = 16.sp,
//            fontWeight = FontWeight.SemiBold,
//            color = Color(0xFF007BFF)
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        PaymentDetailRow(label = "Subtotal Tiket", amount = formatRupiah(detaildestinasi[0].price))
//        Spacer(modifier = Modifier.height(4.dp))
//        PaymentDetailRow(label = "Total Pembayaran", amount = formatRupiah(detaildestinasi[0].price), isTotal = true)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Payment Method Section
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable { navController.navigate(Screen.PaymentMethod.route +"/${destinasiId}") }
//                .padding(vertical = 12.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.wallet_light), // replace with actual icon
//                contentDescription = "Metode Pembayaran",
//                modifier = Modifier.size(24.dp)
//            )
//            Spacer(modifier = Modifier.width(12.dp))
//            Text(
//                text = "Metode Pembayaran",
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Medium
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Text(
//                text = paymentMethod ?: "Belum dipilih",
//                fontSize = 16.sp,
//                color = Color.Gray
//            )
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable { navController.navigate(Screen.Calender.route +"/${destinasiId}") }
//                .padding(vertical = 12.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.wallet_light), // replace with actual icon
//                contentDescription = "Metode Pembayaran",
//                modifier = Modifier.size(24.dp)
//            )
//            Spacer(modifier = Modifier.width(12.dp))
//            Text(
//                text = "Tanggal Reservasi",
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Medium
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Text(
//                text = reservationDate ?: "Belum dipilih",
//                fontSize = 16.sp,
//                color = Color.Gray
//            )
//        }
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        // Bottom Bar with Total and Buy Button
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White)
//                .padding(vertical = 16.dp, horizontal = 8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "Total\nPembayaran : ",
//                fontSize = 16.sp,
//                color = Color.Gray
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Text(
//                text = "\n" + formatRupiah(detaildestinasi[0].price),
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color(0xFF007BFF),
//                modifier = Modifier.offset(x = -20.dp)
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Button(
//                onClick = {
//                    if (paymentMethod.isNullOrEmpty() || reservationDate.isNullOrEmpty()) {
//                        showDialog = true
//                    } else {
//                        if(paymentMethod == "TajaWallet"){
//                            navController.navigate(Screen.Konfir.route)
//                        }else{
//                            navController.navigate(Screen.Sukses.route){
//                                popUpTo("pembayaran/${destinasiId}") { inclusive = true }
//                            }
//                        }
//                        navController.previousBackStackEntry?.savedStateHandle?.set("notification", "Pembelian berhasil!")
//                    }
//                    },
//                modifier = Modifier.height(48.dp),
//                colors = ButtonDefaults.buttonColors(Color(0xFF007BFF))
//            ) {
//                Text(
//                    text = "Beli Tiket",
//                    color = Color.White,
//                    fontSize = 16.sp
//                )
//            }
//        }
//        if (showDialog) { MinimalDialog(onDismissRequest = { showDialog = false }) }
//    }
//}
//
//@Composable
//fun MinimalDialog(onDismissRequest: () -> Unit) {
//    Dialog(onDismissRequest = { onDismissRequest() }) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .padding(16.dp),
//            shape = RoundedCornerShape(16.dp),
//        ) {
//            Text(
//                text = "Silahkan pilih metode pembayaran dan tanggal reservasi terlebih dahulu",
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp)
//                    .wrapContentSize(Alignment.Center),
//                textAlign = TextAlign.Center,
//            )
//        }
//    }
//}
//
//@Composable
//fun PaymentDetailRow(label: String, amount: String, isTotal: Boolean = false) {
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Text(
//            text = label,
//            fontSize = if (isTotal) 16.sp else 14.sp,
//            fontWeight = if (isTotal) FontWeight.SemiBold else FontWeight.Normal,
//            color = if (isTotal) Color.Black else Color.Gray
//        )
//        Text(
//            text = amount,
//            fontSize = if (isTotal) 16.sp else 14.sp,
//            fontWeight = if (isTotal) FontWeight.SemiBold else FontWeight.Normal,
//            color = if (isTotal) Color(0xFF007BFF) else Color.Black
//        )
//    }
//}