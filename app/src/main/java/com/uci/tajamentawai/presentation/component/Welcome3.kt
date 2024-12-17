package com.uci.tajamentawai.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uci.tajamentawai.R
import com.uci.tajamentawai.navigation.Screen

@Composable
fun Welcome3Screen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.wel3),
                contentDescription = " ",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                Modifier
                    .width(355.dp)
                    .height(301.dp)
                    .background(color = Color(0xFFF1F1F5),
                        shape = RoundedCornerShape(size = 24.dp)
                        ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(38.dp)
                        .padding(top = 2.dp)
                ) {
                    Text(
                        text = "Update Information",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF000000)
                        ), modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "Update all information related to Mentawai and travel guides so you don't get confused",
                        style = LocalTextStyle.current.merge(
                            TextStyle(
                                lineHeight = 1.4.em,
                                lineHeightStyle = LineHeightStyle(
                                    alignment = LineHeightStyle.Alignment.Center,
                                    trim = LineHeightStyle.Trim.None
                                )
                            )
                        ),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Image(
                        painter = painterResource(id = R.drawable.slide3),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(0.dp)
                            .width(40.dp)
                            .height(8.dp)
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Button(
                        onClick = {navController.navigate(Screen.SignIn.route)},
                        colors = ButtonDefaults.buttonColors(Color(0xFF007B7F)),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                            .width(200.dp)
                    ) {
                        Text(text = "Get Started", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(3.dp))

                }
            }
        }
    }
}

