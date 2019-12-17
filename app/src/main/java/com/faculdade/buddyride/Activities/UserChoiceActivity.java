package com.faculdade.buddyride.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.faculdade.buddyride.Controllers.Facade;
import com.faculdade.buddyride.Entities.LoggedUser;
import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.R;

public class UserChoiceActivity extends AppCompatActivity {

    private Button mDriver;
    private Button mPassenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);

        //TODO:Logic of User driver and user passenger

        mDriver = findViewById(R.id.buttonDriver);
        mPassenger = findViewById(R.id.buttonPassenger);

        mDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Facade facade = Facade.getInstance();
                facade.setUserStatus(LoggedUser.id, User.Status.DRIVER);
                startActivity(new Intent(UserChoiceActivity.this, MainActivity.class));

            }
        });

        mPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Facade facade = Facade.getInstance();
                facade.setUserStatus(LoggedUser.id, User.Status.PASSENGER);
                startActivity(new Intent(UserChoiceActivity.this, MainActivity.class));
            }
        });
    }
}