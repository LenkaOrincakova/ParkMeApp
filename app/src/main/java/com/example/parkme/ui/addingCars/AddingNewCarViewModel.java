package com.example.parkme.ui.addingCars;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.parkme.architecture.database.CarRepository;
import com.example.parkme.model.Car;

import java.util.List;

public class AddingNewCarViewModel extends AndroidViewModel {

    private final CarRepository repository;

    public AddingNewCarViewModel(@NonNull Application application) {
        super(application);
        repository = CarRepository.getInstance(application);
    }
    public void addNewCar(String name, String type)
    {
        Car car = new Car(name, type);
        int num = (int) (Math.random() * 9 +1) *1000;
        repository.insert(car);
    }
    public LiveData<List<Car>> getAllCars() {
       return repository.getAllCars();
    }
}
