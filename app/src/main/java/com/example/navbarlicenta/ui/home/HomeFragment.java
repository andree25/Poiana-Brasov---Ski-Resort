package com.example.navbarlicenta.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.navbarlicenta.R;
import com.example.navbarlicenta.SQL.AppDatabase;
import com.example.navbarlicenta.SQL.prices.Prices;
import com.example.navbarlicenta.SQL.prices.PricesAdapter;
import com.example.navbarlicenta.SQL.user.User;
import com.example.navbarlicenta.modal.SingletonEnum;

import java.util.List;

public class HomeFragment extends Fragment {

    private EditText email, password;
    public int idFromDatabase = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Button button_home_login = root.findViewById(R.id.home_button_login);
        TextView button_home_register = root.findViewById(R.id.home_register_button);
        TextView button_home_login_admin = root.findViewById(R.id.home_adminlogin_button);
        TextView button_home_forgotpass = root.findViewById(R.id.home_forgot_pass_button);

        email = root.findViewById(R.id.home_email);
        password = root.findViewById(R.id.home_password);

        AppDatabase db = AppDatabase.getDbInstance(getActivity().getApplicationContext());

        button_home_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String home_email = email.getText().toString();
                String home_password = password.getText().toString();
                List<User> users = db.userDAO().getAll();
                int idFromDatabase = 0;
                boolean checkAccount = false;

                for (User u : users) {
                    if (u.email.equals(home_email) && u.password.equals(home_password)) {
                        checkAccount = true;
                        idFromDatabase = u.getId_user();
                    }
                }

                if (!checkAccount)
                    Toast.makeText(getActivity(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                else {
                    SingletonEnum.INSTANCE.setValue(idFromDatabase);
                    Navigation.findNavController(root).navigate(R.id.nav_login);
                }
            }
        });

        button_home_login_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String home_password = password.getText().toString();
                List<User> users = db.userDAO().getAll();
                boolean checkAdminAccount = false;

                for (User u : users) {
                    if (u.email.equals("administrator@poiana.com") && u.password.equals(home_password)) {
                        checkAdminAccount = true;
                        idFromDatabase = u.getId_user();
                    }
                    break;
                }

                if (!checkAdminAccount)
                    Toast.makeText(getActivity(), "Wrong Admin Password", Toast.LENGTH_SHORT).show();
                else {
                    SingletonEnum.INSTANCE.setValue(idFromDatabase);
                    Navigation.findNavController(root).navigate(R.id.nav_admin);
                }
            }
        });

        button_home_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.nav_register);
            }
        });

        button_home_forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(root).navigate(R.id.nav_forgot);
            }
        });


        return root;
    }
}