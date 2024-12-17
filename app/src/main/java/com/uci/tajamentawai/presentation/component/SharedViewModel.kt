package com.uci.tajamentawai.presentation.component

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.uci.tajamentawai.Data.entity.Reservation
import com.uci.tajamentawai.Data.repository.ReservationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ReservationRepository
) : ViewModel() {

    val reservations: LiveData<List<Reservation>> = repository.allReservations.asLiveData()

    fun addReservation(reservation: Reservation) {
        viewModelScope.launch {
            repository.insert(reservation)
        }
    }

//    fun deleteAllReservations() {
//        viewModelScope.launch {
//            repository.deleteAll(i)
//        }
//    }

    // Untuk menyimpan metode pembayaran
    private val _paymentMethod = MutableLiveData<String>()
    val paymentMethod: LiveData<String> get() = _paymentMethod

    fun setPaymentMethod(method: String) {
        _paymentMethod.value = method
    }

    // Untuk menyimpan tanggal reservasi
    private val _reservationDate = MutableLiveData<String>()
    val reservationDate: LiveData<String> get() = _reservationDate

    fun setReservationDate(date: String) {
        _reservationDate.value = date
    }

    private val _reservationData = MutableLiveData<Map<String, String>>()
    val reservationData: LiveData<Map<String, String>> get() = _reservationData

    fun setReservationData(data: Map<String, String>) {
        _reservationData.value = data
    }

    private val _notification = MutableLiveData<String>()
    val notification: LiveData<String> get() = _notification

    fun setNotification(message: String) {
        _notification.value = message
    }

}