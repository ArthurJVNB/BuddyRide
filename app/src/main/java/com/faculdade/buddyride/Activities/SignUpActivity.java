package com.faculdade.buddyride.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.faculdade.buddyride.R;

public class SignUpActivity extends AppCompatActivity {

    private TextView mFirstName;
    private TextView mLastname;
    private TextView mDateOfBirth;
    private TextView mEmail;
    private TextView mPassword;
    private TextView mConfirmPassword;
    private TextView mSecretQuestion;
    private TextView mSecretAnswer;
    private ImageView mConfirmButton;
    private ImageView mArrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirstName = findViewById(R.id.name_field);
        mLastname = findViewById(R.id.lastname_field);
        mDateOfBirth = findViewById(R.id.birthday_field);
        mEmail = findViewById(R.id.email_field);
        mPassword = findViewById(R.id.password_field);
        mConfirmPassword = findViewById(R.id.confirmPassword_field);
        mSecretQuestion = findViewById(R.id.secretQuestion_field);
        mSecretAnswer = findViewById(R.id.secretAnswer_field);
        mConfirmButton = findViewById((R.id.button_Confirm));
        mArrowBack = findViewById(R.id.button_arrowBack);

        //Navigating between SignUpActivity and MainActivity
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        });

        //Going back to the previous Activity
        mArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
