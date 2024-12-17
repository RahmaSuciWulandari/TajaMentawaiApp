package com.uci.tajamentawai.Data.repository

import com.uci.tajamentawai.Data.dao.ReservationDao
import com.uci.tajamentawai.Data.entity.Reservation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReservationRepository(private val reservationDao: ReservationDao) {

    val allReservations: Flow<List<Reservation>> = reservationDao.getAllReservations()

    suspend fun insert(reservation: Reservation) {
        reservationDao.insertReservation(reservation)
    }

    suspend fun clearAll() {
        reservationDao.clearAllReservations()
    }
}

//class ReservationRepository @Inject constructor (private val reservationDao: ReservationDao) {
//    val allReservations: Flow<List<Reservation>> = reservationDao.getAllReservations()
//
//    suspend fun insert(reservation: Reservation) {
//        reservationDao.insert(reservation)
//    }
//
//    suspend fun update(reservation: Reservation) {
//        reservationDao.update(reservation)
//    }
//
//    suspend fun deleteAll(id : Int) {
//        reservationDao.deleteAll(id)
//    }
//}