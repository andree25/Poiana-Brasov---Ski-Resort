package com.example.navbarlicenta.ui.slopes;

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
import android.widget.EditText;
import android.widget.TextView;

import com.example.navbarlicenta.R;

public class SlopesFragment extends Fragment {

    private SlopesViewModel slopesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slopesViewModel =
                new ViewModelProvider(this).get(SlopesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slopes, container, false);
        final TextView textView = root.findViewById(R.id.text_slopes);
        slopesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }



        });


        return root;
    }
}