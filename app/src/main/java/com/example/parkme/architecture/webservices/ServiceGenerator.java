package com.example.parkme.architecture.webservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static ParkMeApi parkMeApi;
    public static ParkMeApi getParkMeApi()
    {
        if(parkMeApi == null)
        {
            parkMeApi = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ParkMeApi.class);
        }
        return parkMeApi;
    }


}
