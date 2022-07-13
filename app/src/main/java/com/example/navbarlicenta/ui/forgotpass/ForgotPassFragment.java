package com.example.navbarlicenta.ui.forgotpass;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navbarlicenta.R;
import com.example.navbarlicenta.SQL.AppDatabase;
import com.example.navbarlicenta.SQL.user.User;
import com.example.navbarlicenta.ui.home.HomeViewModel;

import java.util.List;
import java.util.regex.Pattern;

public class ForgotPassFragment extends Fragment {

    private EditText email, password, conf_pass;
    private Button resetPass;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 8 characters
                    "$");

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ForgotPassViewModel forgotPassViewModel = new ViewModelProvider(this).get(ForgotPassViewModel.class);
        View root = inflater.inflate(R.layout.fragment_forgot_pass, container, false);

        final TextView textView = root.findViewById(R.id.text_forgot_pass);
        forgotPassViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        email = root.findViewById(R.id.editText_forgot_email);
        password = root.findViewById(R.id.editText_forgot_pass);
        conf_pass = root.findViewById(R.id.editText_forgot_cpass);
        resetPass = root.findViewById(R.id.button_reset_pass);

        AppDatabase db = AppDatabase.getDbInstance(getActivity().getApplicationContext());

        resetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_email = email.getText().toString();
                String user_pass = password.getText().toString();
                String user_cpass = conf_pass.getText().toString();

                List<User> users = db.userDAO().getAll();

                for (User u : users) {
                    if (u.email.equals(user_email)) {
                        try {
                            if (user_pass.equals("") || conf_pass.equals(""))
                                Toast.makeText(getActivity(), "Please fill in all fields!", Toast.LENGTH_SHORT).show();
                            else if (!user_pass.equals(user_cpass))
                                Toast.makeText(getActivity(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
                            else if (!Patterns.EMAIL_ADDRESS.matcher(user_email).matches())
                                Toast.makeText(getActivity(), "Email is not valid!", Toast.LENGTH_SHORT).show();
                            else if (!PASSWORD_PATTERN.matcher(user_pass).matches())
                                Toast.makeText(getActivity(), "Password is to weak", Toast.LENGTH_SHORT).show();
                            else {
                                db.userDAO().updatePass(user_pass, user_email);
                                Toast.makeText(getActivity(), "Password successfully updated!", Toast.LENGTH_SHORT).show();
                                Navigation.findNavController(root).navigate(R.id.nav_login);
                            }
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), "User does not exist in the database!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        return root;
    }
}