package com.faculdade.buddyride.Entities;

import com.google.android.gms.maps.model.LatLng;

public class FavoriteAddress {
    // Os atributos que estao como "final" eh porque nunca sao alterados.
    // Portanto para garantir isso, foi escolhido essa caracteristica.
    private final LatLng latitudeLongitude;
    private final String userId;
    private String addressNickname;

    public FavoriteAddress(LatLng latitudeLongitude, String addressNickname, String userId) {
        this.latitudeLongitude = latitudeLongitude;
        this.addressNickname = addressNickname;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public String getId() {
        // forma temporaria de ID
        return addressNickname;
    }
}