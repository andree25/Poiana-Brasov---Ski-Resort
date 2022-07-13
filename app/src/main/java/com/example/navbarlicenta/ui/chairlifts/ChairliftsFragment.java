package com.example.navbarlicenta.ui.chairlifts;

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
import android.widget.TextView;

import com.example.navbarlicenta.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ChairliftsFragment extends Fragment {

    FloatingActionButton buton_lift_bradu, button_lift_subteleferic, buton_lift_lupuluiDown,
            buton_lift_kanzel, button_lift_ruia, button_lift_lupuluiUp, buton_lift_jos,
            buton_lift_ana, button_lift_capraneagra, buton_slope_subteleferic,
            buton_slope_sulinar, buton_slope_lupului, buton_slope_drosu;

    TextView textView1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ChairliftsViewModel chairliftsViewModel = new ViewModelProvider(this).get(ChairliftsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_chairlifts, container, false);
        final TextView textView = root.findViewById(R.id.text_chairlifts);

        buton_lift_bradu = root.findViewById(R.id.buton_bradu);
        button_lift_subteleferic = root.findViewById(R.id.button_subteleferic);
        buton_lift_lupuluiDown = root.findViewById(R.id.buton_lupuluiJ);
        buton_lift_kanzel = root.findViewById(R.id.buton_kanzel);
        button_lift_ruia = root.findViewById(R.id.button_ruia);
        button_lift_lupuluiUp = root.findViewById(R.id.button_lupuluiS);
        buton_lift_jos = root.findViewById(R.id.buton_jos);
        buton_lift_ana = root.findViewById(R.id.buton_ana);
        button_lift_capraneagra = root.findViewById(R.id.button_capraneagra);

        buton_slope_sulinar = root.findViewById(R.id.buton_slope_sulinar);
        buton_slope_drosu = root.findViewById(R.id.buton_slope_drosu);
        buton_slope_lupului = root.findViewById(R.id.buton_slope_lupului);
        buton_slope_subteleferic = root.findViewById(R.id.buton_slope_subteleferic);


        textView1 = root.findViewById(R.id.textView29);

        chairliftsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        buton_lift_bradu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Ski Lift Bradul");
            }
        });

        button_lift_subteleferic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Ski Lift Subteleferic");
            }
        });

        buton_lift_lupuluiDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Chairlift Lupului");
            }
        });

        buton_lift_kanzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Ski Lift Kanzel");
            }
        });

        button_lift_ruia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Ski Lift Ruia");
            }
        });

        button_lift_lupuluiUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Chairlift Ruia");
            }
        });

        buton_lift_jos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Ski Lift Stadion");
            }
        });

        buton_lift_ana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Cable car Kanzel & Gondola Postavarul Express");
            }
        });

        button_lift_capraneagra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Cable car Capra Neagra");
            }
        });

        buton_slope_subteleferic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Subteleferic Slope");
            }
        });

        buton_slope_sulinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Sulinar Slope");
            }
        });

        buton_slope_lupului.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Lupului Slope");
            }
        });

        buton_slope_drosu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Drumul Rosu Slope");
            }
        });

        return root;
    }

}