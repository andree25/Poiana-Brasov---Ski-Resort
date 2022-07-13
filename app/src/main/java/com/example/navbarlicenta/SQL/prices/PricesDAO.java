package com.example.navbarlicenta.SQL.prices;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.navbarlicenta.SQL.user.User;

import java.util.List;

@Dao
public interface PricesDAO {

    @Query("SELECT * FROM prices")
    LiveData<List<Prices>> getAll();

    @Query("SELECT * FROM prices")
    List<Prices> getAllPrices();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Prices... prices);

    @Insert
    void insertPrice(Prices prices);

    @Delete
    void delete(Prices prices);

    @Update
    void updatePrice(Prices prices);

    @Query("DELETE FROM prices")
    void deleteAll();
}
