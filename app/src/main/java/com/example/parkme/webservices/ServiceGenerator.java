package com.example.parkme.webservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://geoservice.horsens.dk") //https://geoservice.horsens.dk/opendata/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=opendata:open_vej_p_registrering_view&outputFormat=json
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static ParkMeApi parkMeApi = retrofit.create(ParkMeApi.class);

    public static ParkMeApi getParkMeApi()
    {
        return parkMeApi;
    }

}
