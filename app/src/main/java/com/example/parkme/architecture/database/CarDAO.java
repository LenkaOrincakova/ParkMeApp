package com.example.parkme.architecture.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.parkme.model.Car;

import java.util.List;
@Dao
public interface CarDAO {
    @Insert
    void insert(Car car);
//    @Update
//    void update(Car car);
    @Delete
    void delete(Car car);

    @Query("SELECT * FROM car_table ORDER BY name")
    LiveData<List<Car>> getAllCars();

    @Query("DELETE FROM car_table")
    void deleteAllCars();



}
