package com.faculdade.buddyride.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.faculdade.buddyride.R;

public class SecretQuestionActivity extends AppCompatActivity {


    private TextView mSecretQuestion;
    private TextView mSecretAnswer;
    private ImageView mButtonConfirm;
    private ImageView mArrowBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refactor_password);

        mSecretQuestion = findViewById(R.id.secretQuestionText);
        mSecretAnswer = findViewById(R.id.secretAnswer_field);
        mButtonConfirm = findViewById(R.id.button_Confirm);
        mArrowBack = findViewById(R.id.button_arrowBack);

        //Going back to the previous Activity
        mArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //TODO:Take the secret question of the database and display on TextView

        mButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Logic of SecretAnswer
                //TODO: Logic  if answer is right take to activity of changing password
            }
        });
    }
}
