package com.example.navbarlicenta.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.navbarlicenta.SQL.prices.Prices;
import com.example.navbarlicenta.SQL.prices.PricesRepository;

import java.util.List;

public class LoginAddreservationViewModel extends AndroidViewModel {
    private MutableLiveData<String> mText;

    private PricesRepository pricesRepository;
    private LiveData<List<Prices>> allPrices;

    public LoginAddreservationViewModel(@NonNull Application application) {
        super(application);
        pricesRepository = new PricesRepository(application);
        allPrices = pricesRepository.getAllPrices();
        mText = new MutableLiveData<>();
        mText.setValue("Pick your card:");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void insert(Prices prices) {
        pricesRepository.insert(prices);
    }

    public void update(Prices prices) {
        pricesRepository.update(prices);
    }

    public void delete(Prices prices) {
        pricesRepository.delete(prices);
    }

    public void deleteAllPrices() {
        pricesRepository.deleteAll();
    }

    public LiveData<List<Prices>> getAllPrices() {
        return allPrices;
    }}