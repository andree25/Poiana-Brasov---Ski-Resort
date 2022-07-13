package com.example.navbarlicenta.ui.slopes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlopesViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public SlopesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Live Webcams");
    }

    public LiveData<String> getText() {
        return mText;
    }
}