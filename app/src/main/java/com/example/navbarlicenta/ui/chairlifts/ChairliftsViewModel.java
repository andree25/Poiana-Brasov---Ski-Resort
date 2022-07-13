package com.example.navbarlicenta.ui.chairlifts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChairliftsViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    public ChairliftsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Click on 'i' button!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}