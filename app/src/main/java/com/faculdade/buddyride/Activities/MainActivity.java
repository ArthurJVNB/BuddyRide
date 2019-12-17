package com.faculdade.buddyride.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.faculdade.buddyride.ApiKey;
import com.faculdade.buddyride.Entities.LoggedUser;
import com.faculdade.buddyride.Helpers.ToastHelper;
import com.faculdade.buddyride.R;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    private ImageView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(LoggedUser.id == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }



        grid = findViewById(R.id.grid_icon);

        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainOptionsActivity.class));
            }
        });

        //PERMISSION: Asking permission to access camera and internal storage
        if(Build.VERSION.SDK_INT >= 23){
            requestPermissions(new String[]{
                    Manifest.permission.INTERNET, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            showToast("Version less than Marshmallow!!!");
        }

        // -------------------------- PLACES API --------------------------
        // Initializing Places API
        Places.initialize(getApplicationContext(), ApiKey.getApiKey());
        PlacesClient placesClient = Places.createClient(this);

        // Initialize AutocompleteSupportFragment
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment) getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Specify the types of place data to return
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        // Set up a PlaceSelectionListener to handle the responde
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                // TODO aqui devemos pegar a informacao sobre o local selecionado da lista
                ToastHelper.showToast(getApplicationContext(), place.getAddress());
            }

            @Override
            public void onError(@NonNull Status status) {
                // TODO deveria tratar o erro, mas nao faco ideia do que colocar aqui
            }
        });
    }

    //TOAST MESSAGE
    private void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }



}