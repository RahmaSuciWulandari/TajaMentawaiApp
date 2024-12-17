package com.uci.tajamentawai.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.R
import com.uci.tajamentawai.navigation.Screen

@Composable
fun AccountProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(top = 0.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pantaijati2), // Ganti dengan drawable sesuai
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.Center)
                        .offset(y=100.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bangchan),
                        contentDescription = "Profile Picture",
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.White, CircleShape)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Christopher Bang", style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center)
                    Text("Frontend Developer/Travel Photographer", style = MaterialTheme.typography.labelLarge)
                }
            }
            Spacer(modifier = Modifier.height(150.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text("Name", style = MaterialTheme.typography.labelMedium)
            Text("Christopher Bang", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(
                color = Color(0xffc4c4c4),
                modifier = Modifier
                    .offset(y = -5.dp)
                    .fillMaxWidth()
                    .requiredHeight(height = 10.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text("Email", style = MaterialTheme.typography.labelMedium)
            Text("chris.bang@gmail.com", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(
                color = Color(0xffc4c4c4),
                modifier = Modifier
                    .offset(y = -5.dp)
                    .fillMaxWidth()
                    .requiredHeight(height = 10.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text("Phone No", style = MaterialTheme.typography.labelMedium)
            Text("+62 812 - 3456 - 7891", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(
                color = Color(0xffc4c4c4),
                modifier = Modifier
                    .offset(y = -5.dp)
                    .fillMaxWidth()
                    .requiredHeight(height = 10.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text("Date of Birth", style = MaterialTheme.typography.labelMedium)
            Text("03 Oktober 1997", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(
                color = Color(0xffc4c4c4),
                modifier = Modifier
                    .offset(y = -5.dp)
                    .fillMaxWidth()
                    .requiredHeight(height = 10.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text("Address", style = MaterialTheme.typography.labelMedium)
            Text("Depok, Indonesia", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(
                color = Color(0xffc4c4c4),
                modifier = Modifier
                    .offset(y = -5.dp)
                    .fillMaxWidth()
                    .requiredHeight(height = 10.dp))
        }
    }
}

//versi 2
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
       // .background(Color(0xFFF5F5F5))
    )
    {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.pantaijati2),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                            .requiredHeight(150.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,

                        )


                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .align(Alignment.BottomCenter)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bangchan),
                            contentDescription = "User avatar",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Christopher Bang", style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center)
                    Text("@gnabnahc", style = MaterialTheme.typography.labelMedium)
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Pengaturan akun",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            //SettingItem(icon = Icons.Filled.Person, text = "Info Wisatawan", navController)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .clickable { navController.navigate(Screen.InfoW.route) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = " ",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text("Info Wisatawan", color = Color.Gray, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))
            //SettingItem(icon = Icons.Filled.Phone, text = "Informasi Kontak", navController)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .clickable { navController.navigate(Screen.InfoK.route) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = " ",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text("Informasi Kontak", color = Color.Gray, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Keamanan",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            //SettingItem(icon = Icons.Filled.Lock, text = "Ubah Kata Sandi", navController)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .clickable { navController.navigate(Screen.UbahS.route) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = " ",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text("Ubah Kata Sandi", color = Color.Gray, fontSize = 16.sp)
            }
        }

        }
    }


@Composable
fun SettingItem(icon: ImageVector, text: String, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
            .clickable { navController.navigate(Screen.InfoW.route) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text, color = Color.Gray, fontSize = 16.sp)
    }
}

//info Wisatawan
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountSettingsScreen(navController: NavController) {
    var username by remember { mutableStateOf("@gnabnahc") }
    var displayName by remember { mutableStateOf("Christoper Bang") }
    var domicile by remember { mutableStateOf("Mentawai") }
    var about by remember { mutableStateOf("Halo, saya chan, seorang traveller yang suka travelling yang senang menjelajah alam dan budaya unik di setiap sudut Indonesia.") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(top = 0.dp)
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.pantaijati2),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                                .requiredHeight(100.dp),
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center,

                        )
                           IconButton(
                               onClick = { /* Handle edit background */ },
                               modifier = Modifier
                                   .align(Alignment.TopEnd)
                                   .background(Color(0xFF004D40), CircleShape)
                                   .padding(4.dp)
                                   .size(40.dp)
                           ) {
                               Icon(
                                   imageVector = Icons.Default.Edit,
                                   contentDescription = "Edit Background",
                                   tint = Color.White,
                                   modifier = Modifier.size(20.dp)
                               )
                           }



                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                                .align(Alignment.BottomCenter)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.bangchan),
                                contentDescription = "User avatar",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )


                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .offset(x=-120.dp),
                            //contentAlignment = Alignment.BottomCenter
                        ) {
                            IconButton(
                                onClick = { /* Handle edit avatar */ },
                                modifier = Modifier
                                    .background(Color(0xFF004D40), CircleShape)
                                    .padding(4.dp)
                                    .size(30.dp)
                                    .align(Alignment.BottomEnd)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "Edit Profile",
                                    tint = Color.White,
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Username") },
                        readOnly = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = displayName,
                        onValueChange = { displayName = it },
                        label = { Text("Nama yang ditampilkan di komunitas") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = domicile,
                        onValueChange = { domicile = it },
                        label = { Text("Domisili") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = about,
                        onValueChange = { about = it },
                        label = { Text("Tentang Wisatawan") },
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 4
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {navController.navigate(Screen.Profile.route)},
                        modifier = Modifier.align(Alignment.End),
                        colors = ButtonDefaults.buttonColors(Color(0xFF004D40))
                    ) {
                        Text(text = "Simpan", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun ContactScreen(navController: NavController) {
    var emailName by remember { mutableStateOf("") }
    var numberPhone by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6)),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Email",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF4A4A4A),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                OutlinedTextField(
                    value = emailName,
                    onValueChange = { emailName = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Masukkan Email Anda") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Phone Number",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF4A4A4A),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                OutlinedTextField(
                    value = numberPhone,
                    onValueChange = { numberPhone = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Masukkan Nomor Telepon Anda") }
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { navController.navigate(Screen.Profile.route) },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF1E3A8A))
                ) {
                    Text(text = "Simpan", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun ChangePasswordScreen(navController: NavController) {
    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6)),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Kata Sandi Lama",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF4A4A4A),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                OutlinedTextField(
                    value = oldPassword,
                    onValueChange = { oldPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("****************") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Kata Sandi Baru",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF4A4A4A),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                OutlinedTextField(
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Masukkan Kata sandi baru") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Ulangi Kata Sandi Baru",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF4A4A4A),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Masukkan Kata sandi baru") }
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { navController.navigate(Screen.Profile.route) },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF1E3A8A))
                ) {
                    Text(text = "Simpan", color = Color.White)
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun ProfileScreenPreview() {
//    TajaMentawaiTheme {
//        ChangePasswordScreen()
//    }
//}