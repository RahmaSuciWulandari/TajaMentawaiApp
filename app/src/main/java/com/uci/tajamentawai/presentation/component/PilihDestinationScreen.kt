package com.uci.tajamentawai.presentation.component

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.uci.tajamentawai.R
import com.uci.tajamentawai.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PilihDestinationScreen(destinasiId: Int?, navController: NavController) {
    val context = LocalContext.current
    val detaildestinasi = destinasi.filter { destinasi ->
        destinasi.id == destinasiId
    }
    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(" ")
            },
            navigationIcon = {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { navController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color.Black,
                        )
                    }

//                        IconButton(onClick = { }) {
//                                Icon(
//                                    imageVector = Icons.Default.Bookmark,
//                                    contentDescription = null,
//                                    tint = Color.Black,
//                                    modifier = Modifier.clickable { /* Handle back click */ }
//                                )
//                        }
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.clickable { shareItem(context) }
                            )
                        }
                    }

            },
            modifier = Modifier.zIndex(2f)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 56.dp)
        ) {



            Image(
                painter = painterResource(id = detaildestinasi[0].imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop

            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .offset(y = (-70).dp)
                    .fillMaxWidth()
                    .requiredHeight(85.dp)
                    .clip(shape = RoundedCornerShape(35.dp))
                    .background(color = Color.White)
                    .padding(
                        start = 9.dp,
                        end = 13.dp
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(x = 4.dp, y = 10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .width(300.dp)
                    ) {
                        Text(
                            text = detaildestinasi[0].title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = detaildestinasi[0].place,
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.Gray
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 10.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFFFD700),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = detaildestinasi[0].rating.toString(), style = MaterialTheme.typography.labelMedium)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(
                    color = Color(0xffc4c4c4),
                    modifier = Modifier
                        .offset(y = 60.dp)
                        .fillMaxWidth()
                        .requiredHeight(height = 5.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier.padding(8.dp)) {
                Column {
                    Box(
                        modifier = Modifier
                            .offset(y = (-90).dp)
                            .requiredWidth(150.dp)
                            .requiredHeight(35.dp)
                            .clip(shape = RoundedCornerShape(35.dp))
                            .background(Color(0xFF00897B))
                            .padding(
                                start = 9.dp,
                                end = 13.dp
                            )
                    ) {
                        Text(
                            text = "General Information",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .offset(x = 8.dp, y = 10.dp)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier
                            .offset(x = 2.dp, y = (-75).dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.clock),
                            contentDescription = "Clock",
                            modifier = Modifier
                                .requiredWidth(27.dp)
                                .requiredHeight(28.dp)
                        )
                        Column {
                            Text(
                                text = "Operational",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "08.00 WIB - 18.00 WIB",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 14.sp
                                )
                            )

                        }

                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier
                            .offset(x = 2.dp, y = (-65).dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.group),
                            contentDescription = "Group",
                            modifier = Modifier
                                .requiredWidth(27.dp)
                                .requiredHeight(28.dp)
                        )
                        Column(verticalArrangement = Arrangement.Center) {
                            Text(
                                text = "Fasilitas Yang Tersedia",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                                Column {
                                    Image(
                                        painter = painterResource(id = R.drawable.toilet),
                                        contentDescription = "icon-park-solid:public-toilet",
                                        modifier = Modifier
                                            .requiredSize(size = 30.dp)
                                    )
                                    Text(
                                        text = "Toilet",
                                        color = Color(0xff2e2e2e),
                                        lineHeight = 11.67.em,
                                        style = TextStyle(
                                            fontSize = 12.sp
                                        )
                                    )
                                }
                                Column {
                                    Image(
                                        painter = painterResource(id = R.drawable.restaurant),
                                        contentDescription = "ic:outline-restaurant-menu",
                                        colorFilter = ColorFilter.tint(Color(0xff979797)),
                                        modifier = Modifier
                                            .requiredSize(size = 30.dp)
                                            .align(Alignment.CenterHorizontally)
                                    )
                                    Text(
                                        text = "Rumah Makan",
                                        color = Color(0xff2e2e2e),
                                        lineHeight = 11.67.em,
                                        style = TextStyle(
                                            fontSize = 12.sp
                                        )
                                    )
                                }
                            }
                        }

                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column {
                    Box(
                        modifier = Modifier
                            .offset(y = (-50).dp)
                            .requiredWidth(150.dp)
                            .requiredHeight(35.dp)
                            .clip(shape = RoundedCornerShape(35.dp))
                            .background(Color(0xFF00897B))
                            .padding(
                                start = 9.dp,
                                end = 13.dp
                            )
                    ) {
                        Text(
                            text = "Detail",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .offset(x = 2.dp, y = (-40).dp)
                    ) {
                        Text(
                            text = detaildestinasi[0].detail,
                            color = Color.Black.copy(alpha = 0.6f),
                            style = TextStyle(
                                fontSize = 14.sp
                            ),
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentHeight(align = Alignment.CenterVertically)
                        )
//                    Text(
//                        text = "...Read More",
//                        style = MaterialTheme.typography.bodyMedium,
//                        fontWeight = FontWeight.Bold,
//                        color = Color(0xFF007B7F),
//                        modifier = Modifier
//                            .offset(x = 150.dp, y = (-33).dp)
//                            .clickable { /* Handle read more click */ }
//                    )
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Column {
                    Box(
                        modifier = Modifier
                            .offset(y = (-70).dp)
                            .requiredWidth(150.dp)
                            .requiredHeight(35.dp)
                            .clip(shape = RoundedCornerShape(35.dp))
                            .background(Color(0xFF00897B))
                            .padding(
                                start = 9.dp,
                                end = 13.dp
                            )
                    ) {
                        Text(
                            text = "Review",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .offset(x = 2.dp, y = (-70).dp)
                    ) {
                        Row {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color(0xFFFFD700),
                                modifier = Modifier.size(40.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "4.8",
                                style = MaterialTheme.typography.titleMedium,
                                fontSize = 35.sp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Lihat Semua (100)",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xFF007B7F),
                                modifier = Modifier.fillMaxWidth()
                                    .offset(x = 200.dp)
                                    .clickable { }
                            )
                        }
                    }
                    Column(
                        modifier = Modifier.offset(y = (-70).dp)
                    ) {
                        ReviewItem(
                            name = "Christopher Bang",
                            rating = 5,
                            comment = "I had a fantastic time with my guide Levi."
                        )
                        ReviewItem(
                            name = "Hwang Hyunjin",
                            rating = 5,
                            comment = "One of my most beautiful trips to South East Asia..."
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .requiredHeight(height = 74.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .background(color = Color(0xff084360))
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = formatRupiah(detaildestinasi[0].price),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Row {
                    Button(onClick = { navController.navigate(Screen.Chat.route +"/${destinasiId}") }) { //+ "/${destinasiId}"
                        Text(text = "Chat")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {navController.navigate(Screen.ReservationNow.route + "/${destinasiId}") }, // + "/${destinasiId}"
                        colors = ButtonDefaults.buttonColors(Color(0xFF007B7F))
                    ) {
                        Text(text = "Reserve Now", color = Color.White)
                    }
                }
            }

        }
    }
}


@Composable
fun ReviewItem(name: String, rating: Int, comment: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = name, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(rating) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFFFD700),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = comment, style = MaterialTheme.typography.bodyMedium)
    }
}

//    @Preview(showBackground = true)
//    @Composable
//    fun Greview() {
//        TajaMentawaiTheme {
//            PilihDestinationScreen()
//        }}
