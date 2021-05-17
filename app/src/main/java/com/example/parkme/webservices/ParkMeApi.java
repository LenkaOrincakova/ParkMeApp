package com.example.parkme.webservices;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ParkMeApi {

    @GET("2b093aec-d2d2-4bad-af57-e6a939c89b2d")
    Call<List<ParkingSpotResponse>> getAllParkingSpots();
}
