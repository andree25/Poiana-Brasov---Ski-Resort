package com.example.navbarlicenta.ui.hotels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HotelsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public HotelsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Some of our best Hotels:");
    }

    public LiveData<String> getText() {
        return mText;
    }}