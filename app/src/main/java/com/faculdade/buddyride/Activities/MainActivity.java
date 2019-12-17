package com.faculdade.buddyride.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.faculdade.buddyride.Entities.LoggedUser;
import com.faculdade.buddyride.R;
import com.faculdade.buddyride.TestActivities.TestActivity;

public class MainActivity extends AppCompatActivity {


    private Button buttonTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(LoggedUser.id == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

        buttonTeste = findViewById(R.id.buttonTeste);

        buttonTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });

    }
}