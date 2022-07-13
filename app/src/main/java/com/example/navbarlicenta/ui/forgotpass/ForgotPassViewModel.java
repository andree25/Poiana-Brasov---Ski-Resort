package com.example.navbarlicenta.ui.forgotpass;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ForgotPassViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ForgotPassViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Enter your email and new password:");
    }

    public LiveData<String> getText() {
        return mText;
    }}