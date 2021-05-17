package com.example.parkme.ui.parkingspot;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.parkme.CarRepository;
import com.example.parkme.webservices.ParkingSpot;
import com.example.parkme.webservices.ParkingSpotRepository;

import java.util.List;

public class ParkingSpotViewModel extends AndroidViewModel {

    ParkingSpotRepository repository;


    public ParkingSpotViewModel(Application application) {
        super(application);
       repository = ParkingSpotRepository.getInstance(application);
    }

    public LiveData<List<ParkingSpot>> getParkingSpotMutableLiveData()
    {
        return repository.getParkingSpotsMutableLiveData();
    }
//    public  List<ParkingSpot> getAllParkingSpotsInList()
//    {
//        return repository.getParkingSpotsMutableLiveData().getValue();
//    }

    public void setParkingSpotMutableLiveData()
    {
        repository.setParkingSpotsMutableLiveData();
    }

}
