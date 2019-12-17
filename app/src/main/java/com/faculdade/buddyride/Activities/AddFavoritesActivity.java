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
import com.faculdade.buddyride.Entities.LoggedUser;
import com.faculdade.buddyride.Exceptions.FavoritesControllerException;
import com.faculdade.buddyride.Helpers.ToastHelper;
import com.faculdade.buddyride.R;
import com.google.android.gms.maps.model.LatLng;

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

                //teste
                LatLng teste = new LatLng(-8.041191,-34.959247);

                //Catch input data
                String catchDescription = mDescription.getText().toString();
                String catchAddress = mAddress.getText().toString();

                if(catchAddress.isEmpty()){
                    ToastHelper.showToast(getApplicationContext(), getString(R.string.invalid_field));

                }else{
                    //Save data
                    FavoriteAddress favorite = new FavoriteAddress(teste,catchDescription, LoggedUser.id);

                    try {
                        facade.registerFavoriteAddress(favorite);
                    } catch (FavoritesControllerException e) {

                        String message = e.getMessage();
                        if (message.equals(FavoritesControllerException.EnumExceptionType.INVALID_USER.toString())) {
                            // TODO avisar que houve algum problema com usuario (talvez pedir pra fazer login de novo)
                        } else {
                            // TODO avisar que algo muito estranho aconteceu
                        }
                    }
                    startActivity(new Intent(AddFavoritesActivity.this, MainActivity.class));
                }

            }
        });
    }
}
