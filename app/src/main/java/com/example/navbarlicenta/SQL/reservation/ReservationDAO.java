package com.example.navbarlicenta.SQL.reservation;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.navbarlicenta.SQL.prices.Prices;

import java.util.List;

@Dao
public interface ReservationDAO {

    @Query("SELECT * FROM reservation")
    LiveData<List<Reservation>> getAll();

    @Query("SELECT * FROM reservation where id_user IN (:userIds)")
    LiveData<List<Reservation>> getAllbyID(int userIds);

    @Query("SELECT * FROM reservation")
    List<Reservation> getAllReservations();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Reservation... reservation);

    @Delete
    void delete(Reservation reservation);

    @Update
    void updateReservation(Reservation reservation);

    @Query("DELETE FROM reservation")
    void deleteAll();
}
