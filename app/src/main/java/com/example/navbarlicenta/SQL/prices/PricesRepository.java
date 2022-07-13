package com.example.navbarlicenta.SQL.prices;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.navbarlicenta.SQL.AppDatabase;

import java.util.List;

public class PricesRepository {

    private PricesDAO pricesDAO;
    private LiveData<List<Prices>> allPrices;

    public PricesRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getDbInstance(application);
        pricesDAO = appDatabase.pricesDAO();
        allPrices = pricesDAO.getAll();
    }

    public void insert(Prices prices) {
        new PricesRepository.InsertPricesAsyncTask(pricesDAO).execute(prices);
    }

    public void update(Prices prices) {
        new UpdatePricesAsyncTask(pricesDAO).execute(prices);
    }

    public void delete(Prices prices) {
        new PricesRepository.DeletePricesAsyncTask(pricesDAO).execute(prices);
    }

    public void deleteAll() {
        new DeleteAllPricesAsyncTask(pricesDAO).execute();
    }

    public LiveData<List<Prices>> getAllPrices() {
        return allPrices;
    }

    public static class InsertPricesAsyncTask extends AsyncTask<Prices, Void, Void> {
        private PricesDAO pricesDAO;

        private InsertPricesAsyncTask(PricesDAO pricesDAO) {
            this.pricesDAO = pricesDAO;
        }

        @Override
        protected Void doInBackground(Prices... prices) {
            pricesDAO.insertPrice(prices[0]);
            return null;
        }
    }

    public static class UpdatePricesAsyncTask extends AsyncTask<Prices, Void, Void> {
        private PricesDAO pricesDAO;

        private UpdatePricesAsyncTask(PricesDAO pricesDAO) {
            this.pricesDAO = pricesDAO;
        }

        @Override
        protected Void doInBackground(Prices... prices) {
            pricesDAO.updatePrice(prices[0]);
            return null;
        }
    }

    public static class DeletePricesAsyncTask extends AsyncTask<Prices, Void, Void> {
        private PricesDAO pricesDAO;

        private DeletePricesAsyncTask(PricesDAO pricesDAO) {
            this.pricesDAO = pricesDAO;
        }

        @Override
        protected Void doInBackground(Prices... prices) {
            pricesDAO.delete(prices[0]);
            return null;
        }
    }

    public static class DeleteAllPricesAsyncTask extends AsyncTask<Void, Void, Void> {
        private PricesDAO pricesDAO;

        private DeleteAllPricesAsyncTask(PricesDAO pricesDAO) {
            this.pricesDAO = pricesDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            pricesDAO.deleteAll();
            return null;
        }
    }
}
