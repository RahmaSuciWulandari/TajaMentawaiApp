package com.uci.tajamentawai.Data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.uci.tajamentawai.Data.entity.Reservation
import kotlinx.coroutines.flow.Flow

@Dao
interface ReservationDao {
    @Query("SELECT * FROM reservations_table")
    fun getAllReservations(): Flow<List<Reservation>>

    @Insert
    suspend fun insertReservation(reservation: Reservation)

    @Delete
    suspend fun deleteReservation(reservation: Reservation)

    @Query("DELETE FROM reservations_table")
    suspend fun clearAllReservations()
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(reservation: Reservation) : Long
//
//    @Update
//    suspend fun update(reservation: Reservation) : Int
//
//    @Query("SELECT * FROM reservations")
//    fun getAllReservations(): Flow<List<Reservation>>
//
//    @Query("DELETE FROM reservations WHERE id = :id ")
//    suspend fun deleteAll(id : Int)
}