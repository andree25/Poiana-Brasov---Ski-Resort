package com.example.navbarlicenta;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_rules, R.id.nav_slopes, R.id.nav_chairlifts,
                R.id.nav_passes, R.id.nav_rentals, R.id.nav_hotels)
                .setDrawerLayout(drawer)
                .build();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    //webcams

    public void browser1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=577McZRl6Yw"));
        startActivity(browserIntent);
    }

    public void browser2(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.webcamromania.ro/b3p4l5g5v534o23303"));
        startActivity(browserIntent);
    }

    public void browser3(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.webcamromania.ro/b3p4l5g5v534o233z2"));
        startActivity(browserIntent);
    }

    public void browser4(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.webcamromania.ro/b3p4l5g5v534o233x2"));
        startActivity(browserIntent);
    }

    public void browser5(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.webcamromania.ro/b3p4l5g5v534o233y2"));
        startActivity(browserIntent);
    }

    public void browser6(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=RU95EHwyVNE"));
        startActivity(browserIntent);
    }

    public void browser7(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://jurnalul.ro/webcam/poiana-brasov-bradul-419.html"));
        startActivity(browserIntent);
    }

    public void browser8(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://jurnalul.ro/webcam/poiana-brasov-postavarul-424.html"));
        startActivity(browserIntent);
    }

    //hotels

    public void browserHotDen(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.poiana-brasov.ro/cazare/hoteluri/denisa-boutique-hotel.html"));
        startActivity(browserIntent);
    }

    public void browserHotAlp(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hotelalpin.ro/en/"));
        startActivity(browserIntent);
    }

    public void browserHotAna(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.anahotels.ro/sporthotel/en/"));
        startActivity(browserIntent);
    }

    public void browserHotAur(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://brasov.imparatulromanilor.ro/en/"));
        startActivity(browserIntent);
    }

    public void browserHotDracula(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://house-of-dracula.com/"));
        startActivity(browserIntent);
    }

    public void browserHotEsc(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://escalade.ro/en/home/"));
        startActivity(browserIntent);
    }

    public void browserHotMir(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hotelnewbelvedere.ro/poianabrasov/"));
        startActivity(browserIntent);
    }

    public void browserHotOri(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pensiunea-orizont.ro/"));
        startActivity(browserIntent);
    }

    public void browserHotRizz(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.rizzohotel.ro/en/"));
        startActivity(browserIntent);
    }

    public void browserHotTele(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.telefericgrandhotel.ro/en/"));
        startActivity(browserIntent);
    }

    public void browserHotCris(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hotelcrisalpin.ro/"));
        startActivity(browserIntent);
    }

    public void browserHotRuia(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hotelruia.ro/en/hotel-ruia-poiana-brasov-2/"));
        startActivity(browserIntent);
    }

    public void browserHotVing(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.casavinga.ro/"));
        startActivity(browserIntent);
    }

    //rentals

    public void browser_rentals_alpin(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://alpinskiacademy.ro/en/echipa/"));
        startActivity(browserIntent);
    }

    public void browser_rentals_eden(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://edenski.ro/en/"));
        startActivity(browserIntent);
    }

    public void browser_rentals_interski(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://interski-romania.ro/"));
        startActivity(browserIntent);
    }

    public void browser_rentals_outdoor(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.outdoorfun.ro/en/"));
        startActivity(browserIntent);
    }

    public void browser_rentals_rj(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.scoalaski.ro/en/"));
        startActivity(browserIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}