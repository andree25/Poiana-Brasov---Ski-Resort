package com.example.navbarlicenta.ui.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navbarlicenta.R;
import com.example.navbarlicenta.SQL.reservation.Reservation;
import com.example.navbarlicenta.SQL.reservation.ReservationAdapter;
import com.example.navbarlicenta.SQL.user.User;
import com.example.navbarlicenta.SQL.user.UserAdapter;
import com.example.navbarlicenta.modal.SingletonEnum;
import com.example.navbarlicenta.ui.admin.AdminViewModel;

import java.util.List;

public class LoginSeeReservationsFragment extends Fragment {

    private LoginSeeReservationsViewModel loginSeeReservationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        loginSeeReservationsViewModel =
                new ViewModelProvider(this).get(LoginSeeReservationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_login_see_reservations, container, false);
        final TextView textView = root.findViewById(R.id.text_seereserv);
        loginSeeReservationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        RecyclerView recyclerView = root.findViewById(R.id.reserv_recyclerView);
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        recyclerView.setHasFixedSize(true);

        ReservationAdapter reservationAdapter = new ReservationAdapter();
        recyclerView.setAdapter(reservationAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                loginSeeReservationsViewModel.delete(reservationAdapter.getReservationAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getActivity(), "Reservation deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        int actualUser = SingletonEnum.INSTANCE.getValue();


        loginSeeReservationsViewModel.getReservByID(actualUser).observe(getActivity(), new Observer<List<Reservation>>() {
            @Override
            public void onChanged(List<Reservation> reservations) {
                reservationAdapter.setReservationList(reservations);
            }
        });

        return root;
    }
}