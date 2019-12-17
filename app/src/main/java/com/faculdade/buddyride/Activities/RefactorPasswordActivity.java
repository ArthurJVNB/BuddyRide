package com.faculdade.buddyride.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.faculdade.buddyride.Controllers.Facade;
import com.faculdade.buddyride.Entities.LoggedUser;
import com.faculdade.buddyride.R;

public class RefactorPasswordActivity extends AppCompatActivity {

    private TextView mPassword;
    private TextView mConfirmPassword;
    private ImageView mButtonConfirm;
    private ImageView mArrowBack;
    private Facade facade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refactor_password);

        mPassword = findViewById(R.id.password_field);
        mConfirmPassword = findViewById(R.id.confirmPassword_field);
        mButtonConfirm = findViewById(R.id.button_confirm);
        mArrowBack = findViewById(R.id.button_arrowBack);
        facade = Facade.getInstance();

        final String catchPassword = mPassword.getText().toString();
        String catchConfirmPassword = mConfirmPassword.getText().toString();

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
                facade.changeUserPassword(LoggedUser.id, catchPassword);

                //Navigating between RefactorPasswordActivity and MainActivity
                startActivity(new Intent(RefactorPasswordActivity.this, MainActivity.class));
            }
        });
    }
}
