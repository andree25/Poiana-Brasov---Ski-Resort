package com.example.navbarlicenta.ui.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navbarlicenta.PageAdapter;
import com.example.navbarlicenta.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LoginFragment extends Fragment {

    private LoginViewModel loginViewModel;

    ViewPager2 viewPager;
    TabLayout tabLayout;
    TabItem tabItemReserv, tabItemAddReserv;
    PageAdapter pageAdapter;
    String[] titles = new String[]{"Reservations", "Add Reservation"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        loginViewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        viewPager = root.findViewById(R.id.viewPager);
        tabLayout = root.findViewById(R.id.tabLayout);
        tabItemReserv = root.findViewById(R.id.login_reservation);
        tabItemAddReserv = root.findViewById(R.id.login_addreservation);

        pageAdapter = new PageAdapter(getParentFragment());

        viewPager.setAdapter(pageAdapter);

        new TabLayoutMediator(tabLayout, viewPager, ((tab, position) -> tab.setText(titles[position]))).attach();


        loginViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });


        return root;
    }

}