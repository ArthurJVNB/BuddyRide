package com.faculdade.buddyride.Activities;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.faculdade.buddyride.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private TextView mEmail;
    private TextView mPassword;
    private TextView mForgotPassword;
    private TextView mSignUp;
    private Button mSingIn;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mFireBaseAthListener;

    /*
     * FirebaseAuth.AuthStateListener is called when there is a change in the authentication state
     * Right after the listener has been registered, when a user is signed in, when a current user
     * is signed out, when the current user changes
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        mFireBaseAthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                //This variable stores information about the current logged user

                if(user != null){
                    Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                    //startActivity();
                    //finish();
                    return;
                }

            }
        };


    }
}
