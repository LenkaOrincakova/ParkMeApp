package com.example.parkme.ui.parkingspot;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.parkme.model.ParkingSpot;
import com.example.parkme.architecture.webservices.ParkingSpotRepository;

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
    public void setParkingSpotMutableLiveData()
    {
        repository.setParkingSpotsMutableLiveData();
    }
}
