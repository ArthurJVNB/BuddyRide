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
import com.faculdade.buddyride.Exceptions.UserControllerException;
import com.faculdade.buddyride.Helpers.ToastHelper;
import com.faculdade.buddyride.R;

public class SecretQuestionActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mSecretQuestion;
    private EditText mSecretAnswer;
    private ImageView mButtonConfirm;
    private ImageView mArrowBack;
    private Facade facade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_question);

        mEmail = findViewById(R.id.email_field);
        mSecretQuestion = findViewById(R.id.secret_question_field);
        mSecretAnswer = findViewById(R.id.secretAnswer_field);
        mButtonConfirm = findViewById(R.id.button_confirm);
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
                facade = Facade.getInstance();
                try {
                    boolean isRight = facade.checkUserSecretAnswer(mEmail.getText().toString(), mSecretQuestion.getText().toString(), mSecretAnswer.getText().toString());
                    //TODO: Logic  if answer is right take to activity of changing password
                    if (isRight) {
                        Intent intent = new Intent(getApplicationContext(), RefactorPasswordActivity.class);
                        intent.putExtra("userId", mEmail.getText().toString());

                        startActivity(intent);
                    }
                } catch (UserControllerException e) {
                    ToastHelper.showToast(getApplicationContext(), getString(R.string.user_doesnt_exist));
                }
            }
        });
    }
}
