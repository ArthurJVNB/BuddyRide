package com.faculdade.buddyride.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.faculdade.buddyride.R;

public class AddFavoritesActivity extends AppCompatActivity {

    private ImageView mArrowBack;
    //private TextView mAddress;
    private TextView mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_favorites);

        mArrowBack = findViewById(R.id.arrow_back);

        mArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
