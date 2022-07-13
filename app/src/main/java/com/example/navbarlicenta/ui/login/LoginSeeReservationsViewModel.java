package com.example.navbarlicenta.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.navbarlicenta.SQL.prices.Prices;
import com.example.navbarlicenta.SQL.prices.PricesRepository;
import com.example.navbarlicenta.SQL.reservation.Reservation;
import com.example.navbarlicenta.SQL.reservation.ReservationRepository;
import com.example.navbarlicenta.modal.SingletonEnum;

import java.util.List;

public class LoginSeeReservationsViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;

    private ReservationRepository reservationRepository;
    private LiveData<List<Reservation>> allReservations;

    public LoginSeeReservationsViewModel(@NonNull Application application) {
        super(application);
        reservationRepository = new ReservationRepository(application);
        allReservations = reservationRepository.getAllReservations();
        mText = new MutableLiveData<>();
        mText.setValue("Swipe to delete a reservation:");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void insert(Reservation reservation) {
        reservationRepository.insert(reservation);
    }

    public void update(Reservation reservation) {
        reservationRepository.update(reservation);
    }

    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    public void deleteAllReservations() {
        reservationRepository.deleteAll();
    }

    public LiveData<List<Reservation>> getAllReservations() {
        return allReservations;
    }

    public LiveData<List<Reservation>> getReservByID(int id){
        return reservationRepository.getReservByID(id);
    }
}

