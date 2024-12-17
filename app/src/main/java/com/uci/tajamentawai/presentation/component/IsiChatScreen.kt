package com.example.tajamentawaiapp

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.presentation.component.destinasi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IsiChatScreen(destinasiId: Int?, navController: NavController) {
    val detaildestinasi = destinasi.filter { destinasi ->
        destinasi.id == destinasiId
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Top App Bar
        TopAppBar(
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = detaildestinasi[0].imageRes),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "Profile Image", modifier = Modifier
                            .size(40.dp).clip(CircleShape)
                    )
                    Spacer (modifier = Modifier.width(8.dp))
                    Column {
                        Text(detaildestinasi[0].title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Text("Online", color = Color(0xFF4CAF50), fontSize = 12.sp)
                    }
                }
            },
            navigationIcon = {
                IconButton(onClick = {navController.navigateUp()}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            },
        )
        HorizontalDivider(color = Color.LightGray)
        // Messages
        Column(
            modifier = Modifier
                .fillMaxSize().padding(8.dp)
                .weight(1f)
        ) {
            MessageBubble(
                message = "Halo, apakah disana tersedia untuk tempat menaruh barang-barang yang aman?",
                isSentByMe = true,
                time = "10.00"
            )
            MessageBubble (message =
            "Hi ka, tersedia untuk penitipan barang di loket ya ka nanti dikasih untuk kunci lokernya agar barang aman", isSentByMe = false, time = "10.02")
            MessageBubble(
                message = "Baik min, terimakasih atas informasinya",
                isSentByMe = true,
                time = "10.03"
            )
            MessageBubble (message =
            "Baik Terimakasih Kembali 😊", isSentByMe = false, time = "10.03")
        }
        // Input Field
        ChatInputField()
    }
}

@Composable
fun MessageBubble(message: String, isSentByMe: Boolean, time: String) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = if (isSentByMe) Arrangement.End else Arrangement.Start
    ) {
        Column(horizontalAlignment = if (isSentByMe) Alignment.End else Alignment.Start) {
            Box(
                modifier = Modifier
                    .background(
                        color = if (isSentByMe) Color(0xFF2196F3) else Color(0xFFF1F1F1),
                        shape = MaterialTheme.shapes.medium
                    ).padding(12.dp)
            ) {
                Text(text = message, color = if (isSentByMe) Color.White else Color.Black)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text (text =
            time, color = Color.Gray, fontSize = 10.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatInputField() {
    var message by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = message, onValueChange = { message = it},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
            keyboardActions = KeyboardActions(onSend = {
                //onSendMessage(message)
                message = "" // Kosongkan field setelah pesan dikirim
            }),
//            colors = TextFieldDefaults.colors(
//                //backgroundColor = Color(0xFFF1F1F1),
//                cursorColor = Color.Black, focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
//            )
        )
        Spacer (modifier = Modifier.width(8.dp))
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Send,
                contentDescription = "Localized description"
            )
        }
    }
}