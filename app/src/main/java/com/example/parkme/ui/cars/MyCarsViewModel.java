package com.example.parkme.ui.cars;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.parkme.CarRepository;
import com.example.parkme.model.Car;
import com.example.parkme.user.UserRepository;
import com.firebase.ui.auth.data.model.User;

import java.util.List;

public class MyCarsViewModel extends AndroidViewModel {
    private MutableLiveData <String> mText;
    CarRepository carRepository;
    UserRepository userRepository;


    public MyCarsViewModel(Application application) {
        super(application);
        mText = new MutableLiveData<>();
        mText.setValue("This is cars fragment");
        this.carRepository = CarRepository.getInstance(application);
        this.userRepository = UserRepository.getInstance(application);

    }

    public LiveData<List<Car>> getAllCars()
    {
        return carRepository.getAllCars();

    }
    public List<Car> getAllCarsInList()
    {
        return carRepository.getAllCars().getValue();
    }
    public LiveData<String> getText()
    {
        return mText;
    }
    public void deleteCar(Car car)
    {
        carRepository.deleteCar(car);
    }
}
