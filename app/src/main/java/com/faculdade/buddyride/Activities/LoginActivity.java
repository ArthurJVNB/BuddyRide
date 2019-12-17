package com.faculdade.buddyride.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.faculdade.buddyride.R;


public class LoginActivity extends AppCompatActivity {

    private TextView mEmail;
    private TextView mPassword;
    private TextView mForgotPassword;
    private TextView mSignUp;
    private ImageView mSingIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSingIn = findViewById(R.id.button_signIn);
        mSignUp = findViewById(R.id.textButton_singup);
        mEmail = findViewById(R.id.email_field);
        mPassword = findViewById(R.id.password_field);
        mForgotPassword = findViewById(R.id.textButtonForgotPassword);


        //Navigating between LoginActivity and MainActivity
        mSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String catchEmail = mEmail.getText().toString();
                String catchPassword = mPassword.getText().toString();

                //TODO: Se usuário não existe no ArrayList exibir um Toast!
                //TODO: Se senha estiver errada exibir um Toast!

               //If some of the fields are empty, it'll show a toast message
                if(catchEmail.isEmpty() || catchPassword.isEmpty()){
                    showToast("Empty field. Try again.");
                }else{
                    //Do login
                    startActivity(new Intent(LoginActivity.this, UserChoiceActivity.class));
                }

            }
        });

        //Navigating between LoginActivity and SignUpActivity
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });


        //Navigating between LoginActivity and RefactorPasswordActivity
        mForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SecretQuestionActivity.class));
            }
        });

    }//closing onCreate



    private void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }


}; //closing class



