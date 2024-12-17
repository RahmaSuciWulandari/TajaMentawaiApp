package com.uci.tajamentawai.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.R
import com.uci.tajamentawai.navigation.Screen
import java.text.NumberFormat
import java.util.Locale

fun formatRupiah(amount: Double): String {
    val localeID = Locale("in", "ID")
    val formatter = NumberFormat.getCurrencyInstance(localeID)
    return formatter.format(amount).replace("Rp", "Rp.").replace(",00", ",00")
}

val destinasi = listOf(
    Destination(50000.00,"Pulau Sipora", "Detail", 4.8, R.drawable.sipora, 1  ,"Sipora, Mentawai", "Pulau ini merupakan salah satu pulau utama di Kepulauan Mentawai dan menjadi pusat aktivitas pariwisata. Pantai-pantainya indah dan pemandangan alam yang menakjubkan.\n" +
            "\n" +
            "Beberapa spot ombak terbaik di dunia seperti Tua Pejat, Pitstop, dan Telescopes bisa kamu temukan di Pulau Sipora.\n\n"),
    Destination(50000.00,"Taman Nasional Siberut", "Detail", 4.8, R.drawable.bedf6ec0c851,2, "Siberut, Mentawai", "Taman Nasional Siberut merupakan salah satu taman nasional yang berada di Sumatera. Sebagai salah satu cagar biosfer yang ada di Indonesia, kondisi alam kawasan ini masih sangat alami dan asri sehingga berbagai jenis flora dan fauna membentuk habitat di taman nasional ini. Hal tersebut juga menjadikan berbagai titik di taman nasional ini sebagai objek wisata yang sangat menarik.\n\n" +
            "Berbagai kegiatan dapat dilakukan di Taman Nasional Siberut mulai dari yang sederhana sampai dengan yang menguji adrenalin. Untuk memenuhi hal tersebut pengunjung dapat mengunjungi beberapa spot wisata di kawasan ini. Salah satu kegiatan paling menyenangkan di Taman Nasional Siberut adalah trecking. Selain itu, Wisata budaya selalu memiliki tempat tersendiri di hati para penikmat keragaman di Indonesia, termasuk bagi pengunjung Taman Nasional Siberut. Di sekitar kawasan ini terdapat budaya khas warga setempat yang unik, seperti membuat tato dan membuat kabit yang merupakan celana tradisional masyarakat Mentawai.\n\n" +
            "Pada waktu tertentu juga diadakan upacara adat dengan menampilkan tarian khas Mentawai yang disebut turuk. Ada juga prosesi pengobatan yang dilakukan oleh sikerei yang merupakan dukun Mentawai.\n\n"),
    Destination(50000.00,"Danau Rua Oinan", "Detail", 4.9, R.drawable.danauruaoinan31, 3, "Dusun Saumanganyak, Kepulauan Mentawai", "Danau ini berlokasi di Dusun Saumanganyak, Kepulauan Mentawai. Danau ini cukup unik, bentuknya seperti muara yang dikelilingi oleh hutan dengan pohon-pohon besar.\n\n"),
    Destination(50000.00,"Air Terjun Bat Soumang", "Detail", 4.8, R.drawable.image16,4, "Siberut, Mentawai", "Air terjun ini memiliki aliran yang sangat deras dan berbahaya. Namun, daya tariknya selalu menarik perhatian penggemar petualangan. Kamu bisa menikmati percikan airnya yang sejuk.\n" +
            "\n" +
            "Air terjunnya sendiri dikelilingi hutan rotan dan kayu besar. Aliran derasnya pun digunakan untuk arung jeram di Dusun Bulasat. \n\n"),
    Destination(50000.00,"Pantai Awera", "Detail", 4.8, R.drawable.pantaiawera2,5, "pulau awera", "Pulau Awera berlokasi berdekatan dengan Pulau Sipora. Ketika mengunjunginya, kamu akan takjub dengan air yang begitu jernih, cocok untuk snorkeling dan mendapat pengalaman tak terlupakan.\n" +
            "\n" +
            "Kamu pun akan melihat pemandangan hamparan hutan bakau yang sangat luas. Kamu juga bisa berjalan-jalan di tepi pantai dan bermain air di lautnya yang tenang.\n\n"),
    Destination(50000.00,"Kulukkubuk Waterfall", "Detail", 4.8, R.drawable.kulukubukterjun,6, "Mandobag, Sabulau", "Air Terjun Kulukubuk, sebuah hidden gem yang terletak di Kawasan Siberut Selatan, khususnya Desa Madobag, Kepulauan Mentawai. Tempat ini menawarkan keindahan alam yang masih asri dan pengalaman yang tak terlupakan bagi para petualang dan pencinta alam\n" +
            "\n" +
            "Air Terjun Kulukubuk terletak di tengah hutan tropis yang lebat, memberikan suasana sejuk dan menenangkan. Air terjun bertingkat ini memiliki ketinggian sekitar 70 meter dengan aliran air yang jernih dan segar.\n" +
            "\n" +
            "Berenang di kolam alami di bawah air terjun adalah salah satu kegiatan favorit yang bisa memberikan kesegaran dan relaksasi. Bagi yang suka petualangan, trekking menyusuri hutan menuju air terjun ini juga merupakan pengalaman yang seru dan menantang.\n" +
            "\n" ),
    Destination(50000.00,"Desa Wisata Muntai", "Detail", 4.8, R.drawable.image,7, "Siberut, Mentawai", "Desa Muntei berada di tengah-tengah desa lainnya di Kecamatan Siberut dengan suasana lingkungan yang masih asri dan kental dengan adat Mentawai.\n" +
            "\n" +
            "Di Desa Muntei terdapat dua sanggar tradisional berupa uma (rumah tradisional Mentawai) yang menjadi salah satu pemikat wisata.\n" +
            "Daya tarik Desa Muntei selanjutnya yaitu masih adanya Sikerei atau tabib yang mengobati warga yang sakit dengan adat dan keyakinan suku Mentawai.\n" +
            "\n" +
            "Atraksi wisata lainnya dari Desa Wisata Muntei adalah pengelolaan sagu, pembuatan karbit (cawat tradisional Mentawai), hingga pembuatan tato tradisional Mentawai yang sangat ikonik.\n\n"),
    Destination(50000.00,"Pantai Jati", "Detail", 4.8, R.drawable.pantaijati2,8, "Dusun Jati, Mentawai", "Pantai Jati di Kepulauan Mentawai, Sumatera Barat, adalah salah satu destinasi eksotis yang menawarkan keindahan alam bawah laut dan suasana tenang. Dengan ombaknya yang lembut dan pemandangan tropis yang menawan, Pantai Jati menjadi tempat yang ideal bagi wisatawan yang ingin menyepi dan menikmati keindahan laut.\n\n")
)

@Composable
fun HomeScreen(navController: NavController) {
    val searchQuery = remember { mutableStateOf("") }
    val filteredDestinations = destinasi.filter {
        it.title.contains(searchQuery.value, ignoreCase = true) ||
                it.place.contains(searchQuery.value, ignoreCase = true)
    }
Column (
    modifier = Modifier.fillMaxSize()
){
    TopSection(
        searchQuery.value ,
        onsearchQueryChange ={
            searchQuery.value=it
        },
        navController)
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {


        // InfoRow
        item(span = { GridItemSpan(2) }) {
            InfoRow()
        }

        // PosterSection
        item(span = { GridItemSpan(2) }) {
            PosterSection()
        }

        // FeatureIcons
        item(span = { GridItemSpan(2) }) {
            FeatureIcons(navController = navController)
        }

        items(filteredDestinations) { destination ->
            DestinationCard2(destination){
                navController.navigate(Screen.DetailDestination.route + "/${destination.id}")
            }
        }
    }
}

        }






@Composable
fun TopSection(
    searchQuery: String,
    onsearchQueryChange: (String) -> Unit,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = searchQuery, onValueChange = onsearchQueryChange,
            placeholder = { Text("Search...", color = Color.Gray) },
            modifier = Modifier
                .requiredWidth(320.dp)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    )
                ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Gray
                )
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.chat),
            contentDescription = "Chat",
            colorFilter = ColorFilter.tint(Color(0xff084360)),
            modifier = Modifier.size(42.dp)
                .clickable { navController.navigate(Screen.ListChat.route) }
        )
    }
}

@Composable
fun PosterSection() {
    Image(
        painter = painterResource(id = R.drawable.postertajamentawai),
        contentDescription = "Poster TajaMentawai",
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp)
    )
}

@Composable
fun FeatureIcons(navController:NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        FeatureIcon(
            iconRes = R.drawable.hugeicons_maps,
            label = "Destination",
            onClick = { navController.navigate(Screen.Destination.route) }
        )
        FeatureIcon(
            iconRes = R.drawable.tdesign_explore,
            label = "Travel Guide",
            onClick = { navController.navigate(Screen.TravelGuide.route) }
        )
        FeatureIcon(
            iconRes = R.drawable.gameiconsbinoculars,
            label = "Community",
            onClick = { navController.navigate(Screen.Community.route) }
        )
    }
}


@Composable
fun FeatureIcon(iconRes: Int, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(80.dp)
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .size(57.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFF084360))
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                modifier = Modifier
                    .size(36.dp)
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            fontSize = 10.sp,
            textAlign = TextAlign.Center
        )
    }
}





//@Composable
//fun DestinationGrid(
//    destinations: List<Destination>,
//    onItemClick: (Destination) -> Unit
//) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(400.dp) // Berikan ukuran eksplisit jika diperlukan
//    ) {
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
//            contentPadding = PaddingValues(8.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp),
//            horizontalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            items(destinations.size) { index ->
//                DestinationCard(
//                    destination = destinations[index],
//                    onClick = { onItemClick(destinations[index]) }
//                )
//            }
//        }
//    }
//}




@Composable
fun DestinationCard(destination: Destination, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2 / 3f)
            .padding(4.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = destination.imageRes),
                contentDescription = destination.title, modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(destination.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(destination.subtitle, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
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
fun TextFieldSearchDisable(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color(0xfff0f1f5))
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxSize()
        ) {
            IconSearch(modifier = Modifier.padding(end = 8.dp))
            Text(
                text = "Search…",
                color = Color(0xffc8c8d3),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun IconSearch(modifier: Modifier = Modifier) {
    Icon(
        imageVector = Icons.Default.Search,
        contentDescription = "Search Icon",
        tint = Color(0xffc8c8d3),
        modifier = modifier.size(24.dp)
    )
}

@Composable
fun InfoRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
            InfoCardWithText(
                iconRes = R.drawable.tabler_badgesfilled,
                title = "Badges Priority",
                value = ""
            )
            VerticalDivider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.height(50.dp))
            InfoCardWithText(
                iconRes = R.drawable.mingcutecoin2fill,
                title = "TajaCoins",
                value = "10.000"
            )
            VerticalDivider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.height(50.dp))
            InfoCardWithText(
                iconRes = R.drawable.dompet,
                title = "TajaWallet",
                value = "Rp45.000"
            )
        }
    }


@Composable
fun InfoCardWithText(iconRes: Int, title: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                color = Color.Black,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
            if (value.isNotEmpty()) {
                Text(
                    text = value,
                    color = Color.Gray,
                    fontSize = 10.sp
                )
            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    TajaMentawaiTheme {
//        HomeScreen()
//    }
//}
