package com.faculdade.buddyride.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.faculdade.buddyride.Controllers.Facade;
import com.faculdade.buddyride.Entities.FavoriteAddress;
import com.faculdade.buddyride.R;

public class AddFavoritesActivity extends AppCompatActivity {

    private ImageView mArrowBack;
    private ImageView mConfirmButton;
    private TextView mDescription;
    private TextView mAddress;
    private Facade facade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_favorites);

        mArrowBack = findViewById(R.id.arrow_back);
        mConfirmButton = findViewById(R.id.button_confirm);
        mDescription = findViewById(R.id.description_field);
        mAddress = findViewById(R.id.address_field);

        mArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Catch input data

                String catchDescription = null;
                catchDescription = mDescription.getText().toString();
                String catchAddress = mAddress.getText().toString();

                if(catchAddress.isEmpty()){
                    showToast("Invalid field. Try again.");

                }else{
                    //Save data
                    FavoriteAddress favorite = new FavoriteAddress(catchDescription);
                    facade.registerFavoriteAddress(favorite);
                    startActivity(new Intent(AddFavoritesActivity.this, MainActivity.class));
                }

            }
        });
    }

    //TOAST MESSAGE
    private void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
