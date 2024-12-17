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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelGuideScreen(navController:NavController) {
    val selectedFilter = remember { mutableStateOf("Populer") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = {navController.navigateUp()}) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item { CoverImageWithSearchBar() }
            item {Spacer(modifier = Modifier.height(75.dp))
                HeaderSection()}
            item{FilterBar(selectedFilter) }
          //  Spacer(modifier = Modifier.height(8.dp))
            item{ Spacer(modifier = Modifier.height(16.dp))
                ContentSection(selectedFilter.value)}

        }
    }
}

@Composable
fun CoverImageWithSearchBar() {
    Box(
        modifier = Modifier
            .width(500.dp)
            .height(300.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.travelguidecover),
            contentDescription = "Travel Guide Cover",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2 / 2f),
            contentScale = ContentScale.Crop
        )
        Column {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val searchQuery = remember { mutableStateOf("") }
                TextField(
                    value = searchQuery.value, onValueChange = { searchQuery.value = it },
                    placeholder = { Text("Search...", color = Color.Black, fontSize = 2.sp) },
                    modifier = Modifier
                        .width(250.dp)
                        .height(25.dp)
                        .clip(
                            shape = RoundedCornerShape(20.dp)
                        ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.Gray,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

        }
    }
}

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            //.padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .offset(y = (-55).dp)
                .fillMaxWidth()
                .requiredHeight(85.dp)
                .clip(shape = RoundedCornerShape(35.dp))
                .background(color = Color.White)
                .padding(horizontal = 16.dp) // Tambahkan padding internal jika perlu
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp) // Tambahkan padding internal agar teks tidak terlalu dekat
            ) {
                Text(
                    text = "Panduan Untuk Kamu di Mentawai",
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Berkemas dan jelajahi Kepulauan Mentawai, sekarang!",
                    style = TextStyle(fontSize = 14.sp, color = Color.Gray)
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuideDetailScreen(
    artikelId: Int?,
    navController: NavController
) {
    val context = LocalContext.current
    val detailartikel = articles.filter { artikel ->
        artikel.id == artikelId
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painter = painterResource(id = detailartikel[0].imageRes),
                contentDescription = "Article Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            // Overlay untuk teks di atas gambar
            Column {
                Column (
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .padding(0.dp)
                ){
                    TopAppBar(
                        title = { Text(text = " ") },
                        navigationIcon = {
                            IconButton(onClick = { navController.navigateUp()}) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Back",
                                    tint = Color.White
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.Transparent,
                            titleContentColor = Color.White,
                            navigationIconContentColor = Color.White
                        ),
                    )

                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f)),
//                            .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = detailartikel[0].title,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

            }
        }

        // Konten Artikel
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,

                ) {
                Text(
                    text = "By ${detailartikel[0].author}",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.DarkGray,
                )
                Box(
                    modifier = Modifier
                        .requiredWidth(110.dp)
                        .requiredHeight(20.dp)
                        .clip(shape = RoundedCornerShape(5.dp))
                        .background(Color(0xFF00897B))
                ){
                    Row(

                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(0.dp)
                            .clickable { shareItem(context) }
                    ) {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(15.dp)
                            )}
                        Text(
                            text = "Share",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.White,
                        )
                    }

                }
            }
            Text(
                text = detailartikel[0].content,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}


@Composable
fun FilterBar(selectedFilter: MutableState<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = -45.dp),
            //.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        FilterButton("Populer", selectedFilter)
        FilterButton("Budaya Lokal", selectedFilter)
        FilterButton("Makanan Khas", selectedFilter)
    }
}

@Composable
fun FilterButton(label: String, selectedFilter: MutableState<String>) {
    Button(
        onClick = { selectedFilter.value = label },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selectedFilter.value == label) Color(0xFF007BFF) else Color.Gray
        ),
        shape = RoundedCornerShape(50)
    ) {
        Text(
            text = label,
            color = Color.White,
            style = TextStyle(fontSize = 14.sp)
        )
    }
}

@Composable
fun ContentSection(selectedFilter: String) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        when (selectedFilter) {
            "Populer" -> {
                DestinationSection(popularDestinations)
            }

            "Budaya Lokal" -> {
                DestinationSection(localCultureDestinations)
            }

            "Makanan Khas" -> {
                DestinationSection(foodDestinations)
            }
        }

        //Spacer(modifier = Modifier.height(16.dp))
        UpdateSection()
    }
}

@Composable
fun DestinationSection(destinations: List<TravelGuide>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = -45.dp)
    ) {
        items(destinations) { destination ->
            DestinationCard(destination.title, destination.imageRes)
        }
    }
}

@Composable
fun DestinationCard(title: String, imageRes: Int) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(160.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .width(120.dp)
                    .height(140.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = title,
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
            )
        }
    }
}

@Composable
fun UpdateSection() {
    Text(
        text = "Informasi Update Mentawai",
        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier
            .padding(bottom = 8.dp)
            .offset(y = -35.dp)
    )
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
            .offset(y = -35.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(updateList) { update ->
            UpdateCard(update)
        }
    }
}

@Composable
fun UpdateCard(update: UpdateInfo) {
    Card(
        modifier = Modifier
            .width(250.dp)
            .fillMaxHeight()
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column {
            Image(
                painter = painterResource(id = update.imageRes),
                contentDescription = update.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = update.title,
                modifier = Modifier.padding(horizontal = 8.dp),
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
            )
            Text(
                text = update.description,
                modifier = Modifier.padding(horizontal = 8.dp),
                style = TextStyle(fontSize = 12.sp, color = Color.Gray)
            )
        }
    }
}

data class UpdateInfo(val title: String, val description: String, val imageRes: Int)

val updateList = listOf(
    UpdateInfo(
        title = "Jalan-Jalan Asyik ke Mentawai, 5 Destinasi Seru yang Wajib Kamu Kunjungi!",
        description = "Suka Traveller",
        imageRes = R.drawable.awera_island_beach
    ),
    UpdateInfo(
        title = "Surganya Diving ada di sini! Simak pengalaman wisatawan yang menarik",
        description = "Lokalin aja",
        imageRes = R.drawable.pulau_sikakap
    )
)

data class TravelGuide(val title: String, val imageRes: Int)

val popularDestinations = listOf(
    TravelGuide("Mentawai Island", R.drawable.mentawai_island),
    TravelGuide("Awera Beach", R.drawable.awera_beach),
    TravelGuide("Sipora Island", R.drawable.sipora_island),
    TravelGuide("Mentawai Island", R.drawable.mentawai_island),
    TravelGuide("Awera Beach", R.drawable.awera_beach),
    TravelGuide("Sipora Island", R.drawable.sipora_island)
)

val localCultureDestinations = listOf(
    TravelGuide("Tato Mentawai", R.drawable.tato_mentawai),
    TravelGuide("Kearifan Lokal", R.drawable.kearifan_lokal),
    TravelGuide("Tradisi Mentawai", R.drawable.tradisi_mentawai),
    TravelGuide("Tato Mentawai", R.drawable.tato_mentawai),
    TravelGuide("Kearifan Lokal", R.drawable.kearifan_lokal),
    TravelGuide("Tradisi Mentawai", R.drawable.tradisi_mentawai)
)

val foodDestinations = listOf(
    TravelGuide("Anggau", R.drawable.anggau),
    TravelGuide("Kapuru Sagu", R.drawable.kapuru_sagu),
    TravelGuide("Subbet", R.drawable.subbet),
    TravelGuide("Anggau", R.drawable.anggau),
    TravelGuide("Kapuru Sagu", R.drawable.kapuru_sagu),
    TravelGuide("Subbet", R.drawable.subbet)
)

//@Preview(showBackground = true)
//@Composable
//fun DesPreview() {
//    TajaMentawaiTheme {
//        TravelGuideScreen()
//    }
//}