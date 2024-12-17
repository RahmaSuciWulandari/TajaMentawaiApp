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
import com.uci.tajamentawai.navigation.Screen

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
                ContentSection(selectedFilter.value, navController = navController)}

        }
    }
}

@Composable
fun CoverImageWithSearchBar() {
    Box(
        modifier = Modifier
            .width(500.dp)
            .height(300.dp)
            .offset(y = 50.dp)
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
                .requiredHeight(150.dp)
                .clip(shape = RoundedCornerShape(35.dp))
                .background(color = Color.White)
                .padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
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


@Composable
fun FilterBar(selectedFilter: MutableState<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = -110.dp),
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
fun ContentSection(selectedFilter: String, navController: NavController) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        when (selectedFilter) {
            "Populer" -> {
                DestinationSection( popularDestinations, navController = navController)
            }

            "Budaya Lokal" -> {
                DestinationSection(localCultureDestinations, navController = navController)
            }

            "Makanan Khas" -> {
                DestinationSection(foodDestinations, navController = navController)
            }
        }

        //Spacer(modifier = Modifier.height(16.dp))
        UpdateSection()
    }
}

@Composable
fun DestinationSection(destinations: List<TravelGuide>, navController: NavController) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = -110.dp)
    ) {
        items(destinations) { guide ->
            TravelguideCard(guide) {
                navController.navigate(Screen.PilihTravelGuide.route + "/${guide.id}")
            }
        }
    }
}

@Composable
fun TravelguideCard(guide: TravelGuide, onClick: () -> Unit) {
    Box(modifier = Modifier
            .width(120.dp)
        .height(160.dp)
        .clickable { onClick() }
        .clip(RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = guide.imageRes),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(8.dp))
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f))
        ) {
            Text(
                text = guide.title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.BottomStart).padding(8.dp)
            )
        }
    }
}


@Composable
fun UpdateSection() {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Informasi Update Mentawai",
        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier
            .padding(bottom = 8.dp)
            .offset(y = -80.dp)
    )
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
            .offset(y = -80.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(updateList) { update ->
            UpdateCard(update)
        }
    }
}

@Composable
fun UpdateCard(update: UpdateInfo) {
    Box(modifier = Modifier
        .width(250.dp)
        .height(200.dp)
        .clip(RoundedCornerShape(8.dp))
       // .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = update.imageRes),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(8.dp))
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f))
        ) {
            Text(
                text = update.title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.BottomStart)
                    .padding(8.dp)
                    .padding(bottom = 14.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = update.description,
                color = Color.White,
                modifier = Modifier.align(Alignment.BottomStart).padding(8.dp)
            )
        }
    }
}

data class UpdateInfo(val id:Int, val title: String, val description: String, val imageRes: Int, val Info:String)

val updateList = listOf(
    UpdateInfo(
        id = 1,
        title = "Jalan-Jalan Asyik ke Mentawai, 5 Destinasi Seru yang Wajib Kamu Kunjungi!",
        description = "Suka Traveller",
        imageRes = R.drawable.awera_island_beach,
        ""
    ),
    UpdateInfo(
        1,
        title = "Surganya Diving ada di sini! Simak pengalaman wisatawan yang menarik",
        description = "Lokalin aja",
        imageRes = R.drawable.pulau_sikakap,
        ""
    ),
            UpdateInfo(
                id = 3,
                title = "Jalan-Jalan Asyik ke Mentawai, 5 Destinasi Seru yang Wajib Kamu Kunjungi!",
                description = "Suka Traveller",
                imageRes = R.drawable.awera_island_beach,
                ""
            ),
    UpdateInfo(
        4,
        title = "Surganya Diving ada di sini! Simak pengalaman wisatawan yang menarik",
        description = "Lokalin aja",
        imageRes = R.drawable.pulau_sikakap,
        ""
    )
)

data class TravelGuide(val id:Int, val title: String, val imageRes: Int, val deskrip: String)

val popularDestinations = listOf(
    TravelGuide(1,"Mentawai Island", R.drawable.mentawai_island,"Kepulauan Mentawai yang indah adalah kepulauan kecil yang terletak di lepas pantai barat Sumatera di Indonesia. Mereka terkenal dengan kondisi selancarnya, menjadi salah satu dari 10 tempat selancar terbaik di Indonesia. Bahkan menyaingi yang ditemukan di surga peselancar Bali.\n" +
            "\n" +
            "Dengan demikian, banyak peselancar yang datang ke Kepulauan Mentawai setelah musim selancar di Bali selesai. Tapi berselancar bukan satu-satunya aktivitas yang ditawarkan di sini. Banyak pulau menyediakan kesempatan trekking, memancing, dan snorkeling yang menyenangkan. Jika tidak ada yang menarik, Anda dapat bersantai di pantai atau mempelajari lebih lanjut tentang budaya Mentawai.\n" +
            "\n" +
            "Ombak, laut biru kehijauan, pemandangan bawah laut yang luar biasa, resor terbaik, lokasi yang tenang dan tenang, hutan perawan, mencicipi makanan yang berbeda setiap hari, hewan endemik, tato, dan berpetualang dengan tinggal dan hidup seperti Suku Asli Mentawai akan membuat Anda siap untuk liburan yang tak terlupakan."),
    TravelGuide(2,"Awera Beach", R.drawable.awera_beach,"Kepulauan Mentawai terletak di pesisir barat Sumatera, Indonesia, merupakan destinasi wisata yang menawarkan pantai-pantai indah, hutan hijau, dan budaya yang kaya. Terdiri dari sekitar tujuh pulau-pulau, gugusan kepulauan ini menawarkan kombinasi keindahan alam dan keunikan budaya suku Mentawai yang masih menjaga tradisi mereka hingga saat ini. Ini adalah tujuan yang sempurna untuk petualang, peselancar, dan pencinta budaya."),
    TravelGuide(3,"Sipora Island", R.drawable.sipora_island, "Kepulauan Mentawai terletak di pesisir barat Sumatera, Indonesia, merupakan destinasi wisata yang menawarkan pantai-pantai indah, hutan hijau, dan budaya yang kaya. Terdiri dari sekitar tujuh pulau-pulau, gugusan kepulauan ini menawarkan kombinasi keindahan alam dan keunikan budaya suku Mentawai yang masih menjaga tradisi mereka hingga saat ini. Ini adalah tujuan yang sempurna untuk petualang, peselancar, dan pencinta budaya."),
    TravelGuide(4,"Mentawai Island", R.drawable.mentawai_island,"Kepulauan Mentawai terletak di pesisir barat Sumatera, Indonesia, merupakan destinasi wisata yang menawarkan pantai-pantai indah, hutan hijau, dan budaya yang kaya. Terdiri dari sekitar tujuh pulau-pulau, gugusan kepulauan ini menawarkan kombinasi keindahan alam dan keunikan budaya suku Mentawai yang masih menjaga tradisi mereka hingga saat ini. Ini adalah tujuan yang sempurna untuk petualang, peselancar, dan pencinta budaya."),
    TravelGuide(5,"Awera Beach", R.drawable.awera_beach,"Kepulauan Mentawai terletak di pesisir barat Sumatera, Indonesia, merupakan destinasi wisata yang menawarkan pantai-pantai indah, hutan hijau, dan budaya yang kaya. Terdiri dari sekitar tujuh pulau-pulau, gugusan kepulauan ini menawarkan kombinasi keindahan alam dan keunikan budaya suku Mentawai yang masih menjaga tradisi mereka hingga saat ini. Ini adalah tujuan yang sempurna untuk petualang, peselancar, dan pencinta budaya."),
    TravelGuide(6,"Sipora Island", R.drawable.sipora_island,"Kepulauan Mentawai terletak di pesisir barat Sumatera, Indonesia, merupakan destinasi wisata yang menawarkan pantai-pantai indah, hutan hijau, dan budaya yang kaya. Terdiri dari sekitar tujuh pulau-pulau, gugusan kepulauan ini menawarkan kombinasi keindahan alam dan keunikan budaya suku Mentawai yang masih menjaga tradisi mereka hingga saat ini. Ini adalah tujuan yang sempurna untuk petualang, peselancar, dan pencinta budaya.")
)

val localCultureDestinations = listOf(
    TravelGuide(7,"Tato Mentawai", R.drawable.tato_mentawai,""),
    TravelGuide(8,"Kearifan Lokal", R.drawable.kearifan_lokal,""),
    TravelGuide(9,"Tradisi Mentawai", R.drawable.tradisi_mentawai,""),
    TravelGuide(10,"Tato Mentawai", R.drawable.tato_mentawai,""),
    TravelGuide(11,"Kearifan Lokal", R.drawable.kearifan_lokal,""),
    TravelGuide(12,"Tradisi Mentawai", R.drawable.tradisi_mentawai,"")
)

val foodDestinations = listOf(
    TravelGuide(13,"Anggau", R.drawable.anggau, ""),
    TravelGuide(14,"Kapuru Sagu", R.drawable.kapuru_sagu,""),
    TravelGuide(15,"Subbet", R.drawable.subbet,""),
    TravelGuide(16,"Anggau", R.drawable.anggau,""),
    TravelGuide(17,"Kapuru Sagu", R.drawable.kapuru_sagu,""),
    TravelGuide(18,"Subbet", R.drawable.subbet,"")
)

//@Preview(showBackground = true)
//@Composable
//fun DesPreview() {
//    TajaMentawaiTheme {
//        TravelGuideScreen()
//    }
//}