package com.faculdade.buddyride.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.faculdade.buddyride.R;

//something
public class FavoritesActivity extends AppCompatActivity {

    private ListView mListview;
    private ImageView mPlusButton;
    private ImageView mArrowBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        mListview = findViewById(R.id.listview_favorites);
        mPlusButton = findViewById(R.id.button_plus);
        mArrowBack = findViewById(R.id.arrow_back);

        //Linking to the "AddFavorites" activity
        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FavoritesActivity.this, AddFavoritesActivity.class));
            }
        });

        //Going back to the previous activity
        mArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
