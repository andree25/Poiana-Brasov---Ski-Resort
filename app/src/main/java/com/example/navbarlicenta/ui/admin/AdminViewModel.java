package com.example.navbarlicenta.ui.admin;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.navbarlicenta.SQL.user.User;
import com.example.navbarlicenta.SQL.user.UserRepository;

import java.util.List;

public class AdminViewModel extends AndroidViewModel{
    private MutableLiveData<String> mText;

    private UserRepository userRepository;
    private LiveData<List<User>> allUsers;

    public AdminViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        allUsers = userRepository.getAllUsers();
        mText = new MutableLiveData<>();
        mText.setValue("Swipe left or right to delete an user:");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void insert(User user) {
        userRepository.insert(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

}


