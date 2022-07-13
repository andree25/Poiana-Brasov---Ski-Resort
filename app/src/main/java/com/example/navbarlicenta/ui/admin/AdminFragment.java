package com.example.navbarlicenta.ui.admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbarlicenta.R;
import com.example.navbarlicenta.SQL.user.User;
import com.example.navbarlicenta.SQL.user.UserAdapter;

import java.util.List;

public class AdminFragment extends Fragment {

    private AdminViewModel adminViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        adminViewModel =
                new ViewModelProvider(this).get(AdminViewModel.class);
        View root = inflater.inflate(R.layout.fragment_admin, container, false);
        final TextView textView = root.findViewById(R.id.text_admin);
        adminViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        RecyclerView recyclerView = root.findViewById(R.id.admin_recyclerView);
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        recyclerView.setHasFixedSize(true);

        UserAdapter userAdapter = new UserAdapter();
        recyclerView.setAdapter(userAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                adminViewModel.delete(userAdapter.getUserAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getActivity(), "User deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);


        adminViewModel.getAllUsers().observe(getActivity(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userAdapter.setUserList(users);
            }
        });

        return root;
    }

}