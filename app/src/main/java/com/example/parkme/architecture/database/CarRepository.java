package com.example.parkme.architecture.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.parkme.model.Car;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarRepository {

    private CarDAO carDAO;
    private static CarRepository instance;
    private LiveData<List<Car>> allCars;
    private final ExecutorService executorService;

    private CarRepository(Application application){
        CarDatabase database = CarDatabase.getInstance(application);
        carDAO = database.carDAO();
        allCars = carDAO.getAllCars();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized CarRepository getInstance(Application application){
        if(instance==null)
            instance = new CarRepository(application);
        return instance;
    }


    public LiveData<List<Car>> getAllCars()
    {
        return allCars;
    }
    public void insert(Car car)
    {
       executorService.execute(() -> carDAO.insert(car));
    }
    public void deleteCar(Car car)
    {
        executorService.execute(() -> carDAO.delete(car));
    }
    public void deleteAllCars()
    {
        executorService.execute(carDAO::deleteAllCars);
    }

}
