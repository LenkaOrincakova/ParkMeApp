package com.example.parkme;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkme.ui.cars.MyCarsActivity;
import com.example.parkme.ui.home.HomeFragment;
import com.example.parkme.ui.search.Search;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;

public class homeActivity extends AppCompatActivity
//        implements OnMapReadyCallback
{



    SearchView searchView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_profile, R.id.navigation_favourites)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationUI.setupWithNavController(navView, navController);

        searchView = findViewById(R.id.searchView);
        navigationView.setNavigationItemSelectedListener((item) ->
        {
            switch (item.getItemId()) {
                case R.id.nav_search:
                    Intent intent = new Intent(homeActivity.this, Search.class);
                    startActivity(intent);
                    break;
                case R.id.MyCars:
                    Intent intent2 = new Intent(homeActivity.this, MyCarsActivity.class);
                    startActivity(intent2);
                    break;

            }
            return true;
        });
        //google maps
//
    }

    @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            if (toggle.onOptionsItemSelected(item)) {
                return true;
            }
            return true;



    }
}