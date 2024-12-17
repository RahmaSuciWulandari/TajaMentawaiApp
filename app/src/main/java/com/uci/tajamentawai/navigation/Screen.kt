package com.uci.tajamentawai.navigation

sealed class Screen (val route: String){
    data object Splash : Screen("splash")
    data object Welcome1 : Screen("welcome1")
    data object Welcome2 : Screen("welcome2")
    data object Welcome3 : Screen("welcome3")
    data object SignIn : Screen("signin")
    data object SignUp : Screen("signup")
    data object Forget : Screen("forget")
    data object Home : Screen("home")
    data object Articles: Screen("articles")
    data object DetailArticles: Screen("articleDetail")
    data object Reservation: Screen("reservation")
    data object Notification: Screen("notification")
    data object Profile : Screen("profile")
    data object InfoW : Screen("info_wisatawan")
    data object InfoK : Screen("info_kontak")
    data object UbahS : Screen("ubah_sandi")
    data object DetailDestination: Screen("detail_destination")
    data object Destination : Screen("destination")
    data object PaymentMethod : Screen("payment_method")
    data object Sukses : Screen("sukses")
    data object Comment : Screen("comment")
    data object Konfir : Screen("konfirmasi_pembayaran")
    data object TravelGuide: Screen("travel_guide")
    data object Community: Screen("community")
    data object Chat: Screen("chat")
    data object ListChat: Screen("listchat")
    data object Calender: Screen("calender")
    data object ReservationNow: Screen("reservationnow")
    data object Status: Screen("status")
}