package com.faculdade.buddyride.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.faculdade.buddyride.Controllers.Facade;
import com.faculdade.buddyride.Entities.LoggedUser;
import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.Exceptions.UserControllerException;
import com.faculdade.buddyride.Helpers.ToastHelper;
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
        mConfirmButton = findViewById((R.id.button_confirm));
        mArrowBack = findViewById(R.id.button_arrowBack);


        //Navigating between SignUpActivity and MainActivity
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String catchFirstName = mFirstName.getText().toString();
                String catchLastname = mLastname.getText().toString();
                String catchDateOfBirth = mDateOfBirth.getText().toString();
                String catchEmail = mEmail.getText().toString();
                String catchPassword = mPassword.getText().toString();
                String catchConfirmPassword = mConfirmPassword.getText().toString();
                String catchSecretQuestion = mSecretQuestion.getText().toString();
                String catchSecretAnswer = mSecretAnswer.getText().toString();

                if(catchFirstName.isEmpty() || catchLastname.isEmpty() || catchDateOfBirth.isEmpty()
                        || catchEmail.isEmpty() || catchPassword.isEmpty() || catchConfirmPassword.isEmpty()
                        || catchSecretQuestion.isEmpty() || catchSecretAnswer.isEmpty()){

                    ToastHelper.showToast(getApplicationContext(), getString(R.string.empty_field));

                } else if (!catchPassword.equals(catchConfirmPassword)){
                    ToastHelper.showToast(getApplicationContext(), getString(R.string.invalid_field));

                } else {
                    User user = new User(catchFirstName, catchLastname, catchDateOfBirth, catchEmail, catchPassword, catchSecretQuestion, catchSecretAnswer);

                    Facade facade = Facade.getInstance();
                    try {
                        facade.registerUser(user);
                        facade.loginUser(catchEmail, catchPassword);
                        startActivity(new Intent(getApplicationContext(), UserChoiceActivity.class));
                    } catch (UserControllerException e) {
                        ToastHelper.showToast(getApplicationContext(), "User already exists");
                    }
                }
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
