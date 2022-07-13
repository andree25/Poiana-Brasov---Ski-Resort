package com.example.navbarlicenta.ui.passes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.navbarlicenta.SQL.user.User;

import java.util.List;

public class PassesViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public PassesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Subscriptions");
    }
    public LiveData<String> getText() {
        return mText;
    }

    private MutableLiveData<List<User>> users;

    public LiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<List<User>>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        // Do an asynchronous operation to fetch users.
    }
}