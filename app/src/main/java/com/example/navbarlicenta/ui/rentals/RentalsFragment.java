package com.example.navbarlicenta.ui.rentals;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.navbarlicenta.R;
import com.example.navbarlicenta.ui.home.HomeViewModel;

public class RentalsFragment extends Fragment {

    private RentalsViewModel rentalsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rentalsViewModel =
                new ViewModelProvider(this).get(RentalsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_rentals, container, false);
        final TextView textView = root.findViewById(R.id.text_rentals);
        rentalsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}