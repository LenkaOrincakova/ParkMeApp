package com.example.parkme.webservices;


import android.app.Application;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotRepository {

    private static ParkingSpotRepository instance;
    private final MutableLiveData<List<ParkingSpot>> parkingSpotMutableLiveData;

    private ParkingSpotRepository(Application application) {
        parkingSpotMutableLiveData = new MutableLiveData<>();
    }

    public static synchronized ParkingSpotRepository getInstance(Application application) {
        if (instance == null) {
            instance = new ParkingSpotRepository(application);
        }
            return instance;

    }


    public LiveData<List<ParkingSpot>> getParkingSpotsMutableLiveData()
    {
        return parkingSpotMutableLiveData;

    }


    public void setParkingSpotsMutableLiveData()
    {
        ParkMeApi parkMeApi = ServiceGenerator.getParkMeApi();
        Call<List<ParkingSpotResponse>> call = parkMeApi.getAllParkingSpots();

        call.enqueue(new Callback<List<ParkingSpotResponse>>()
        {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<ParkingSpotResponse>> call, Response<List<ParkingSpotResponse>> response) {

                ArrayList<ParkingSpotResponse> parkingSpotResponses = new ArrayList<>(response.body());
                ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
                for(ParkingSpotResponse parkingSpotResponse : parkingSpotResponses)
                {
                    parkingSpots.add(parkingSpotResponse.getParkingSpot());
                }


               parkingSpotMutableLiveData.setValue(parkingSpots);


//                    System.out.println(parkingSpots + "response: " + response);
                }


            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<ParkingSpotResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something got wrong", t);
            }

        });
    }

}
