package com.faculdade.buddyride.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.faculdade.buddyride.Controllers.Facade;
import com.faculdade.buddyride.Entities.LoggedUser;
import com.faculdade.buddyride.Helpers.ToastHelper;
import com.faculdade.buddyride.R;

public class RefactorPasswordActivity extends AppCompatActivity {

    private EditText mPassword;
    private EditText mConfirmPassword;
    private ImageView mButtonConfirm;
    private ImageView mArrowBack;
    private Facade facade;

    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refactor_password);

        mPassword = findViewById(R.id.password_field);
        mConfirmPassword = findViewById(R.id.confirm_password_field);
        mButtonConfirm = findViewById(R.id.button_confirm);
        mArrowBack = findViewById(R.id.button_arrowBack);

        facade = Facade.getInstance();

        // Getting userId
        userId = getIntent().getStringExtra("userId");

        //Going back to the LoginActivity
        mArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RefactorPasswordActivity.this, LoginActivity.class));
            }
        });

        mButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = mPassword.getText().toString();
                String confirmPassword = mConfirmPassword.getText().toString();

                if (password.equals(confirmPassword)) {
                    facade.changeUserPassword(userId, mPassword.getText().toString());
                    ToastHelper.showToast(getApplicationContext(), getString(R.string.password_change_success));
                    //Navigating between RefactorPasswordActivity and MainActivity
                    startActivity(new Intent(RefactorPasswordActivity.this, MainActivity.class));
                } else {
                    ToastHelper.showToast(getApplicationContext(), getString(R.string.passwords_must_match));
                }
            }
        });
    }
}
