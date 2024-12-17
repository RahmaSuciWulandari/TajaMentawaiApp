package com.uci.tajamentawai.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uci.tajamentawai.R
import com.uci.tajamentawai.navigation.Screen

data class Article(
    val id: Int,
    val title: String,
    val author: String,
    val imageRes: Int,
    val content: String
)
val articles = listOf(
    Article(
        id = 1,
        title = "Menjelajahi Surga tersembunyi: Kepulauan Mentawai",
        author = "Kirana Jaya",
        content = "Jakarta (ANTARA) - Di antara riuhnya destinasi-destinasi wisata populer dan favorit seperti Bali, Daerah Istimewa Yogyakarta plus Borobudur, Pantai Senggigi, dan Danau Toba, masih ada sejumlah wisatawan mancanegara maupun wisatawan Nusantara, bahkan pesohor dunia mengunjungi destinasi wisata sunyi seperti Mentawai.\n\n" +
                "Mereka umumnya memburu keunikan, kekhasan lokal, keasrian, originalitas, otentisitas alami, serta ketenangan yang tak pernah ada di destinasi manapun.\n\n" +
                "Sebagian dari wisatawan dan pesohor bisa saja sudah jenuh dengan kemewahan yang serba artifisial dan ingin sekali-sekali back to nature untuk penyegaran.\n\n" +
                "Kendati infrastruktur konektivitas belum optimal ketersediaannya, dan dari aspek amenitas (fasilitas akomodasi dan pendukungnya) terbilang minimalis, serta posisinya pun di pojok Samudera Hindia yang sunyi, ribuan wisatawan mancanegara mendatangi Mentawai setiap tahunnya. Lantas ada apa dengan Mentawai? apa yang ditawarkan di Mentawai? Tingginya ombak yang konsisten sepanjang tahun menjadi surga bagi pada peselancar, termasuk kelas pemula.\n\n" +
                "Bukan itu saja, pantai-pantainya yang indah, bersih dan berpasir putih, serta berair jernih dihiasi ikan berwarna warni dan terumbu karang yang indah pada taman-taman lautnya menawarkan sensasi tersendiri, dipadu dengan hijaunya kawasan hutan di sekitarnya.\n" +
                "Mentawai memiliki banyak pantai cantik tersembunyi yang belum terjamah. Jumlah pulau saja sekitar 100, tetapi hanya beberapa pulau utama yang dihuni.",
        imageRes = R.drawable.pantaijati2
    ),
    Article(
        id = 2,
        title = "Jalan-Jalan Asyik ke Mentawai, 5 Destinasi Seru yang Wajib Kamu Kunjungi!",
        author = "Suka Travel",
        content = "Jakarta (ANTARA) - Di antara riuhnya destinasi-destinasi wisata populer dan favorit seperti Bali, Daerah Istimewa Yogyakarta plus Borobudur, Pantai Senggigi, dan Danau Toba, masih ada sejumlah wisatawan mancanegara maupun wisatawan Nusantara, bahkan pesohor dunia mengunjungi destinasi wisata sunyi seperti Mentawai.\n\n" +
                "Mereka umumnya memburu keunikan, kekhasan lokal, keasrian, originalitas, otentisitas alami, serta ketenangan yang tak pernah ada di destinasi manapun.\n\n" +
                "Sebagian dari wisatawan dan pesohor bisa saja sudah jenuh dengan kemewahan yang serba artifisial dan ingin sekali-sekali back to nature untuk penyegaran.\n\n" +
                "Kendati infrastruktur konektivitas belum optimal ketersediaannya, dan dari aspek amenitas (fasilitas akomodasi dan pendukungnya) terbilang minimalis, serta posisinya pun di pojok Samudera Hindia yang sunyi, ribuan wisatawan mancanegara mendatangi Mentawai setiap tahunnya. Lantas ada apa dengan Mentawai? apa yang ditawarkan di Mentawai? Tingginya ombak yang konsisten sepanjang tahun menjadi surga bagi pada peselancar, termasuk kelas pemula.\n\n" +
                "Bukan itu saja, pantai-pantainya yang indah, bersih dan berpasir putih, serta berair jernih dihiasi ikan berwarna warni dan terumbu karang yang indah pada taman-taman lautnya menawarkan sensasi tersendiri, dipadu dengan hijaunya kawasan hutan di sekitarnya.\n" +
                "Mentawai memiliki banyak pantai cantik tersembunyi yang belum terjamah. Jumlah pulau saja sekitar 100, tetapi hanya beberapa pulau utama yang dihuni.",
        imageRes = R.drawable.pantaiawera2
    ),
    Article(
        id=3,
        title = "Surganya Diving ada disini! simak pengalaman wisatawan yang menarik",
        author = "Suka Travel",
        content = "Jakarta (ANTARA) - Di antara riuhnya destinasi-destinasi wisata populer dan favorit seperti Bali, Daerah Istimewa Yogyakarta plus Borobudur, Pantai Senggigi, dan Danau Toba, masih ada sejumlah wisatawan mancanegara maupun wisatawan Nusantara, bahkan pesohor dunia mengunjungi destinasi wisata sunyi seperti Mentawai.\n\n" +
                "Mereka umumnya memburu keunikan, kekhasan lokal, keasrian, originalitas, otentisitas alami, serta ketenangan yang tak pernah ada di destinasi manapun.\n\n" +
                "Sebagian dari wisatawan dan pesohor bisa saja sudah jenuh dengan kemewahan yang serba artifisial dan ingin sekali-sekali back to nature untuk penyegaran.\n\n" +
                "Kendati infrastruktur konektivitas belum optimal ketersediaannya, dan dari aspek amenitas (fasilitas akomodasi dan pendukungnya) terbilang minimalis, serta posisinya pun di pojok Samudera Hindia yang sunyi, ribuan wisatawan mancanegara mendatangi Mentawai setiap tahunnya. Lantas ada apa dengan Mentawai? apa yang ditawarkan di Mentawai? Tingginya ombak yang konsisten sepanjang tahun menjadi surga bagi pada peselancar, termasuk kelas pemula.\n\n" +
                "Bukan itu saja, pantai-pantainya yang indah, bersih dan berpasir putih, serta berair jernih dihiasi ikan berwarna warni dan terumbu karang yang indah pada taman-taman lautnya menawarkan sensasi tersendiri, dipadu dengan hijaunya kawasan hutan di sekitarnya.\n" +
                "Mentawai memiliki banyak pantai cantik tersembunyi yang belum terjamah. Jumlah pulau saja sekitar 100, tetapi hanya beberapa pulau utama yang dihuni.",
        imageRes = R.drawable.kulukubukterjun
    ),
)

@Composable
fun ArticleScreen(
    navController: NavController
){


    Column(modifier = Modifier.fillMaxSize()
        .padding(10.dp)){
        
        Spacer(modifier = Modifier.height(16.dp))
        val searchQuery = remember { mutableStateOf("") }
        val filteredArticles = articles.filter {
            it.title.contains(searchQuery.value, ignoreCase = true) ||
                    it.author.contains(searchQuery.value, ignoreCase = true)
        }
        TextField(
            value = searchQuery.value, onValueChange = { searchQuery.value = it },
            placeholder = { Text("Search...", color = Color.Gray) },
            modifier = Modifier
                .fillMaxWidth()
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
        Spacer(modifier = Modifier.height(16.dp))
        Column (modifier = Modifier.padding(start = 10.dp)){
            Row(
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text="Articles",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = {
                    navController.navigate(Screen.Notification.route)
                }){
                    Icon(
                        painter = painterResource(id = R.drawable.alarm),
                        contentDescription = "notip",
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(filteredArticles) { article ->
                ArticleItem(article) {
                    navController.navigate(Screen.DetailArticles.route + "/${article.id}")
                }
            }
        }

    }
    }

@Composable
fun ArticleItem(articles: Article, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick( ) },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = articles.imageRes),
                contentDescription = "Article Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = articles.title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = articles.author,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(
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
                            modifier = Modifier.padding(0.dp)
                                .clickable { shareItem(context)}
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




//@Preview(showBackground = true)
//@Composable
//fun reenPreview() {
//    TajaMentawaiTheme {
//        val navController = rememberNavController()
//        ArticleScreen(navController)
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun ArticleDetailScreenPreview() {
//    ArticleDetailScreen(
//        title = "Menjelajahi Surga tersembunyi: Kepulauan Mentawai",
//        author = "Kirana Jaya",
//        content = "Jakarta (ANTARA) - Di antara riuhnya destinasi-destinasi wisata populer dan favorit seperti Bali, Daerah Istimewa Yogyakarta plus Borobudur, Pantai Senggigi, dan Danau Toba, masih ada sejumlah wisatawan mancanegara maupun wisatawan Nusantara, bahkan pesohor dunia mengunjungi destinasi wisata sunyi seperti Mentawai.\n\n" +
//                "Mereka umumnya memburu keunikan, kekhasan lokal, keasrian, originalitas, otentisitas alami, serta ketenangan yang tak pernah ada di destinasi manapun.\n\n" +
//                "Sebagian dari wisatawan dan pesohor bisa saja sudah jenuh dengan kemewahan yang serba artifisial dan ingin sekali-sekali back to nature untuk penyegaran.\n\n" +
//                "Kendati infrastruktur konektivitas belum optimal ketersediaannya, dan dari aspek amenitas (fasilitas akomodasi dan pendukungnya) terbilang minimalis, serta posisinya pun di pojok Samudera Hindia yang sunyi, ribuan wisatawan mancanegara mendatangi Mentawai setiap tahunnya. Lantas ada apa dengan Mentawai? apa yang ditawarkan di Mentawai? Tingginya ombak yang konsisten sepanjang tahun menjadi surga bagi pada peselancar, termasuk kelas pemula.\n\n" +
//                "Bukan itu saja, pantai-pantainya yang indah, bersih dan berpasir putih, serta berair jernih dihiasi ikan berwarna warni dan terumbu karang yang indah pada taman-taman lautnya menawarkan sensasi tersendiri, dipadu dengan hijaunya kawasan hutan di sekitarnya.\n" +
//                "Mentawai memiliki banyak pantai cantik tersembunyi yang belum terjamah. Jumlah pulau saja sekitar 100, tetapi hanya beberapa pulau utama yang dihuni.",
//        imageRes = R.drawable.kulukubukterjun
//    )
//}
