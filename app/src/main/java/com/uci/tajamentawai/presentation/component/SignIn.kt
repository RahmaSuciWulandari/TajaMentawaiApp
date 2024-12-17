package com.uci.tajamentawai.presentation.component

//import com.uci.tajamentawai.ui.theme.TajaMentawaiTheme
//import com.uci.tajamentawai.utils.APIService
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uci.tajamentawai.R
import com.uci.tajamentawai.navigation.Screen
import com.uci.tajamentawai.ui.theme.TajaMentawaiTheme

data class ApiResponse(
    val status: String,
    val message: String
)

@Composable
fun SignInScreen(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tajamentawailogobaru),
                    contentDescription = "Wave icon",
                    modifier = Modifier.size(215.dp)
                        .offset(y=50.dp)
                )
                Text(
                    text = "Getting Started",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Let's login for explore mentawai island!",
                    fontSize = 14.sp
                )
                OutlinedTextField(
                    value = email.value,
                    onValueChange = {email.value = it},
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") }
                )
                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it},
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Password") },
                    trailingIcon = { Icon(imageVector = Icons.Default.Visibility, contentDescription = "Visibility") }
                )
                Text(
                    text = "Forgot Password?",
                    fontSize = 14.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .offset(x=120.dp, y=1.dp)
                        .clickable {navController.navigate(Screen.Forget.route)}
                )
                Button(
                    onClick = {
//                        login(email.value, password.value){success ->
//                            if (success) {
//                                navController.navigate(Screen.Home.route)
//                            }
//                        }
//                        navController.navigate(Screen.Home.route)
                        if (email.value == "user123@gmail.com" && password.value == "123user"){
                            navController.navigate(Screen.Home.route)
                        }



                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color(0xFF24A4AC))
                ) {
                    Text(text = "Login", color = Color.White)
                }
//                val annotatedString = buildAnnotatedString {
//                    append("Don't have an account? ")
//                    pushStringAnnotation(tag = "SIGN_UP", annotation = "SignUp")
//                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
//                        append("Sign Up")
//                    }
//                    pop()
//                }
//                ClickableText(
//                    text = annotatedString,
//                    onClick = { offset ->
//                        annotatedString.getStringAnnotations(tag = "SIGN_UP", start = offset, end = offset)
//                            .firstOrNull()?.let {
//                                navController.navigate(Screen.SignUp.route)
//                            }
//                    }
//                )
                //val isNavigated = remember { mutableStateOf(false) }
                Text(
                    text = "Don't have an account?",
                    fontSize = 14.sp,
                    color = Color(0xFF929292),
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.SignUp.route)
                        }
                        .align(Alignment.Start)

                )
                Text(
                    text = "Or Log in With",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF929292),
                    )
                )
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "image description",
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "image description",
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
            }
        }
    )
}

//fun login(email: String, password: String, onLoginResult: (Boolean) -> Unit) {
//    val api = com.uci.tajamentawai.utils.APIClient.instance.create(APIService::class.java)
//    api.login(email, password).enqueue(object : Callback<ApiResponse> {
//        override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
//            if (response.isSuccessful) {
//                val body = response.body()
//                onLoginResult(body?.status == "success")
//            } else {
//                println("Server error: ${response.message()}")
//                onLoginResult(false)
//            }
//        }
//
//        override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
//            println("Request failed: ${t.message}")
//            onLoginResult(false)
//        }
//    })
//}




@Composable
fun ForgetPasswordScreen(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val newPassword = remember { mutableStateOf("") }
        val confirmPassword = remember { mutableStateOf("") }
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tajamentawailogobaru),
                    contentDescription = "Wave icon",
                    modifier = Modifier.size(215.dp)
                        .offset(y=50.dp)
                )
                Text(
                    text = "Forget Password Account TajaMentawai",
                    fontSize = 14.sp
                )
                OutlinedTextField(
                    value = email.value,
                    onValueChange = {email.value = it},
                    label = { Text("Email or Phone Number") },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") }
                )
                OutlinedTextField(
                    value = newPassword.value ,
                    onValueChange = {newPassword.value = it },
                    label = { Text("New Password") },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Password") },
                    trailingIcon = { Icon(imageVector = Icons.Default.Visibility, contentDescription = "Visibility") }
                )
                OutlinedTextField(
                    value = confirmPassword.value,
                    onValueChange = { confirmPassword.value = it },
                    label = { Text("Reconfirm Password") },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Password") },
                    trailingIcon = { Icon(imageVector = Icons.Default.Visibility, contentDescription = "Visibility") }
                )
                Button(
                    onClick = {
                        if (newPassword.value == confirmPassword.value) {
                            //resetPassword(email.value, newPassword.value, confirmPassword.value)
                            navController.navigate(Screen.SignIn.route)
                        } else {
                            println("Passwords do not match!")
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color(0xFF24A4AC))
                ) {
                    Text(text = "Reset Password", color = Color.White)
                }
            }
        }
    )
}

//fun resetPassword(emailOrPhone: String, newPassword: String, confirmPassword: String) {
//    val api = com.uci.tajamentawai.utils.APIClient.instance.create(APIService::class.java)
//    api.resetPassword(emailOrPhone, newPassword).enqueue(object : Callback<ApiResponse> {
//        override fun onResponse(call: Call<ApiResponse>, response: retrofit2.Response<ApiResponse>) {
//            if (response.isSuccessful) {
//                val body = response.body()
//                println("Password reset successful: ${body?.message}")
////                if (body?.status == "success") {
////                    println("Password berhasil direset: ${body.message}")
////                } else {
////                    println("Reset Gagal: ${body?.message}")
////                }
//            }
//        }
//
//        override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
//            println("Gagal terhubung ke server: ${t.message}")
//        }
//    })
//}

@Composable
fun SignUpScreen(navController: NavController) {
    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
   // val confirmPassword = remember { mutableStateOf("") }

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tajamentawailogobaru),
                    contentDescription = "Wave icon",
                    modifier = Modifier.size(215.dp)
                        .offset(y=50.dp)
                )
                Text(
                    text = "Create Account",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Join us to explore the beauty of Mentawai Island!",
                    fontSize = 14.sp
                )
                OutlinedTextField(
                    value = username.value,
                    onValueChange = {username.value = it},
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = email.value,
                    onValueChange = {email.value = it},
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") }
                )
                OutlinedTextField(
                    value = password.value,
                    onValueChange = {password.value = it},
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Password") },
                    trailingIcon = { Icon(imageVector = Icons.Default.Visibility, contentDescription = "Visibility") }
                )
                Button(
                    onClick = {
                            //signUp(username.value, email.value, password.value)
                        navController.navigate(Screen.SignIn.route)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color(0xFF24A4AC))
                ) {
                    Text(text = "Sign Up", color = Color.White)

                }
                Text(
                    text = "Already have an account?",
                    fontSize = 14.sp,
                    color = Color(0xFF929292),
                    modifier = Modifier.clickable {  }
                )
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "image description",
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "image description",
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
            }
        }
    )
}

//fun signUp(username: String, email: String, password: String) {
//    val api = com.uci.tajamentawai.utils.APIClient.instance.create(APIService::class.java)
//    api.signUp(username, email, password).enqueue(object : Callback<ApiResponse> {
//        override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
//            if (response.isSuccessful) {
//                val body = response.body()
//                println("Sign-up successful: ${body?.message}")
////                if (body?.status == "success") {
////                    println("Sign-up successful: ${body.message}")
////                } else {
////                    println("Sign-up failed: ${body?.message}")
////                }
//            } else {
//                println("Server error: ${response.message()}")
//            }
//        }
//
//        override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
//            println("Request failed: ${t.message}")
//        }
//    })
//}

@Preview(showBackground = true)
@Composable
fun PreviewSignInScreen() {
    TajaMentawaiTheme {
        SignInScreen(navController = rememberNavController())
    }
}

