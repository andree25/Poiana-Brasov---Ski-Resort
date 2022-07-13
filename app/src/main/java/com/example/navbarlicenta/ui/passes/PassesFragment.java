package com.example.navbarlicenta.ui.passes;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.navbarlicenta.R;

import org.w3c.dom.Text;

public class PassesFragment extends Fragment {

    private PassesViewModel passesViewModel;
    TextView button_passes_points;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        passesViewModel =
                new ViewModelProvider(this).get(PassesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_passes, container, false);

        final TextView textView = root.findViewById(R.id.text_passes);

        passesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        button_passes_points = root.findViewById(R.id.passes_button_points);

        button_passes_points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.nav_home);
            }
        });



        return root;
    }
}

