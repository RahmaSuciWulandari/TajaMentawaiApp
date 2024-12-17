package com.example.tajamentawaiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.R
import com.uci.tajamentawai.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentConfirmationScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    "Konfirmasi Pembayaran",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }, navigationIcon = {
                IconButton(onClick = {navController.navigateUp()}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            },
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text (
            text = "Total Pembayaran",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Rp. 40.000",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF00897B)
        )
        Spacer (modifier = Modifier.height(16.dp))

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Metode Pembayaran", fontSize = 14.sp,
                color = Color.Gray
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.dompet), contentDescription = null,
                    tint = Color(0xFF00897B), modifier = Modifier.size(20.dp)
                )
                Spacer (modifier = Modifier.width(4.dp))
                Text(
                    text = "TajaWallet",
                    fontSize = 14.sp, color = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Masukkan PIN TajaWallet", fontSize = 14.sp,
            color = Color.Gray, modifier = Modifier.padding(bottom = 8.dp)
        )
        PinInput(onPinComplete = {
            navController.navigate(Screen.Sukses.route)
        })
    }
}

@Composable
fun PinInput(onPinComplete: () -> Unit) {
    var pin by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(6) { index ->
            val isFilled = index < pin.length
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .padding(4.dp)
                    .background(
                        if (isFilled) Color.Gray else Color.LightGray,
                        shape = RectangleShape
                    )
            )
        }
    }
    Spacer(modifier = Modifier.height(32.dp))
    NumericKeypad(onNumberClick = { number ->
        if (pin.length < 6) {
            pin += number
            if (pin.length == 6) {
                onPinComplete()
            }
        }
    },
        onDeleteClick = {
            if (pin.isNotEmpty()) {
                pin = pin.dropLast(1)
            }
        })
}
@Composable
fun NumericKeypad(onNumberClick: (String) -> Unit, onDeleteClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val keys = listOf(
            listOf("1", "2", "3"),
            listOf("4", "5", "6"), listOf("7", "8", "9"),
            listOf("*", "0", "←")
        )
        for (row in keys) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (key in row) {
                    if (key == "←") {
                        Button(
                            onClick = onDeleteClick,
                            modifier = Modifier.size(60.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFF24A4AC))
                        ) {
                            Text("←")
                        }
                    } else {
                        Button(
                            onClick = { onNumberClick(key) },
                            modifier = Modifier.size(60.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFF24A4AC))
                        ) {
                            Text(text = key, fontSize = 24.sp, textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }
    }
}