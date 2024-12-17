package com.uci.tajamentawai.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaftarChatScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(
            title = { Text("Chat", fontSize = 24.sp, fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            },
        )
        HorizontalDivider(color = Color.LightGray)
        // Chat item
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable { navController.navigate(Screen.Chat.route) }
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically        ) {
//            Image(
//                painter = painterResource(id = detaildestinasi[0].imageRes),
//                contentScale = ContentScale.FillBounds,
//                contentDescription = "Profile Image", modifier = Modifier
//                    .size(48.dp)
//                    .clip(CircleShape)
//            )
//            Spacer (modifier = Modifier.width(12.dp))
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(detaildestinasi[0].title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
//                Text("Halo, apakah disana tersedia untuk temp...", color = Color.Gray)
        // Menampilkan List Chat (Tidak hanya 1 item)
        // Jika ada dummy data atau data real untuk list chat, destinasi bisa di ganti dengan list tersebut
        androidx.compose.foundation.lazy.LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(destinasi) { _, destinasiItem ->
                ChatRow(destinasiItem = destinasiItem, navController = navController)
                HorizontalDivider(color = Color.LightGray)
            }
        }
    }
}

@Composable
fun ChatRow(destinasiItem: Destination, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // Navigate to specific chat screen
                navController.navigate(Screen.Chat.route + "/${destinasiItem.id}")
            }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = destinasiItem.imageRes),
            contentScale = ContentScale.Crop,
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f).padding(end = 15.dp)
        ) {
            Text(destinasiItem.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(
                text = "Halo, apakah disana tersedia untuk tempat menaruh barang-barang yang aman?",
                color = Color.Gray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)
        }
        Text("10.00", color = Color.Gray, fontSize = 12.sp)
    }
}