package com.example.parkme.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.parkme.model.Car;

@Database(entities = {Car.class}, version = 1)
public abstract class CarDatabase extends RoomDatabase {
    private static CarDatabase instance;
    public abstract CarDAO carDAO();

    public static synchronized CarDatabase getInstance(Context context){
        if(instance==null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(), CarDatabase.class, "car_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build();
        }
        return instance;
    }




}
