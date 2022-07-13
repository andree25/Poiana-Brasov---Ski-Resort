package com.example.navbarlicenta.SQL.reservation;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.navbarlicenta.SQL.AppDatabase;
import com.example.navbarlicenta.SQL.prices.PricesDAO;
import com.example.navbarlicenta.modal.SingletonEnum;

import java.util.List;

public class ReservationRepository {

    private ReservationDAO reservationDAO;
    private LiveData<List<Reservation>> allReservations;
    private LiveData<List<Reservation>> allReservationsbyID;
    int actualUser = SingletonEnum.INSTANCE.getValue();

    public ReservationRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getDbInstance(application);
        reservationDAO = appDatabase.reservationDAO();
        allReservations = reservationDAO.getAll();
        allReservations = reservationDAO.getAllbyID(actualUser);
    }

    public void insert(Reservation reservation) {
        new InsertReservationAsyncTask(reservationDAO).execute(reservation);
    }

    public void update(Reservation reservation) {
        new UpdateReservationAsyncTask(reservationDAO).execute(reservation);
    }

    public void delete(Reservation reservation) {
        new DeleteReservationAsyncTask(reservationDAO).execute(reservation);
    }

    public void deleteAll() {
        new DeleteAllReservationAsyncTask(reservationDAO).execute();
    }

    public LiveData<List<Reservation>> getAllReservations() {
        return allReservations;
    }

    public LiveData<List<Reservation>>  getReservByID(int id){
        return reservationDAO.getAllbyID(id);
    }

    public static class InsertReservationAsyncTask extends AsyncTask<Reservation, Void, Void> {
        private ReservationDAO reservationDAO;

        private InsertReservationAsyncTask(ReservationDAO reservationDAO) {
            this.reservationDAO = reservationDAO;
        }

        @Override
        protected Void doInBackground(Reservation... reservations) {
            reservationDAO.insertAll(reservations[0]);
            return null;
        }
    }

    public static class UpdateReservationAsyncTask extends AsyncTask<Reservation, Void, Void> {
        private ReservationDAO reservationDAO;

        private UpdateReservationAsyncTask(ReservationDAO reservationDAO) {
            this.reservationDAO = reservationDAO;
        }

        @Override
        protected Void doInBackground(Reservation... reservations) {
            reservationDAO.updateReservation(reservations[0]);
            return null;
        }
    }

    public static class DeleteReservationAsyncTask extends AsyncTask<Reservation, Void, Void> {
        private ReservationDAO reservationDAO;

        private DeleteReservationAsyncTask(ReservationDAO reservationDAO) {

            this.reservationDAO = reservationDAO;
        }

        @Override
        protected Void doInBackground(Reservation... reservations) {
            reservationDAO.delete(reservations[0]);
            return null;
        }
    }

    public static class DeleteAllReservationAsyncTask extends AsyncTask<Void, Void, Void> {
        private ReservationDAO reservationDAO;

        private DeleteAllReservationAsyncTask(ReservationDAO reservationDAO) {
            this.reservationDAO = reservationDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            reservationDAO.deleteAll();
            return null;
        }
    }
}
