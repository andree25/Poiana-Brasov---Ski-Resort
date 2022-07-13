package com.example.navbarlicenta.ui.rentals;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RentalsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public RentalsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Here are some of the schools that offer courses and rental equipment");
    }

    public LiveData<String> getText() {
        return mText;
    }}