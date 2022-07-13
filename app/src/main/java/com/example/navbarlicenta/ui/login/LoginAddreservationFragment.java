package com.example.navbarlicenta.ui.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.navbarlicenta.R;
import com.example.navbarlicenta.SQL.AppDatabase;
import com.example.navbarlicenta.SQL.prices.Prices;
import com.example.navbarlicenta.SQL.prices.PricesAdapter;

import java.util.List;

public class LoginAddreservationFragment extends Fragment {

    private LoginAddreservationViewModel loginAddreservationViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loginAddreservationViewModel =
                new ViewModelProvider(this).get(LoginAddreservationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_login_addreservation, container, false);
        final TextView textView = root.findViewById(R.id.text_login_addreserv);
        loginAddreservationViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        RecyclerView recyclerView = root.findViewById(R.id.login_recyclerView_addreserv);
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        recyclerView.setHasFixedSize(true);

        PricesAdapter pricesAdapter = new PricesAdapter();
        recyclerView.setAdapter(pricesAdapter);


        AppDatabase db = AppDatabase.getDbInstance(getActivity().getApplicationContext());



        loginAddreservationViewModel.getAllPrices().observe(getActivity(), new Observer<List<Prices>>() {
            @Override
            public void onChanged(List<Prices> prices) {
                pricesAdapter.setPricesList(prices);
            }
        });


        return root;
    }

}