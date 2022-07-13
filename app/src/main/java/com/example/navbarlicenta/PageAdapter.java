package com.example.navbarlicenta;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.navbarlicenta.ui.login.LoginAddreservationFragment;
import com.example.navbarlicenta.ui.login.LoginSeeReservationsFragment;

public class PageAdapter extends FragmentStateAdapter {
    String[] titles = new String[]{"Reservations", "Add Reservation"};
    public PageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new LoginSeeReservationsFragment();
            case 1:
                return new LoginAddreservationFragment();
        }
        return new LoginSeeReservationsFragment();
    }
    @Override
    public int getItemCount() {
        return titles.length;
    }
}

