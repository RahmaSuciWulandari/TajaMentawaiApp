package com.uci.tajamentawai.presentation

//import com.uci.tajamentawai.presentation.component.DestinationScreen
import CommentsScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tajamentawaiapp.CommunityScreen
import com.example.tajamentawaiapp.IsiChatScreen
import com.example.tajamentawaiapp.PaymentConfirmationScreen
import com.example.tajamentawaiapp.PembayaranScreen
import com.example.tajamentawaiapp.cerita
import com.uci.tajamentawai.Data.database.AppDatabase
import com.uci.tajamentawai.R
import com.uci.tajamentawai.navigation.NavigationItem
import com.uci.tajamentawai.navigation.Screen
import com.uci.tajamentawai.presentation.component.AccountSettingsScreen
import com.uci.tajamentawai.presentation.component.ArticleDetailScreen
import com.uci.tajamentawai.presentation.component.ArticleScreen
import com.uci.tajamentawai.presentation.component.CalendarScreen
import com.uci.tajamentawai.presentation.component.ChangePasswordScreen
import com.uci.tajamentawai.presentation.component.ContactScreen
import com.uci.tajamentawai.presentation.component.DaftarChatScreen
import com.uci.tajamentawai.presentation.component.DestinationScreen
import com.uci.tajamentawai.presentation.component.ForgetPasswordScreen
import com.uci.tajamentawai.presentation.component.HomeScreen
import com.uci.tajamentawai.presentation.component.MetodePembayaranScreen
import com.uci.tajamentawai.presentation.component.NotifikasiScreen
import com.uci.tajamentawai.presentation.component.PilihDestinationScreen
import com.uci.tajamentawai.presentation.component.PilihTravelScreen
import com.uci.tajamentawai.presentation.component.ReservasiScreen
import com.uci.tajamentawai.presentation.component.SettingsScreen
import com.uci.tajamentawai.presentation.component.SharedViewModel
import com.uci.tajamentawai.presentation.component.SignInScreen
import com.uci.tajamentawai.presentation.component.SignUpScreen
import com.uci.tajamentawai.presentation.component.SplashScreen
import com.uci.tajamentawai.presentation.component.SuccessScreen
import com.uci.tajamentawai.presentation.component.TravelGuideScreen
import com.uci.tajamentawai.presentation.component.Welcome1Screen
import com.uci.tajamentawai.presentation.component.Welcome2Screen
import com.uci.tajamentawai.presentation.component.Welcome3Screen
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TajaMentawaiApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    sharedViewModel: SharedViewModel = hiltViewModel()
) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val database = AppDatabase.getDatabase(context)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val routesWithBottomBar = listOf(
        Screen.Home.route,
        Screen.Articles.route,
        Screen.Reservation.route,
        Screen.Notification.route,
        Screen.Profile.route
    )

    Scaffold(
        bottomBar = {
            if (currentRoute in routesWithBottomBar) {
                BottomBar(navController)
            }
        },
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(navController)
            }
            composable(Screen.Welcome1.route) {
                Welcome1Screen(navController)
            }
            composable(Screen.Welcome2.route) {
                Welcome2Screen(navController)
            }
            composable(Screen.Welcome3.route) {
                Welcome3Screen(navController)
            }
            composable(Screen.SignIn.route) {
                SignInScreen(navController)
            }
            composable(Screen.SignUp.route) {
                SignUpScreen(navController)
            }
            composable(Screen.Forget.route) {
                ForgetPasswordScreen(navController)
            }

            composable(Screen.Home.route) {
                HomeScreen(navController)
            }

            composable(Screen.Articles.route) {
                ArticleScreen(navController)
            }
            composable(
                Screen.DetailArticles.route + "/{articleId}",
                arguments = listOf(navArgument("articleId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                val articleId = navBackStackEntry.arguments?.getInt("articleId")
                ArticleDetailScreen(artikelId = articleId, navController)
            }


            composable(Screen.Comment.route) {
                CommentsScreen(navController)
            }

            composable(Screen.Reservation.route) {
                ReservasiScreen(navController, database)
            }

            composable(Screen.Notification.route) {
                NotifikasiScreen(database)
            }

            composable(Screen.Profile.route) {
                SettingsScreen(navController)
            }

            composable(Screen.InfoW.route) {
                AccountSettingsScreen(navController)
            }

            composable(Screen.InfoK.route) {
                ContactScreen(navController)
            }

            composable(Screen.UbahS.route) {
                ChangePasswordScreen(navController)
            }

            composable(Screen.Sukses.route) {
                SuccessScreen(navController, sharedViewModel = sharedViewModel)
            }

            composable(
                Screen.DetailDestination.route + "/{destinationId}",
                arguments = listOf(navArgument("destinationId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                val destinationId = navBackStackEntry.arguments?.getInt("destinationId")
                PilihDestinationScreen(destinasiId = destinationId, navController)
            }

            composable(
                Screen.ReservationNow.route + "/{destinationId}",
                arguments = listOf(navArgument("destinationId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                val destinationId = navBackStackEntry.arguments?.getInt("destinationId")
                PembayaranScreen(
                    destinasiId = destinationId,
                    navController,
                    database,
                    sharedViewModel
                )
            }

//            composable(
//                Screen.PaymentMethod.route + "/{destinationId}",
//                arguments = listOf(navArgument("destinationId") { type = NavType.IntType })
//            ) { navBackStackEntry ->
//                val destinationId = navBackStackEntry.arguments?.getInt("destinationId")
//                MetodePembayaranScreen(destinasiId = destinationId, navController)
//            }

            composable(Screen.PaymentMethod.route + "/{destinasiId}") { backStackEntry ->
                val destinasiId = backStackEntry.arguments?.getString("destinasiId")?.toInt() ?: 0
                MetodePembayaranScreen(
                    destinasiId = destinasiId,
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )
            }

            composable(Screen.Destination.route) {
                DestinationScreen(navController = navController)
            }

//            composable(
//                Screen.Calender.route + "/{destinationId}",
//                arguments = listOf(navArgument("destinationId") { type = NavType.IntType })
//            ) { navBackStackEntry ->
//                val destinationId = navBackStackEntry.arguments?.getInt("destinationId")
//                CalendarScreen(destinasiId = destinationId, navController)
//            }

            composable(Screen.Calender.route + "/{destinasiId}") { backStackEntry ->
                val destinasiId = backStackEntry.arguments?.getString("destinasiId")?.toInt() ?: 0
                CalendarScreen(
                    destinasiId = destinasiId,
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )
            }

            composable(
                Screen.Chat.route + "/{destinationId}",
                arguments = listOf(navArgument("destinationId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                val destinationId = navBackStackEntry.arguments?.getInt("destinationId")
                IsiChatScreen(destinasiId = destinationId, navController)
            }

            composable(Screen.ListChat.route) {
                DaftarChatScreen(navController = navController)
            }

            composable(Screen.Konfir.route) {
                PaymentConfirmationScreen(navController)
            }
//            composable(Screen.PaymentMethod.route) {
//                MetodePembayaranScreen()
//            }
            composable(Screen.TravelGuide.route) {
                TravelGuideScreen(navController)
            }
            composable(
                Screen.PilihTravelGuide.route + "/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })) { backStackEntry ->
                val guideId = backStackEntry.arguments?.getInt("id")
                PilihTravelScreen(navController, guideId)
            }
            composable(Screen.Community.route) {
                CommunityScreen(navController)
            }
            composable(Screen.Status.route) {
                cerita()
            }
        }
    }
}


@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = painterResource(id = R.drawable.shop1),
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_articles),
                icon = painterResource(id = R.drawable.oouiarticlessearchrtl),
                screen = Screen.Articles
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_reservation),
                icon = painterResource(id = R.drawable.vector),
                screen = Screen.Reservation
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_notification),
                icon = painterResource(id = R.drawable.alarm),
                screen = Screen.Notification
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profile),
                icon = painterResource(id = R.drawable.account),
                screen = Screen.Profile
            )
        )

        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    if (currentRoute != item.screen.route) {
                        navController.navigate(item.screen.route) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(Screen.Home.route) {
                                inclusive = false
                            }
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(32.dp),
                        tint = Color.Unspecified
                    )
                },
                label = { Text(text = item.title) }
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    TajaMentawaiTheme {
//        TajaMentawaiApp()
//    }
//}