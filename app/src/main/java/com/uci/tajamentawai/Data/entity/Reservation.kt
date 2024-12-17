package com.uci.tajamentawai.Data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reservations_table")
data class Reservation(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: String,
    val paymentMethod: String,
    val notification: String,
    val key: String,
    val value: String,
    val images: String
)