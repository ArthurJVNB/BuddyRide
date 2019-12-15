package com.faculdade.buddyride.Entities;

import com.google.android.gms.maps.model.LatLng;

public class Address {
    private LatLng latitudeLongitude;
    private String addressNickname;

    public Address(LatLng latitudeLongitude) {
        this.latitudeLongitude = latitudeLongitude;
        // TODO automated pick of addressNickname (maybe via GoogleMaps)
        this.addressNickname = "AUTOMATED NAME";
    }

    public Address(LatLng latitudeLongitude, String addressNickname) {
        this.latitudeLongitude = latitudeLongitude;
        this.addressNickname = addressNickname;
    }

    public LatLng getLatitudeLongitude() {
        return latitudeLongitude;
    }

    public String getAddressNickname() {
        return addressNickname;
    }
}