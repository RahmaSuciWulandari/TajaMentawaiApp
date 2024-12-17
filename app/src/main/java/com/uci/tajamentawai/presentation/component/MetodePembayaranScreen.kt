package com.uci.tajamentawai.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.R
import dagger.hilt.android.AndroidEntryPoint


//@Composable
//fun MetodePembayaranScreen(destinasiId: Int?, navController: NavController) {
//    var selectedMethod by remember { mutableStateOf("TajaWallet") }
//    var isTransferExpanded by remember { mutableStateOf(false) }
//    var selectedBank by remember { mutableStateOf("") }
//    val detaildestinasi = destinasi.filter { destinasi ->
//        destinasi.id == destinasiId}
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
//                .padding(vertical = 8.dp)
//        ) {
//            IconButton(onClick = { navController.navigateUp()}) {
//                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
//            }
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(
//                text = "Metode Pembayaran",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.weight(1f),
//                textAlign = TextAlign.Center
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Payment Method List
//        PaymentMethodItem(
//            methodName = "TajaWallet",
//            balance = "Saldo Rp45.000",
//            isSelected = selectedMethod == "TajaWallet",
//            onClick = { selectedMethod = "TajaWallet" }
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        PaymentMethodItem(
//            methodName = "Transfer Bank",
//            balance = null,
//            isSelected = selectedMethod == "Transfer Bank",
//            onClick = {
//                selectedMethod = "Transfer Bank"
//                isTransferExpanded = !isTransferExpanded
//            }
//        )
//        if (isTransferExpanded) {
//            BankOptionItem(
//                bankName = "Bank BCA",
//                isSelected = selectedBank == "Bank BCA",
//                onClick = { selectedBank = "Bank BCA" }
//            )
//            BankOptionItem(
//                bankName = "Bank Mandiri",
//                isSelected = selectedBank == "Bank Mandiri",
//                onClick = { selectedBank = "Bank Mandiri" }
//            )
//            BankOptionItem(
//                bankName = "Bank BNI",
//                isSelected = selectedBank == "Bank BNI",
//                onClick = { selectedBank = "Bank BNI" }
//            )
//            BankOptionItem(
//                bankName = "Bank Syariah Indonesia (BSI)",
//                isSelected = selectedBank == "Bank Syariah Indonesia (BSI)",
//                onClick = { selectedBank = "Bank Syariah Indonesia (BSI)" }
//            )
//        }
//        Spacer(modifier = Modifier.weight(1f))
//
//        Button(
//            onClick = {
//                val paymentMethod = if (selectedMethod == "Transfer Bank") selectedBank else selectedMethod
//                navController.previousBackStackEntry?.savedStateHandle?.set("paymentMethod", paymentMethod)
//                navController.navigateUp()
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 16.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006064))
//        ) {
//            Text(
//                text = "Konfirmasi",
//                fontSize = 16.sp,
//                color = Color.White,
//                fontWeight = FontWeight.Bold
//            )
//        }
//    }
//}

@Composable
fun MetodePembayaranScreen(destinasiId: Int?, navController: NavController, sharedViewModel: SharedViewModel) {
    var selectedMethod by remember { mutableStateOf("TajaWallet") }
    var isTransferExpanded by remember { mutableStateOf(false) }
    var selectedBank by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Metode Pembayaran",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Payment Method List
        PaymentMethodItem(
            methodName = "TajaWallet",
            balance = "Saldo Rp45.000",
            isSelected = selectedMethod == "TajaWallet",
            onClick = { selectedMethod = "TajaWallet" }
        )

        Spacer(modifier = Modifier.height(8.dp))

        PaymentMethodItem(
            methodName = "Transfer Bank",
            balance = null,
            isSelected = selectedMethod == "Transfer Bank",
            onClick = {
                selectedMethod = "Transfer Bank"
                isTransferExpanded = !isTransferExpanded
            }
        )

        if (isTransferExpanded) {
            BankOptionItem(
                bankName = "Bank BCA",
                isSelected = selectedBank == "Bank BCA",
                onClick = { selectedBank = "Bank BCA" }
            )
            BankOptionItem(
                bankName = "Bank Mandiri",
                isSelected = selectedBank == "Bank Mandiri",
                onClick = { selectedBank = "Bank Mandiri" }
            )
            BankOptionItem(
                bankName = "Bank BNI",
                isSelected = selectedBank == "Bank BNI",
                onClick = { selectedBank = "Bank BNI" }
            )
            BankOptionItem(
                bankName = "Bank Syariah Indonesia (BSI)",
                isSelected = selectedBank == "Bank Syariah Indonesia (BSI)",
                onClick = { selectedBank = "Bank Syariah Indonesia (BSI)" }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                val paymentMethod = if (selectedMethod == "Transfer Bank") selectedBank else selectedMethod
                sharedViewModel.setPaymentMethod(paymentMethod)
                navController.navigateUp()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006064))
        ) {
            Text(
                text = "Konfirmasi",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun PaymentMethodItem(methodName: String, balance: String?, isSelected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp)
    ) {
        // Payment Icon
        Icon(
            painter = painterResource(
                id = if (methodName == "TajaWallet") R.drawable.wallet_light else R.drawable.money_fill // Replace with your icons
            ),
            contentDescription = methodName,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = methodName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            balance?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Radio button to show selection
        RadioButton(
            selected = isSelected,
            onClick = onClick
        )
    }
}



@Composable
fun BankOptionItem(bankName: String, isSelected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text(
            text = bankName,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )

        RadioButton(
            selected = isSelected,
            onClick = onClick
        )
    }
}
