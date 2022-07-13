package com.example.navbarlicenta.ui.register;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
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
import com.example.navbarlicenta.SQL.user.User;
import com.example.navbarlicenta.modal.SingletonEnum;

import java.util.regex.Pattern;

public class RegisterFragment extends Fragment {

    private RegisterViewModel registerViewModel;
    private EditText et_fname, et_lname, et_email, et_phone, et_passw, et_cnfpassw;
    private Button button_signup;
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
        registerViewModel =
                new ViewModelProvider(this).get(RegisterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_register, container, false);


        final TextView textView = root.findViewById(R.id.text_singin);
        registerViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        button_signup = root.findViewById(R.id.button_register_signup);
        et_fname = root.findViewById(R.id.editText_signin_fname);
        et_lname = root.findViewById(R.id.editText_signin_lname);
        et_email = root.findViewById(R.id.editText_signin_email);
        et_phone = root.findViewById(R.id.editText_signin_phone);
        et_passw = root.findViewById(R.id.editText_signin_password);
        et_cnfpassw = root.findViewById(R.id.editText_signin_confPassw);

        et_fname.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        et_lname.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);


        button_signup.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                AppDatabase db = AppDatabase.getDbInstance(getActivity().getApplicationContext());

                String first_name = et_fname.getText().toString();
                String last_name = et_lname.getText().toString();
                String email = et_email.getText().toString();
                String phone = et_phone.getText().toString();
                String password = et_passw.getText().toString();
                String confirm_password = et_cnfpassw.getText().toString();

                int idFromDatabase = 0;

                if (first_name.equals("") || last_name.equals("") || email.equals("") || phone.equals("") || password.equals("") || confirm_password.equals(""))
                    Toast.makeText(getActivity(), "Please fill in all fields!", Toast.LENGTH_SHORT).show();
                else if (!password.equals(confirm_password))
                    Toast.makeText(getActivity(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
                else if (Patterns.EMAIL_ADDRESS.matcher(email).matches() == false)
                    Toast.makeText(getActivity(), "Email is not valid!", Toast.LENGTH_SHORT).show();
                else if (!PASSWORD_PATTERN.matcher(password).matches())
                    Toast.makeText(getActivity(), "Password is to weak", Toast.LENGTH_SHORT).show();
                else {
                    saveNewUser(first_name, last_name, email, phone, password);

                    idFromDatabase = db.userDAO().findIDbyEmail(email);
                    SingletonEnum.INSTANCE.setValue(idFromDatabase);
                    Toast.makeText(getActivity(), "User successfully created!", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(root).navigate(R.id.nav_login);
                }
            }
        });

        return root;
    }

    private void saveNewUser(String first_name, String last_name, String email, String phone, String password) {
        AppDatabase db = AppDatabase.getDbInstance(getActivity().getApplicationContext());

        User user = new User();
        user.fName = first_name;
        user.lName = last_name;
        user.email = email;
        user.phone = phone;
        user.password = password;

        db.userDAO().insertAll(user);
    }

}
