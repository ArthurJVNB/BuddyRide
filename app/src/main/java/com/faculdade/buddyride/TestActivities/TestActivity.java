package com.faculdade.buddyride.TestActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.faculdade.buddyride.R;

public class TestActivity extends AppCompatActivity {

    private Button mLogin;
    private Button mLogon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mLogin = findViewById(R.id.test_login);
        mLogon = findViewById(R.id.test_logon);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TestLoginActivity.class);
                startActivity(intent);
            }
        });

        mLogon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TestLogonActivity.class);
                startActivity(intent);
            }
        });
    }
}
