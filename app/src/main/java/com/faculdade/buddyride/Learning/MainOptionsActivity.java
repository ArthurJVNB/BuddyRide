package com.faculdade.buddyride.Learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.faculdade.buddyride.Activities.FavoritesActivity;
import com.faculdade.buddyride.Activities.NotAvailableActivity;
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
        mContactUs_button.findViewById(R.id.button_contact_us);
        mPrivacyPolicy_button.findViewById(R.id.button_privacy_policy);
        mAboutUs_button.findViewById(R.id.button_about_us);
        mFavorites_button.findViewById(R.id.button_favorites);
        mHistory_button.findViewById(R.id.button_history);

        mFavorites_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainOptionsActivity.this, FavoritesActivity.class));
            }
        });

        mContactUs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainOptionsActivity.this, NotAvailableActivity.class));
            }
        });

        mPrivacyPolicy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainOptionsActivity.this, NotAvailableActivity.class));
            }
        });

        mProfile_button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainOptionsActivity.this, NotAvailableActivity.class));
            }
        }));

        mAboutUs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainOptionsActivity.this, NotAvailableActivity.class));
            }
        });

        mHistory_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainOptionsActivity.this, NotAvailableActivity.class));
            }
        });
    }
}
