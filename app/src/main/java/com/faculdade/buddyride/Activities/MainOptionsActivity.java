package com.faculdade.buddyride.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.faculdade.buddyride.R;

public class MainOptionsActivity extends AppCompatActivity {

    private ImageView mProfile_button;
    private ImageView mContactUs_button;
    private ImageView mPrivacyPolicy_button;
    private ImageView mAboutUs_button;
    private ImageView mFavorites_button;
    private ImageView mHistory_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_options);

        mProfile_button.findViewById(R.id.button_profile);
    }
}
