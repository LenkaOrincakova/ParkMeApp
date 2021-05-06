package com.example.parkme.webservices;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ParkMeApi {

    @GET("opendata/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=opendata:open_vej_p_registrering_view&outputFormat=json")
    Call<List<ParkingSpotResponse>> getAllParkingSpots();
}
