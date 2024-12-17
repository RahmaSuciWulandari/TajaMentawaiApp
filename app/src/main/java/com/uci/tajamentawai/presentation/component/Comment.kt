
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.R


@Composable
fun CommentsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        TopBar(navController)
        Spacer(modifier = Modifier.height(16.dp))
        CommentsList()
        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        CommentInput()
    }
}

@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Text(text = "Comments", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(Icons.Default.Send, contentDescription = "send")
        }
    }
}

@Composable
fun CommentsList() {
    Column {
        CommentItem(
            username = "gregnowak973",
            comment = "I love this idea and hope to try the product; however, do you have any scientific evidence that shows these fruit / veggie powders can be absorbed by the body just as the fruits they are made of? I really want to try the product but worry about the over processing making the nutrients / minerals from the fruit hard to be used by the body",
            time = "6d",
            likes = 4
        )
        Text(text = "View 2 previous replies", color = Color.Blue, fontSize = 14.sp)
        CommentItem(
            username = "kencko",
            comment = "@gregnowak973 Let us know your feedback after you get your first box :)",
            time = "5d",
            likes = 1,
            isReply = true
        )
        Text(text = "View 1 more reply", color = Color.Blue, fontSize = 14.sp)
        CommentItem(
            username = "cwrez73",
            comment = "I read awesome reviews and just placed my first order, looking forward to it😍🥰",
            time = "4d",
            likes = 1
        )
        CommentItem(
            username = "kencko",
            comment = "@cwrez73 Woohoo! Share your feedback after you enjoy your first box :)",
            time = "4d",
            isReply = true
        )
        CommentItem(
            username = "g.duke",
            comment = "Just ordered my box 😍😍",
            time = "5d",
            likes = 2
        )
    }
}

@Composable
fun CommentItem(username: String, comment: String, time: String, likes: Int = 0, isReply: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.uminn),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = username,
                fontWeight = FontWeight.Bold,
                color = if (isReply) Color.Blue else Color.Black
            )
            Text(text = comment, fontSize = 14.sp)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = time, fontSize = 12.sp, color = Color.Gray)
                if (likes > 0) {
                    Text(text = "$likes likes", fontSize = 12.sp, color = Color.Gray)
                }
                Text(text = "Reply", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}

//@Composable
//fun ReactionBar() {
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceEvenly
//    ) {
//        Icon(painter = painterResource(id = R.drawable.ic_heart), contentDescription = "Heart")
//        Icon(painter = painterResource(id = R.drawable.ic_comment), contentDescription = "Comment")
//        Icon(painter = painterResource(id = R.drawable.ic_fire), contentDescription = "Fire")
//        Icon(painter = painterResource(id = R.drawable.ic_laugh), contentDescription = "Laugh")
//        Icon(painter = painterResource(id = R.drawable.ic_surprise), contentDescription = "Surprise")
//        Icon(painter = painterResource(id = R.drawable.ic_sad), contentDescription = "Sad")
//        Icon(painter = painterResource(id = R.drawable.ic_angry), contentDescription = "Angry")
//    }
//}

@Composable
fun CommentInput() {
    var text by remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.bangchan),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .background(Color.LightGray, CircleShape)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            singleLine = true
        )
        TextButton(onClick = { /* Post comment */ }) {
            Text(text = "Post", color = Color.Blue)
        }
    }
}