package com.faculdade.buddyride.Entities;

import com.google.android.gms.maps.model.LatLng;

public class FavoriteAddress {
    // Os atributos que estao como "final" eh porque nunca sao alterados.
    // Portanto para garantir isso, foi escolhido essa caracteristica.
    private final LatLng latitudeLongitude;
    private final String userEmail;
    private String addressNickname;

    public FavoriteAddress(LatLng latitudeLongitude, String addressNickname, String userEmail) {
        this.latitudeLongitude = latitudeLongitude;
        this.addressNickname = addressNickname;
        this.userEmail = userEmail;
    }

    public LatLng getLatitudeLongitude() {
        return latitudeLongitude;
    }

    public String getAddressNickname() {
        return addressNickname;
    }

    public void setAddressNickname(String addressNickname) {
        this.addressNickname = addressNickname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getId() {
        // forma temporaria de ID
        return addressNickname;
    }
}