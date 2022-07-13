package com.example.navbarlicenta.SQL;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.navbarlicenta.SQL.prices.Prices;
import com.example.navbarlicenta.SQL.prices.PricesDAO;
import com.example.navbarlicenta.SQL.reservation.Reservation;
import com.example.navbarlicenta.SQL.reservation.ReservationDAO;
import com.example.navbarlicenta.SQL.user.User;
import com.example.navbarlicenta.SQL.user.UserDAO;

@Database(entities = {User.class, Reservation.class, Prices.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();

    public abstract PricesDAO pricesDAO();

    public abstract ReservationDAO reservationDAO();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "POIANA_BRASOV")
                    .allowMainThreadQueries().addCallback(roomCallback).build();
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private PricesDAO pricesDAO;
        private PopulateDbAsyncTask(AppDatabase db) {
            pricesDAO = db.pricesDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            //subscriptions
            pricesDAO.insertPrice(new Prices("11:00", 120, 70));
            pricesDAO.insertPrice(new Prices("13:00", 90, 50));
            pricesDAO.insertPrice(new Prices("14:00", 65, 40));
            pricesDAO.insertPrice(new Prices("4 Hours", 110, 65));
            pricesDAO.insertPrice(new Prices("1 Day", 150, 85));
            pricesDAO.insertPrice(new Prices("2 Days", 240, 130));
            pricesDAO.insertPrice(new Prices("3 Days", 340, 180));
            pricesDAO.insertPrice(new Prices("4 Days", 420, 220));
            pricesDAO.insertPrice(new Prices("5 Days", 500, 260));
            pricesDAO.insertPrice(new Prices("6 Days", 570, 300));
            pricesDAO.insertPrice(new Prices("10 Days", 1050, 650));
            pricesDAO.insertPrice(new Prices("20 Hours", 500, 260));
            pricesDAO.insertPrice(new Prices("Up", 25, 15));
            pricesDAO.insertPrice(new Prices("Up&Down", 40, 20));
            pricesDAO.insertPrice(new Prices("Down", 35, 15));
            //points
            pricesDAO.insertPrice(new Prices("10 Points", 45, 25));
            pricesDAO.insertPrice(new Prices("20 Points", 80, 40));
            pricesDAO.insertPrice(new Prices("30 Points", 115, 60));
            pricesDAO.insertPrice(new Prices("60 Points", 200, 105));
            pricesDAO.insertPrice(new Prices("80 Points", 230, 135));
            pricesDAO.insertPrice(new Prices("120 Points", 330, 180));
            pricesDAO.insertPrice(new Prices("240 Points", 570, 300));
            return null;
        }
    }


}
