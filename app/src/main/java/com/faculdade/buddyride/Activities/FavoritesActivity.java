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

        /*//Creating instance of a class MyAdapter
        FavoritesActivity.MyAdapter adapter = new MyAdapter(this, titles, imgs, sources);

        //set Adapter to list
        listview.setAdapter(adapter);*/
    }

  /*  class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myTitles[];
        String mySources[];
        int [] imgs;

        MyAdapter(Context c, String[] titles, int[] imgs, String [] sources){
            super(c, R.layout.row_listview, R.id.text_title, titles);
            this.context = c;
            this.imgs = imgs;
            this.myTitles = titles;
            this.mySources = sources;
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row_listView = layoutInflater.inflate(R.layout.row_listview, parent, false);
            ImageView images = row_listView.findViewById(R.id.photo_album);
            TextView myTitle = row_listView.findViewById(R.id.text_title);
            TextView mySources = row_listView.findViewById(R.id.text_source);
            images.setImageResource(imgs[position]);
            myTitle.setText(titles[position]);
            mySources.setText(sources[position]);

            return row_listView;
        }
    }*/
}
