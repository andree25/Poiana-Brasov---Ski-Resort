package com.example.navbarlicenta.ui.hotels;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.navbarlicenta.R;
import com.example.navbarlicenta.ui.home.HomeViewModel;

public class HotelsFragment extends Fragment {

    private HotelsViewModel hotelsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        hotelsViewModel =
                new ViewModelProvider(this).get(HotelsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_hotels, container, false);
        final TextView textView = root.findViewById(R.id.text_hotels);
        hotelsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;

    }

}