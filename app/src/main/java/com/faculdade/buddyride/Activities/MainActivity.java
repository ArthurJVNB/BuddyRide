package com.faculdade.buddyride.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.faculdade.buddyride.Entities.LoggedUser;
import com.faculdade.buddyride.R;
import com.faculdade.buddyride.TestActivities.TestActivity;

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
                    Manifest.permission.INTERNET, Manifest.permission.ACCESS_FINE_LOCATION}, 2);
        } else {
            showToast("Version less than Marshmallow!!!");
        }

    }

    //TOAST MESSAGE
    private void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }



}