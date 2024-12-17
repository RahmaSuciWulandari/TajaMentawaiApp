package com.uci.tajamentawai.Data

import android.content.Context
import com.uci.tajamentawai.Data.dao.ReservationDao
import com.uci.tajamentawai.Data.database.AppDatabase
//import com.uci.tajamentawai.Data.database.ReservationDatabase
import com.uci.tajamentawai.Data.repository.ReservationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideReservationDao(database: AppDatabase): ReservationDao {
        return database.reservationDao()
    }

    @Provides
    @Singleton
    fun provideReservationDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideReservationRepository(reservationDao: ReservationDao): ReservationRepository {
        return ReservationRepository(reservationDao)
    }
}

