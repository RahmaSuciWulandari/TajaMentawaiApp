package com.uci.tajamentawai.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.navigation.Screen

data class Destination(
    val price: Double,
    val title: String,
    val subtitle: String,
    val rating: Double,
    val imageRes: Int,
    val id: Int,
    val place: String,
    val detail: String
)

val categories = mapOf(
    "hits" to listOf(1, 2, 3, 4, 5 , 6, 7, 8),
    "populer" to listOf(1, 4, 5, 2),
    "terbaru" to listOf(6, 2, 7, 8),
    "terkini" to listOf(6, 7, 4, 3,),
    "viral" to listOf(2, 3, 8, 2)
)

//val destinasi1 = listOf(
//    Destination(50000.00,"Pulau Sipora", "Detail", 4.8, R.drawable.sipora, 1  ,"Sipora, Mentawai", "Pulau ini merupakan salah satu pulau utama di Kepulauan Mentawai dan menjadi pusat aktivitas pariwisata. Pantai-pantainya indah dan pemandangan alam yang menakjubkan.\n" +
//            "\n" +
//            "Beberapa spot ombak terbaik di dunia seperti Tua Pejat, Pitstop, dan Telescopes bisa kamu temukan di Pulau Sipora.\n\n"),
//    Destination(50000.00,"Taman Nasional Siberut", "Detail", 4.8, R.drawable.bedf6ec0c851,2, "Siberut, Mentawai", "Taman Nasional Siberut merupakan salah satu taman nasional yang berada di Sumatera. Sebagai salah satu cagar biosfer yang ada di Indonesia, kondisi alam kawasan ini masih sangat alami dan asri sehingga berbagai jenis flora dan fauna membentuk habitat di taman nasional ini. Hal tersebut juga menjadikan berbagai titik di taman nasional ini sebagai objek wisata yang sangat menarik.\n\n" +
//            "Berbagai kegiatan dapat dilakukan di Taman Nasional Siberut mulai dari yang sederhana sampai dengan yang menguji adrenalin. Untuk memenuhi hal tersebut pengunjung dapat mengunjungi beberapa spot wisata di kawasan ini. Salah satu kegiatan paling menyenangkan di Taman Nasional Siberut adalah trecking. Selain itu, Wisata budaya selalu memiliki tempat tersendiri di hati para penikmat keragaman di Indonesia, termasuk bagi pengunjung Taman Nasional Siberut. Di sekitar kawasan ini terdapat budaya khas warga setempat yang unik, seperti membuat tato dan membuat kabit yang merupakan celana tradisional masyarakat Mentawai.\n\n" +
//            "Pada waktu tertentu juga diadakan upacara adat dengan menampilkan tarian khas Mentawai yang disebut turuk. Ada juga prosesi pengobatan yang dilakukan oleh sikerei yang merupakan dukun Mentawai.\n\n"),
//    Destination(50000.00,"Danau Rua Oinan", "Detail", 4.9, R.drawable.danauruaoinan31, 3, "Dusun Saumanganyak, Kepulauan Mentawai", "Danau ini berlokasi di Dusun Saumanganyak, Kepulauan Mentawai. Danau ini cukup unik, bentuknya seperti muara yang dikelilingi oleh hutan dengan pohon-pohon besar.\n\n"),
//    Destination(50000.00,"Air Terjun Bat Soumang", "Detail", 4.8, R.drawable.image16,4, "Siberut, Mentawai", "Air terjun ini memiliki aliran yang sangat deras dan berbahaya. Namun, daya tariknya selalu menarik perhatian penggemar petualangan. Kamu bisa menikmati percikan airnya yang sejuk.\n" +
//            "\n" +
//            "Air terjunnya sendiri dikelilingi hutan rotan dan kayu besar. Aliran derasnya pun digunakan untuk arung jeram di Dusun Bulasat. \n\n"),
//    Destination(50000.00,"Pantai Awera", "Detail", 4.8, R.drawable.pantaiawera2,5, "pulau awera", "Pulau Awera berlokasi berdekatan dengan Pulau Sipora. Ketika mengunjunginya, kamu akan takjub dengan air yang begitu jernih, cocok untuk snorkeling dan mendapat pengalaman tak terlupakan.\n" +
//            "\n" +
//            "Kamu pun akan melihat pemandangan hamparan hutan bakau yang sangat luas. Kamu juga bisa berjalan-jalan di tepi pantai dan bermain air di lautnya yang tenang.\n\n"),
//    Destination(50000.00,"Kulukkubuk Waterfall", "Detail", 4.8, R.drawable.kulukubukterjun,6, "Mandobag, Sabulau", "Air Terjun Kulukubuk, sebuah hidden gem yang terletak di Kawasan Siberut Selatan, khususnya Desa Madobag, Kepulauan Mentawai. Tempat ini menawarkan keindahan alam yang masih asri dan pengalaman yang tak terlupakan bagi para petualang dan pencinta alam\n" +
//            "\n" +
//            "Air Terjun Kulukubuk terletak di tengah hutan tropis yang lebat, memberikan suasana sejuk dan menenangkan. Air terjun bertingkat ini memiliki ketinggian sekitar 70 meter dengan aliran air yang jernih dan segar.\n" +
//            "\n" +
//            "Berenang di kolam alami di bawah air terjun adalah salah satu kegiatan favorit yang bisa memberikan kesegaran dan relaksasi. Bagi yang suka petualangan, trekking menyusuri hutan menuju air terjun ini juga merupakan pengalaman yang seru dan menantang.\n" +
//            "\n" ),
//    Destination(50000.00,"Desa Wisata Muntai", "Detail", 4.8, R.drawable.image,7, "Siberut, Mentawai", "Desa Muntei berada di tengah-tengah desa lainnya di Kecamatan Siberut dengan suasana lingkungan yang masih asri dan kental dengan adat Mentawai.\n" +
//            "\n" +
//            "Di Desa Muntei terdapat dua sanggar tradisional berupa uma (rumah tradisional Mentawai) yang menjadi salah satu pemikat wisata.\n" +
//            "Daya tarik Desa Muntei selanjutnya yaitu masih adanya Sikerei atau tabib yang mengobati warga yang sakit dengan adat dan keyakinan suku Mentawai.\n" +
//            "\n" +
//            "Atraksi wisata lainnya dari Desa Wisata Muntei adalah pengelolaan sagu, pembuatan karbit (cawat tradisional Mentawai), hingga pembuatan tato tradisional Mentawai yang sangat ikonik.\n\n"),
//    Destination(50000.00,"Pantai Jati", "Detail", 4.8, R.drawable.pantaijati2,8, "Dusun Jati, Mentawai", "Pantai Jati di Kepulauan Mentawai, Sumatera Barat, adalah salah satu destinasi eksotis yang menawarkan keindahan alam bawah laut dan suasana tenang. Dengan ombaknya yang lembut dan pemandangan tropis yang menawan, Pantai Jati menjadi tempat yang ideal bagi wisatawan yang ingin menyepi dan menikmati keindahan laut.\n\n")
//)

@Suppress("DEPRECATION")
@Composable
fun DestinationScreen(navController: NavController) {
    val searchQuery = remember { mutableStateOf("") }
    val selectedFilter = remember { mutableStateOf("Hits") }

    val filteredDestinations = destinasi.filter {
        it.title.contains(searchQuery.value, ignoreCase = true) ||
                it.place.contains(searchQuery.value, ignoreCase = true)
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back", tint = Color.Black,
                modifier = Modifier.clickable { navController.navigateUp() }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Search Bar

        TextField(
            value = searchQuery.value, onValueChange = { searchQuery.value = it },
            placeholder = { Text("Search...", color = Color.Gray) }, modifier = Modifier
                .fillMaxWidth()
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    )
                ),
//            colors = TextFieldDefaults.textFieldColors(
//                containerColor = Color(0xFFF2F2F2),
//                unfocusedIndicatorColor = Color.Transparent,
//                focusedIndicatorColor = Color.Transparent
//            )
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Gray
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

            FilteredBar(selectedFilter = selectedFilter)
            contentSection(selectedFilter = selectedFilter.value, searchQuery = searchQuery.value, navController = navController)

            Spacer(modifier = Modifier.height(16.dp))

//            LazyVerticalGrid(
//                columns = GridCells.Fixed(2),
//                verticalArrangement = Arrangement.spacedBy(8.dp),
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .padding(4.dp)
//            ) {
//                items(filteredDestinations) { destination ->
//                    DestinationCard2(destination){
//                        navController.navigate(Screen.DetailDestination.route + "/${destination.id}")
//                    }
//                }
//            }


}}
@Composable
fun DestinationCard2(destination: Destination,  onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2 / 2f)
            .padding(4.dp)
            .clickable { onClick( ) },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
               // .padding(2.dp)
        ) {
            Image(
                painter = painterResource(id = destination.imageRes),
                contentDescription = destination.title, modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                 //   .aspectRatio(16 / 9f) // Control the aspect ratio of the image within the card
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(destination.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(1.dp))
            Text(destination.subtitle, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.offset(x = 150.dp, y = -6.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating", tint = Color(0xFFFFD700),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
               Text(destination.rating.toString(), fontSize = 12.sp, color = Color.Gray)

            }
        }
    }
}


@Composable
fun FilteredBar(selectedFilter: MutableState<String>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
          //  .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(listOf("Hits", "Populer", "Terbaru", "Terkini", "Viral")) { filter ->
            FilteredButton(label = filter, selectedFilter = selectedFilter)
        }
    }
}

@Composable
fun FilteredButton(label: String, selectedFilter: MutableState<String>) {
    Button(
        onClick = { selectedFilter.value = label },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selectedFilter.value == label) Color(0xFF007BFF) else Color.Gray
        ),
        shape = RoundedCornerShape(50),
        modifier = Modifier.padding(2.dp)
    ) {
        Text(
            text = label,
            color = Color.White,
            style = TextStyle(fontSize = 14.sp)
        )
    }
}

//@Composable
//fun contentSection(selectedFilter: String,searchQuery: String, navController: NavController) {
//    val allDestinations = when (selectedFilter) {
//        "Hits" -> hitsDestinations
//        "Populer" -> popularrDestinations
//        "Terbaru" -> latestDestinations
//        "Terkini" -> currentDestinations
//        "Viral" -> viralDestinations
//        else -> emptyList()
//    }
//
//    val filteredDestinations = allDestinations.filter {
//        it.title.contains(searchQuery, ignoreCase = true) ||
//                it.place.contains(searchQuery, ignoreCase = true)
//    }
//
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//        horizontalArrangement = Arrangement.spacedBy(8.dp),
//        modifier = Modifier
//            .fillMaxHeight()
//            .padding(4.dp)
//    ) {
//        items(filteredDestinations) { destination ->
//            DestinationCard2(destination) {
//                navController.navigate(Screen.DetailDestination.route + "/${destination.id}")
//            }
//        }
//    }
//}

@Composable
fun contentSection(
    selectedFilter: String,
    searchQuery: String,
    navController: NavController
) {
    val categoryIds = categories[selectedFilter.lowercase()] ?: emptyList()
    val filteredDestinations = destinasi.filter { destination ->
        destination.id in categoryIds &&
                (destination.title.contains(searchQuery, ignoreCase = true) ||
                        destination.place.contains(searchQuery, ignoreCase = true))
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxHeight()
            .padding(4.dp)
    ) {
        items(filteredDestinations) { destination ->
            DestinationCard2(destination) {
                navController.navigate(Screen.DetailDestination.route + "/${destination.id}")
            }
        }
    }
}


@Composable
fun DestinasiSection(destinations: List<Destination>, navController: NavController) {
    val searchQuery = remember { mutableStateOf("") }
    val filteredDestinations = destinations.filter {
        it.title.contains(searchQuery.value, ignoreCase = true) ||
                it.place.contains(searchQuery.value, ignoreCase = true)
    }
    LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(4.dp)
            ) {
                items(filteredDestinations) { destination ->
                    DestinationCard2(destination){
                        navController.navigate(Screen.DetailDestination.route + "/${destination.id}")
                    }
                }
            }
}


