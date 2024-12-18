package com.uci.tajamentawaiapp

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.R
import com.uci.tajamentawai.navigation.Screen
import com.uci.tajamentawai.presentation.component.shareItem
import com.uci.tajamentawai.ui.theme.TajaMentawaiTheme
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.material3.Button
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.FileProvider
import java.io.File
import coil.compose.rememberImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityScreen(navController: NavController) {
    var showAddPostDialog = remember { mutableStateOf(false) }
    val posts = remember { mutableStateOf(samplePosts.toMutableList()) }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.community),
                        contentDescription = "Community",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .requiredWidth(width = 600.dp)
                            .requiredHeight(height = 280.dp)
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = "Traveller Story",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    LazyRow(
                        modifier = Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(sampleStories) { story ->
                            StoryItem(
                                story = story,
                                onAddClick = {
                                    if (story.title == "Add") {
                                        showAddPostDialog.value = true
                                    }else{
                                        navController.navigate(Screen.Status.route)
                                    }
                                }
                            )
                        }
                    }
                }
            }
            item{
                HorizontalDivider(
                    color = Color(0xffc4c4c4),
                    modifier = Modifier
                        .offset(y = 60.dp)
                        .fillMaxWidth()
                        .requiredHeight(height = 5.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = R.drawable.bangchan),
                        contentDescription = " ",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(45.dp)
                            .clip(CircleShape)
                    )
                    val searchQuery = remember { mutableStateOf("") }
//                    TextField(
//                        value = searchQuery.value, onValueChange = { searchQuery.value = it },
//                        placeholder = { Text("Apa yang ingin anda tanyakan atau bagikan?", color = Color.Black, fontSize = 12.sp) },
//                        modifier = Modifier
//                            .width(250.dp)
//                            .height(35.dp)
//                            .clip(
//                                shape = RoundedCornerShape(10.dp)
//                            ),
//                    )
                    TextField(
                        value = searchQuery.value, onValueChange = { searchQuery.value = it },
                        placeholder = { Text("Apa yang ingin anda tanyakan atau bagikan?", color = Color.Gray, fontSize = 10.sp) },
                        modifier = Modifier
                            .requiredWidth(250.dp)
                            // .height(35.dp)
                            .clip(
                                shape = RoundedCornerShape(10.dp)
                            ),
                    )
                    Box(
                        modifier = Modifier
                            .padding(0.dp)
                            .width(31.88571.dp)
                            .height(29.79167.dp)
                            .background(
                                color = Color(0xFF24A4AC),
                                shape = RoundedCornerShape(size = 10.dp)
                            )
                    ){
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = "Localized description",
                                tint = Color.White
                            )
                        }
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

            items(posts.value) { post ->
                PostItem(post, navController)
            }
        }
    }

    if (showAddPostDialog.value) {
        AddPostDialog(
            onDismiss = { showAddPostDialog.value = false },
            onPostAdded = { title, content ->
                posts.value.add(
                    Post(
                        1,"New User", title, content,
                        R.drawable.community, R.drawable.ellipse4,
                        "Just now", "Your Location"
                    )
                )
                showAddPostDialog.value = false
            }
        )
    }
}

@Composable
fun AddPostDialog(onDismiss: () -> Unit, onPostAdded: (String, String) -> Unit) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current

    // Result launcher for picking image
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri -> imageUri = uri }
    )

    // Result launcher for camera
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { success ->
            if (success) {
                // Use the imageUri to handle the image
            }
        }
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add New Post") },
        text = {
            Column {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = content,
                    onValueChange = { content = it },
                    label = { Text("Content") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(onClick = {
                        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                        val photoUri: Uri = FileProvider.getUriForFile(
                            context,
                            "com.uci.tajamentawaiapp.fileprovider",
                            File(context.cacheDir, "photo.jpg")
                        )
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                        cameraLauncher.launch(photoUri)
                    }) {
                        Text("Take Photo")
                    }

                    Button(onClick = {
                        galleryLauncher.launch("image/*")
                    }) {
                        Text("Choose from Gallery")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                if (imageUri != null) {
                    Image(painter = rememberImagePainter(imageUri), contentDescription = null)
                }
            }
        },
        confirmButton = {
            TextButton(onClick = {
                if (title.isNotBlank() && content.isNotBlank()) {
                    onPostAdded(title, content)
                }
            }) {
                Text("Post")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

@Composable
fun cerita(){
    Box{
        Column{
            Image(
                painter = painterResource(id = R.drawable.status1),
                contentDescription = "Community",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

@Composable
fun StoryItem(story: Story, onAddClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(80.dp)
            .clickable(onClick = onAddClick)
    ) {
        Image(
            painter = painterResource(id = story.imageRes),
            contentDescription = story.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
        )
        Text(
            text = story.title,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun PostItem(post: Post, navController: NavController) {
    var isLiked by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = post.profileImageRes),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = post.username,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "in",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = post.title,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black
                        )
                    }
                    Text(
                        text = "${post.timestamp} · ${post.location}",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = post.content,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Image(
                painter = painterResource(id = post.imageRes),
                contentDescription = "Post Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.thumb),
                    contentDescription = "Like",
                    modifier = Modifier
                        .size(50.dp)
                        .clickable { isLiked = !isLiked },
                    colorFilter = if (isLiked) ColorFilter.tint(Color.Red) else null
                )
                Image(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = "Comment",
                    modifier = Modifier
                        .size(50.dp)
                        .clickable {  navController.navigate(Screen.Comment.route)}
                )
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Share, contentDescription = "Share",
                        modifier = Modifier.clickable { shareItem(context) })
                }
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CommentScreen(navController: NavController, postId: String) {
//    CenterAlignedTopAppBar(
//        title = {
//            Text("Comment", style = typography.labelLarge) },
//        navigationIcon = {
//            IconButton(onClick = { navController.navigateUp() }) {
//                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
//            }
//        },
//    )
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp)
//        ) {
//            // Placeholder for comments
//            Text("Comments for Post ID: $postId")
//            // Here you can load comments from ViewModel or a repository
//        }
//    }

data class Story(val title: String, val imageRes: Int)

val sampleStories = listOf(
    Story("Add", R.drawable.add),
    Story("Story 1", R.drawable.uminn),
    Story("Story 2", R.drawable.bookie),
    Story("Story 3", R.drawable.jeongin),
    Story("Story 3", R.drawable.changbin),
    Story("Story 3", R.drawable.jinnie)
)


data class Post(
    val id: Int,
    val username: String,
    val title: String,
    val content: String,
    val imageRes: Int,
    val profileImageRes: Int,
    val timestamp: String,
    val location: String,
)

val samplePosts = listOf(
    Post(1,"Christopher Bang", "Kulukubuk Waterfall", "My Trip My Adventure", R.drawable.kulukubuk, R.drawable.bangchan, "1 h", "Mandobag, Sabulau"),
    Post(2,"Lee Minho", "Awera Island Beach", "Enjoying the waves!", R.drawable.aweraislandbeach, R.drawable.leeknow, "2 h", "Awera Island, Mentawai"),
    Post(3,"Hwang Hyunjin", "Kulukubuk Waterfall", "Nature is amazing 🌿", R.drawable.kulukubuk, R.drawable.jinnie, "3 h", "Sabulau Village"),
    Post(4,"Han Jisung", "Awera Island Beach", "Perfect sunset 🌅", R.drawable.aweraislandbeach, R.drawable.hannie, "4 h", "Mentawai Islands")
)